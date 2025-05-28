package com.manish.LLD.ECommerceLoyalty.Type2.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String name;
    private double points;
    private int totalOrders;
    private double totalSpent;
    private boolean discountUsed = false;

    public User(String name) {
        this.name = name;
        this.points = 0;
        this.totalOrders = 0;
        this.totalSpent = 0;
    }

    public void addPoints(double points) {
        this.points += points;
    }

    public void deductPoints(double points) {
        this.points -= points;
    }

    public void incrementTotalOrders() {
        this.totalOrders++;
    }

    public void addToTotalSpent(double amount) {
        this.totalSpent += amount;
    }

    public UserLevel getLevel() {
        return UserLevel.fromPoints(points);
    }

    public boolean qualifiesForDiscount() {
        return totalOrders > 3 || totalSpent > 10000;
    }

    public double calculateDiscount(double amountAfterRedemption) {
        if (discountUsed || !qualifiesForDiscount()) {
            return 0;
        }

        double discountPercentage = getDiscountPercentage();
        double discount = amountAfterRedemption * discountPercentage;
        discount = Math.min(discount, 750);
        if (discount > 0) {
            discountUsed = true;
        }
        return discount;
    }

    private double getDiscountPercentage() {
        if (totalOrders > 3 && totalSpent > 10000) {
            return 0.12;
        } else if (totalOrders > 3) {
            return 0.05; // This is our case
        } else if (totalSpent > 10000) {
            return 0.10;
        }
        return 0;
    }

    public void resetDiscountIfNeeded() {
        if (!qualifiesForDiscount()) {
            discountUsed = false;
        }
    }
}