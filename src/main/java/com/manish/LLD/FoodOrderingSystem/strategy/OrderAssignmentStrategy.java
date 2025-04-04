package com.manish.LLD.FoodOrderingSystem.strategy;

import com.manish.LLD.FoodOrderingSystem.model.Order;
import com.manish.LLD.FoodOrderingSystem.model.Restaurant;

import java.util.List;

public interface OrderAssignmentStrategy {
    Restaurant assignOrder(List<Restaurant> restaurants, Order order);
}
