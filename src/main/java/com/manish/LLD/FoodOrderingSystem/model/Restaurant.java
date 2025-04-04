package com.manish.LLD.FoodOrderingSystem.model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Restaurant {
    private String id;
    private String name;
    private double rating;
    private int maxOrderCapacity;
    private Set<String> currentOrderIds = new HashSet<>();
    private Menu menu = new Menu();

    public Restaurant(String id, String name, double rating, int maxOrderCapacity){
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.maxOrderCapacity = maxOrderCapacity;
    }


    public boolean canAcceptOrder(){
        if (currentOrderIds.size() < maxOrderCapacity){
            return true;
        }
        return false;
    }

    public boolean acceptOrder(Order order){
        if(!canAcceptOrder() || !menu.canFulfillOrder(order.getItems())){
            return false;
        }

        currentOrderIds.add(order.getId());
        return true;
    }

    public void completeOrder(String orderId){
        currentOrderIds.remove(orderId);
    }

    public double calculateOrderCost(Map<String, Integer> orderItems){
        return menu.calculateOrderCost(orderItems);
    }

    public void addMenuItem(String name, double price) {
        menu.addItem(name, price);
    }

    public void updateMenuItem(String name, double newPrice) {
        menu.updateItem(name, newPrice);
    }

    public boolean canFulfillOrder(Map<String, Integer> orderItems) {
        return menu.canFulfillOrder(orderItems);
    }

    public int getRemainingCapacity() {
        return maxOrderCapacity - currentOrderIds.size();
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public double getRating() { return rating; }
    public int getMaxOrderCapacity() { return maxOrderCapacity; }
    public void setMaxOrderCapacity(int capacity) { this.maxOrderCapacity = capacity; }

}
