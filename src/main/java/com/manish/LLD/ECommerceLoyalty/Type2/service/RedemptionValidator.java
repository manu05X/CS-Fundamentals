package com.manish.LLD.ECommerceLoyalty.Type2.service;


import com.manish.LLD.ECommerceLoyalty.Type2.model.User;
import com.manish.LLD.ECommerceLoyalty.Type2.model.UserLevel;

public class RedemptionValidator {
    public double validateRedemption(User user, double orderAmount, double pointsToRedeem) {
        UserLevel level = user.getLevel();
        
        // Check if user has enough points
        if (pointsToRedeem > user.getPoints()) {
            return -1; // Indicates not enough points
        }
        
        // Calculate maximum allowed redemption
        double maxByPercentage = orderAmount * level.getMaxRedemptionPercentage();
        double maxByPoints = level.getMaxRedeemablePoints();
        double maxAllowed = Math.min(maxByPercentage, maxByPoints);
        
        // Return the actual redemption amount (minimum of requested and allowed)
        return Math.min(pointsToRedeem, maxAllowed);
    }
}