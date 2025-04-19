// FoodOrderingSystem.java
package com.manish.LLD.FoodOrderingSystem.Type1.system;

import com.manish.LLD.FoodOrderingSystem.Type1.enums.AssignmentStrategy;
import com.manish.LLD.FoodOrderingSystem.Type1.enums.OrderStatus;
import com.manish.LLD.FoodOrderingSystem.Type1.model.Order;
import com.manish.LLD.FoodOrderingSystem.Type1.model.Restaurant;
import com.manish.LLD.FoodOrderingSystem.Type1.strategy.HighestRatingStrategy;
import com.manish.LLD.FoodOrderingSystem.Type1.strategy.LowestCostStrategy;
import com.manish.LLD.FoodOrderingSystem.Type1.strategy.MaxCapacityStrategy;
import com.manish.LLD.FoodOrderingSystem.Type1.strategy.OrderAssignmentStrategy;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FoodOrderingSystem {
    private Map<String, Restaurant> restaurants = new HashMap<>();
    private Map<String, Order> orders = new HashMap<>();
    private OrderAssignmentStrategy strategy;

    public void onboardRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getId(), restaurant);
    }

    public void updateRestaurantMenu(String restaurantId, String itemName, double price, boolean isUpdate) {
        Restaurant restaurant = restaurants.get(restaurantId);
        if (restaurant == null) {
            throw new IllegalArgumentException("Restaurant not found");
        }

        if (isUpdate) {
            restaurant.updateMenuItem(itemName, price);
        } else {
            restaurant.addMenuItem(itemName, price);
        }
    }

    public void setAssignmentStrategy(AssignmentStrategy strategyType) {
        switch (strategyType) {
            case LOWEST_COST:
                this.strategy = new LowestCostStrategy();
                break;
            case HIGHEST_RATING:
                this.strategy = new HighestRatingStrategy();
                break;
            case MAX_CAPACITY:
                this.strategy = new MaxCapacityStrategy();
                break;
            default:
                throw new IllegalArgumentException("Unknown strategy type");
        }
    }

    public Order placeOrder(String userId, Map<String, Integer> items, AssignmentStrategy strategyType) {
        setAssignmentStrategy(strategyType);
        
        boolean canFulfill = restaurants.values().stream()
            .anyMatch(r -> r.canFulfillOrder(items));
        
        if (!canFulfill) {
            throw new IllegalStateException("No restaurant can fulfill this order");
        }

        String orderId = "ORD-" + System.currentTimeMillis();
        Order order = new Order(orderId, userId, items);
        orders.put(orderId, order);

        List<Restaurant> availableRestaurants = restaurants.values().stream()
            .filter(r -> r.canFulfillOrder(items))
            .collect(Collectors.toList());

        Restaurant assignedRestaurant = strategy.assignOrder(availableRestaurants, order);
        if (assignedRestaurant == null) {
            throw new IllegalStateException("No available restaurant can accept the order at this time");
        }

        double totalCost = assignedRestaurant.calculateOrderCost(items);
        order.assignToRestaurant(assignedRestaurant, totalCost);
        assignedRestaurant.acceptOrder(order);

        return order;
    }

    public void completeOrder(String restaurantId, String orderId) {
        Restaurant restaurant = restaurants.get(restaurantId);
        if (restaurant == null) {
            throw new IllegalArgumentException("Restaurant not found");
        }

        Order order = orders.get(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Order not found");
        }

        if (order.getStatus() != OrderStatus.ACCEPTED ||
            !order.getAssignedRestaurant().getId().equals(restaurantId)) {
            throw new IllegalStateException("Cannot complete this order");
        }

        order.markCompleted();
        restaurant.completeOrder(orderId);
    }

    public void updateRestaurantCapacity(String restaurantId, int newCapacity) {
        Restaurant restaurant = restaurants.get(restaurantId);
        if (restaurant == null) {
            throw new IllegalArgumentException("Restaurant not found");
        }
        restaurant.setMaxOrderCapacity(newCapacity);
    }

    // Getters for testing
    public Restaurant getRestaurant(String id) {
        return restaurants.get(id);
    }

    public Order getOrder(String id) {
        return orders.get(id);
    }
}