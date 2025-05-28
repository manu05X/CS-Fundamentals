package com.manish.LLD.ECommerceLoyalty.Type2.service;

import com.manish.LLD.ECommerceLoyalty.Type2.model.User;
import com.manish.LLD.ECommerceLoyalty.Type2.model.UserLevel;
import com.manish.LLD.ECommerceLoyalty.Type2.repository.UserRepository;

public class GamificationService {
    private final UserRepository userRepository;
    private final PointsCalculator pointsCalculator;
    private final RedemptionValidator redemptionValidator;
    private final DiscountCalculator discountCalculator;

    public GamificationService(UserRepository userRepository,
                               PointsCalculator pointsCalculator,
                               RedemptionValidator redemptionValidator,
                               DiscountCalculator discountCalculator) {
        this.userRepository = userRepository;
        this.pointsCalculator = pointsCalculator;
        this.redemptionValidator = redemptionValidator;
        this.discountCalculator = discountCalculator;
    }

    public void onboardUser(String userName) {
        if (userRepository.exists(userName)) {
            throw new IllegalArgumentException("User already exists");
        }
        User user = new User(userName);
        userRepository.save(user);
    }

    public String purchase(String userName, double orderAmount, double pointsToRedeem) {
        User user = userRepository.findByName(userName);
        if (user == null) {
            return "Purchase failed. User not found.";
        }

        // 1. Validate redemption
        double actualRedemption = redemptionValidator.validateRedemption(user, orderAmount, pointsToRedeem);
        if (actualRedemption == -1) {
            return "Purchase failed. Not enough points to redeem.";
        }

        // 2. Calculate amount after redemption
        double amountAfterRedemption = orderAmount - actualRedemption;

        // 3. Calculate discount using user's method
        double discount = user.calculateDiscount(amountAfterRedemption);
        double finalAmount = amountAfterRedemption - discount;

        // 4. Calculate points earned on final amount
        double pointsEarned = pointsCalculator.calculatePoints(finalAmount, user.getLevel());

        // 5. Update user state
        if (actualRedemption > 0) {
            user.deductPoints(actualRedemption);
        }
        user.addPoints(pointsEarned);
        user.incrementTotalOrders();
        user.addToTotalSpent(finalAmount);
        user.resetDiscountIfNeeded();
        userRepository.save(user);

        // 6. Prepare response
        StringBuilder response = new StringBuilder("Purchase successful. ");
        if (actualRedemption > 0) {
            response.append(String.format("Points redeemed: %.1f. ", actualRedemption));
        }
        response.append(String.format("Points added: %.1f. ", pointsEarned));
        if (discount > 0) {
            response.append(String.format("Discount applied: %.1f. ", discount));
        }
        response.append(String.format("Total payable amount: %.2f. ", finalAmount));
        response.append(String.format("Current points: %.1f. ", user.getPoints()));
        response.append(String.format("Current level: %s. ", user.getLevel()));
        response.append(String.format("Orders count: %d", user.getTotalOrders()));

        return response.toString();
    }

    public String getUserStats(String userName) {
        User user = userRepository.findByName(userName);
        if (user == null) {
            return "User not found.";
        }
        return String.format("%s has %.1f points. Current level: %s.",
                userName, user.getPoints(), user.getLevel());
    }
}