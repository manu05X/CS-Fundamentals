// FoodOrderingApp.java
package com.manish.LLD.FoodOrderingSystem;


import com.manish.LLD.FoodOrderingSystem.enums.AssignmentStrategy;
import com.manish.LLD.FoodOrderingSystem.model.Order;
import com.manish.LLD.FoodOrderingSystem.model.Restaurant;
import com.manish.LLD.FoodOrderingSystem.system.FoodOrderingSystem;

import java.util.HashMap;
import java.util.Map;

public class FoodOrderingApp {
    public static void main(String[] args) {
        FoodOrderingSystem system = new FoodOrderingSystem();

        // Onboard restaurants
        Restaurant r1 = new Restaurant("R1", "Restaurant 1", 4.5, 5);
        r1.addMenuItem("Veg Biryani", 100);
        r1.addMenuItem("Chicken Biryani", 150);
        system.onboardRestaurant(r1);

        Restaurant r2 = new Restaurant("R2", "Restaurant 2", 4.0, 5);
        r2.addMenuItem("Chicken Biryani", 175);
        r2.addMenuItem("Idli", 10);
        r2.addMenuItem("Dosa", 50);
        r2.addMenuItem("Veg Biryani", 80);
        system.onboardRestaurant(r2);

        Restaurant r3 = new Restaurant("R3", "Restaurant 3", 4.9, 1);
        r3.addMenuItem("Gobi Manchurian", 150);
        r3.addMenuItem("Idli", 15);
        r3.addMenuItem("Chicken Biryani", 175);
        r3.addMenuItem("Dosa", 30);
        system.onboardRestaurant(r3);

        // Update menu
        system.updateRestaurantMenu("R1", "Chicken65", 250, false);
        system.updateRestaurantMenu("R2", "Chicken Biryani", 150, true);

        // Place orders
        Map<String, Integer> order1Items = new HashMap<>();
        order1Items.put("Idli", 3);
        order1Items.put("Dosa", 1);
        Order order1 = system.placeOrder("Ashwin", order1Items, AssignmentStrategy.LOWEST_COST);

        // ... rest of the demo code from original implementation
        System.out.println("Order1 assigned to: " + order1.getAssignedRestaurant().getId());

        Map<String, Integer> order2Items = new HashMap<>();
        order2Items.put("Idli", 3);
        order2Items.put("Dosa", 1);
        Order order2 = system.placeOrder("Harish", order2Items, AssignmentStrategy.LOWEST_COST);
        System.out.println("Order2 assigned to: " + order2.getAssignedRestaurant().getId());

        Map<String, Integer> order3Items = new HashMap<>();
        order3Items.put("Veg Biryani", 3);
        Order order3 = system.placeOrder("Shruthi", order3Items, AssignmentStrategy.HIGHEST_RATING);
        System.out.println("Order3 assigned to: " + order3.getAssignedRestaurant().getId());

        // Complete order
        system.completeOrder("R3", order1.getId());

        // Place another order
        Order order4 = system.placeOrder("Harish", order1Items, AssignmentStrategy.LOWEST_COST);
        System.out.println("Order4 assigned to: " + order4.getAssignedRestaurant().getId());

        // Try to place order with unavailable items
        try {
            Map<String, Integer> order5Items = new HashMap<>();
            order5Items.put("Paneer Tikka", 1);
            order5Items.put("Idli", 1);
            Order order5 = system.placeOrder("xyz", order5Items, AssignmentStrategy.LOWEST_COST);
        } catch (Exception e) {
            System.out.println("Order5 failed: " + e.getMessage());
        }

        // Update restaurant capacity
        system.updateRestaurantCapacity("R3", 2);
        System.out.println("R3 capacity updated to: " + system.getRestaurant("R3").getMaxOrderCapacity());
    }
}