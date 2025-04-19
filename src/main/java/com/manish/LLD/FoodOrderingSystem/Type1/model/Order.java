package com.manish.LLD.FoodOrderingSystem.Type1.model;

import com.manish.LLD.FoodOrderingSystem.Type1.enums.OrderStatus;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private String id;
    private String user;
    private Map<String, Integer> items;
    private OrderStatus status;
    private Restaurant assignedRestaurant;
    private double totalCost;

    public Order(String id, String user, Map<String, Integer> items) {
        this.id = id;
        this.user = user;
        this.items = new HashMap<>(items);
        this.status = OrderStatus.PENDING;
    }

    public void assignToRestaurant(Restaurant restaurant, double totalCost) {
        this.assignedRestaurant = restaurant;
        this.totalCost = totalCost;
        this.status = OrderStatus.ACCEPTED;
    }

    public void markCompleted() {
        this.status = OrderStatus.COMPLETED;
    }

    // Getters
    public String getId() { return id; }
    public String getUser() { return user; }
    public Map<String, Integer> getItems() { return Collections.unmodifiableMap(items); }
    public OrderStatus getStatus() { return status; }
    public Restaurant getAssignedRestaurant() { return assignedRestaurant; }
    public double getTotalCost() { return totalCost; }
}
