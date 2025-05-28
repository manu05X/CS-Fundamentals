package com.manish.LLD.ECommerceLoyalty.Type1.service;


import com.manish.LLD.ECommerceLoyalty.Type1.model.UserLevel;

public class PointsCalculator {
    public double calculatePoints(double amount, UserLevel level) {
        return (amount / 100) * level.getPointsPer100();
    }
}