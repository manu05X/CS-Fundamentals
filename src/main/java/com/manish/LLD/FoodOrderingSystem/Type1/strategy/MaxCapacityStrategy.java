// MaxCapacityStrategy.java
package com.manish.LLD.FoodOrderingSystem.Type1.strategy;

import com.manish.LLD.FoodOrderingSystem.Type1.model.Order;
import com.manish.LLD.FoodOrderingSystem.Type1.model.Restaurant;

import java.util.List;

public class MaxCapacityStrategy implements OrderAssignmentStrategy {
    @Override
    public Restaurant assignOrder(List<Restaurant> restaurants, Order order) {
        Restaurant selected = null;
        int maxCapacity = -1;

        for (Restaurant restaurant : restaurants) {
            if (restaurant.canAcceptOrder() && restaurant.canFulfillOrder(order.getItems())) {
                int capacity = restaurant.getRemainingCapacity();
                if (capacity > maxCapacity) {
                    maxCapacity = capacity;
                    selected = restaurant;
                }
            }
        }

        return selected;
    }
}