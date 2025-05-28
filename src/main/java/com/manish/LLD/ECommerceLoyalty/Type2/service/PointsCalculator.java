package com.manish.LLD.ECommerceLoyalty.Type2.service;


import com.manish.LLD.ECommerceLoyalty.Type2.model.UserLevel;

public class PointsCalculator {
    public double calculatePoints(double amount, UserLevel level) {
        return (amount / 100) * level.getPointsPer100();
    }
}