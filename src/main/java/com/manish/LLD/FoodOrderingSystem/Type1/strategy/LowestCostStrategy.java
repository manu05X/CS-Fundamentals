package com.manish.LLD.FoodOrderingSystem.Type1.strategy;

import com.manish.LLD.FoodOrderingSystem.Type1.model.Order;
import com.manish.LLD.FoodOrderingSystem.Type1.model.Restaurant;

import java.util.List;

public class LowestCostStrategy implements OrderAssignmentStrategy{
    @Override
    public Restaurant assignOrder(List<Restaurant> restaurants, Order order) {
        Restaurant selected = null;

        double minCost = Double.MAX_VALUE;

        for(Restaurant restaurant : restaurants){
            if(restaurant.canAcceptOrder() && restaurant.canFulfillOrder(order.getItems())){
                double cost = restaurant.calculateOrderCost(order.getItems());

                if(cost < minCost){
                    minCost = cost;
                    selected = restaurant;
                }
            }
        }

        return selected;
    }
}
