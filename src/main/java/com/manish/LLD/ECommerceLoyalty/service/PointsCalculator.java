package com.manish.LLD.ECommerceLoyalty.service;


import com.manish.LLD.ECommerceLoyalty.model.UserLevel;

public class PointsCalculator {
    public double calculatePoints(double amount, UserLevel level) {
        return (amount / 100) * level.getPointsPer100();
    }
}