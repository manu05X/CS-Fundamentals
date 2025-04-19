package com.manish.LLD.ECommerceLoyalty.model;

public enum UserLevel {
    BRONZE(0, 499, 10, 0.05, 200),
    SILVER(500, 999, 12.5, 0.10, 500),
    GOLD(1000, Double.MAX_VALUE, 15, 0.15, 1000);

    private final double minPoints;
    private final double maxPoints;
    private final double pointsPer100;
    private final double maxRedemptionPercentage;
    private final double maxRedeemablePoints;

    UserLevel(double minPoints, double maxPoints, double pointsPer100, 
             double maxRedemptionPercentage, double maxRedeemablePoints) {
        this.minPoints = minPoints;
        this.maxPoints = maxPoints;
        this.pointsPer100 = pointsPer100;
        this.maxRedemptionPercentage = maxRedemptionPercentage;
        this.maxRedeemablePoints = maxRedeemablePoints;
    }

    public static UserLevel fromPoints(double points) {
        for (UserLevel level : values()) {
            if (points >= level.minPoints && points <= level.maxPoints) {
                return level;
            }
        }
        return BRONZE;
    }

    public double getPointsPer100() {
        return pointsPer100;
    }

    public double getMaxRedemptionPercentage() {
        return maxRedemptionPercentage;
    }

    public double getMaxRedeemablePoints() {
        return maxRedeemablePoints;
    }
}