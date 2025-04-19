package com.manish.LLD.ECommerceLoyalty.service;


import com.manish.LLD.ECommerceLoyalty.model.User;
import com.manish.LLD.ECommerceLoyalty.model.UserLevel;
import com.manish.LLD.ECommerceLoyalty.repository.UserRepository;

public class GamificationService {
    private UserRepository userRepository;
    private PointsCalculator pointsCalculator;
    private RedemptionValidator redemptionValidator;
    private DiscountCalculator discountCalculator;

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

        // Validate and calculate actual redemption
        double actualRedemption = redemptionValidator.validateRedemption(user, orderAmount, pointsToRedeem);
        if (actualRedemption == -1) {
            return "Purchase failed. Not enough points to redeem.";
        }

        // Calculate amount after redemption
        double amountAfterRedemption = orderAmount - actualRedemption;
        
        // Calculate discount (bonus feature)
        double discount = discountCalculator.calculateDiscount(user, amountAfterRedemption);
        double finalAmount = amountAfterRedemption - discount;
        
        // Calculate points earned
        UserLevel level = user.getLevel();
        double pointsEarned = pointsCalculator.calculatePoints(finalAmount, level);
        
        // Update user state
        if (actualRedemption > 0) {
            user.deductPoints(actualRedemption);
        }
        user.addPoints(pointsEarned);
        user.incrementTotalOrders();
        user.addToTotalSpent(finalAmount);
        userRepository.save(user);
        
        // Prepare response
        StringBuilder response = new StringBuilder();
        response.append("Purchase successful. ");
        if (actualRedemption > 0) {
            response.append(String.format("Points redeemed: %.1f. ", actualRedemption));
        }
        response.append(String.format("Points added: %.1f. ", pointsEarned));
        if (discount > 0) {
            response.append(String.format("Discount applied: %.1f. ", discount));
        }
        response.append(String.format("Total payable amount: %.2f. ", finalAmount));
        response.append(String.format("Current points: %.1f. ", user.getPoints()));
        response.append(String.format("Current level: %s", user.getLevel()));
        response.append(String.format(". Orders count: %d", user.getTotalOrders()));
        
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