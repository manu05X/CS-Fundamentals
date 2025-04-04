package com.manish.LLD.DeliveryP2PSystem;


import com.manish.LLD.DeliveryP2PSystem.model.*;
import com.manish.LLD.DeliveryP2PSystem.system.DeliverySystem;

public class DeliverySystemDemo {
    public static void main(String[] args) throws InterruptedException {
        DeliverySystem system = new DeliverySystem();

        // Setup items
        system.addItem(new Item("ITEM-1", "Documents", "Important documents"));
        system.addItem(new Item("ITEM-2", "Food", "Perishable food items"));
        system.addItem(new Item("ITEM-3", "Electronics", "Fragile electronics"));

        // Onboard customers
        system.onboardCustomer(new Customer("CUST-1", "Alice", "alice@example.com", "1111111111", "Bangalore"));
        system.onboardCustomer(new Customer("CUST-2", "Bob", "bob@example.com", "2222222222", "Mangalore"));

        // Onboard drivers
        system.onboardDriver(new Driver("DRIV-1", "John", "john@example.com", "3333333333"));
        system.onboardDriver(new Driver("DRIV-2", "Mike", "mike@example.com", "4444444444"));

        // Test cases
        String orderId1 = system.placeOrder("CUST-1", "ITEM-1");
        System.out.println("Order 1 status: " + system.getOrderStatus(orderId1));
        System.out.println("Driver 1 available: " + system.isDriverAvailable("DRIV-1"));

        Thread.sleep(1000);

        System.out.println("Order 1 status after assignment: " + system.getOrderStatus(orderId1));
        System.out.println("Driver 1 available after assignment: " + system.isDriverAvailable("DRIV-1"));

        String orderId2 = system.placeOrder("CUST-2", "ITEM-2");
        Thread.sleep(1000);
        System.out.println("Order 2 status: " + system.getOrderStatus(orderId2));

        String orderId3 = system.placeOrder("CUST-1", "ITEM-3");
        System.out.println("Order 3 status: " + system.getOrderStatus(orderId3));

        System.out.println("Driver 1 picks up order: " + system.pickupOrder("DRIV-1", orderId1));
        System.out.println("Order 1 status after pickup: " + system.getOrderStatus(orderId1));

        System.out.println("Try to cancel picked up order: " + system.cancelOrder(orderId1));

        System.out.println("Driver 1 delivers order: " + system.deliverOrder("DRIV-1", orderId1));
        System.out.println("Order 1 status after delivery: " + system.getOrderStatus(orderId1));
        System.out.println("Driver 1 available after delivery: " + system.isDriverAvailable("DRIV-1"));

        Thread.sleep(1000);
        System.out.println("Order 3 status after driver available: " + system.getOrderStatus(orderId3));

        System.out.println("Customer rates driver: " + system.rateDriver("CUST-1", orderId1, 5, "Great service!"));
        System.out.println("Driver 1 average rating: " + system.getAverageRating("DRIV-1"));

        System.out.println("\nTop drivers by rating:");
        system.getDashboard().getTopDriversByRating(5).forEach(d ->
                System.out.println(d.getName() + ": " + system.getAverageRating(d.getId())));

        System.out.println("\nTop drivers by orders completed:");
        system.getDashboard().getTopDriversByOrdersCompleted(5).forEach(d ->
                System.out.println(d.getName() + ": " + system.getCompletedOrdersCount(d.getId())));

        String orderId4 = system.placeOrder("CUST-2", "ITEM-3");
        System.out.println("\nOrder 4 placed, not assigned (no drivers available)");
        System.out.println("Order 4 status: " + system.getOrderStatus(orderId4));

        system.cancelOrder(orderId4);
        System.out.println("Order 4 status after timeout: " + system.getOrderStatus(orderId4));

        system.shutdown();
    }
}
