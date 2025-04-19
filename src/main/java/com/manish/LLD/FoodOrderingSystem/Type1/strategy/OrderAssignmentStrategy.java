package com.manish.LLD.FoodOrderingSystem.Type1.strategy;

import com.manish.LLD.FoodOrderingSystem.Type1.model.Order;
import com.manish.LLD.FoodOrderingSystem.Type1.model.Restaurant;

import java.util.List;

public interface OrderAssignmentStrategy {
    Restaurant assignOrder(List<Restaurant> restaurants, Order order);
}
