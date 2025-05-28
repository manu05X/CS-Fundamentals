package com.manish.LLD.ECommerceLoyalty.Type2.service;


import com.manish.LLD.ECommerceLoyalty.Type2.model.User;

public class DiscountCalculator {
    public double calculateDiscount(User user, double amountAfterRedemption) {
        boolean hasMoreThan3Orders = user.getTotalOrders() > 3;
        boolean hasSpentMoreThan10k = user.getTotalSpent() > 10000;
        
        double discountPercentage = 0;
        
        if (hasMoreThan3Orders && hasSpentMoreThan10k) {
            discountPercentage = 0.12;
        } else if (hasMoreThan3Orders) {
            discountPercentage = 0.05;
        } else if (hasSpentMoreThan10k) {
            discountPercentage = 0.10;
        }
        
        double discount = amountAfterRedemption * discountPercentage;
        return Math.min(discount, 750); // Cap at 750 as per problem statement
    }
}