package com.manish.LLD.FoodOrderingSystem.strategy;

import com.manish.LLD.FoodOrderingSystem.model.Order;
import com.manish.LLD.FoodOrderingSystem.model.Restaurant;

import java.util.List;

public class HighestRatingStrategy implements OrderAssignmentStrategy{
    @Override
    public Restaurant assignOrder(List<Restaurant> restaurants, Order order) {
        Restaurant selected = null;
        double maxRating = -1;

        for(Restaurant restaurant : restaurants){
            if(restaurant.canAcceptOrder() && restaurant.canFulfillOrder(order.getItems())){
                if(restaurant.getRating() > maxRating){
                    maxRating = restaurant.getRating();
                    selected = restaurant;
                }
            }
        }

        return selected;
    }
}
