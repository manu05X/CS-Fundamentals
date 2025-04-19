package com.manish.LLD.FoodOrderingSystem.Type1.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<String, MenuItem> items = new HashMap<>();

    public void addItem(String name, double price){
        items.put(name, new MenuItem(name, price));
    }

    public void updateItem(String name, double newPrice) {
        if (items.containsKey(name)) {
            items.get(name).setPrice(newPrice);
        } else {
            throw new IllegalArgumentException("Item not found in menu");
        }
    }

    public boolean containsItem(String name) {
        return items.containsKey(name);
    }

    public MenuItem getItem(String name) {
        return items.get(name);
    }


    public Map<String, MenuItem> getItems() {
        return Collections.unmodifiableMap(items);
    }

    public boolean canFulfillOrder(Map<String, Integer> orderItems) {
        return orderItems.keySet().stream().allMatch(this::containsItem);
    }


    public double calculateOrderCost(Map<String, Integer> orderItems) {
        double total = 0;
        for (Map.Entry<String, Integer> entry : orderItems.entrySet()) {
            String itemName = entry.getKey();
            int quantity = entry.getValue();
            if (!containsItem(itemName)) {
                throw new IllegalArgumentException("Item not found: " + itemName);
            }
            total += getItem(itemName).getPrice() * quantity;
        }
        return total;
    }

}
