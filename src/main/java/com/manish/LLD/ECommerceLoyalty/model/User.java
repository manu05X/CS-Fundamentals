package com.manish.LLD.ECommerceLoyalty.model;

public class User {
    private String name;
    private double points;
    private int totalOrders;
    private double totalSpent;

    public User(String name) {
        this.name = name;
        this.points = 0;
        this.totalOrders = 0;
        this.totalSpent = 0;
    }

    public String getName() {
        return name;
    }

    public double getPoints() {
        return points;
    }

    public void addPoints(double points) {
        this.points += points;
    }

    public void deductPoints(double points) {
        this.points -= points;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public void incrementTotalOrders() {
        this.totalOrders++;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public void addToTotalSpent(double amount) {
        this.totalSpent += amount;
    }

    public UserLevel getLevel() {
        return UserLevel.fromPoints(points);
    }
}