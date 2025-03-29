package com.manish.LLD.FlashSale.Type1.model;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/*
public class InventoryManager {
    private static InventoryManager instance;
    private Map<Product, Integer> inventory;

    private InventoryManager(){
        inventory = new HashMap<>();
    }

    public static synchronized InventoryManager getInstance(){
        if(instance == null){
            instance = new InventoryManager();
        }

        return instance;
    }

    public synchronized void updateInventory(Product product, int quantity) {
        int currentQuantity = inventory.getOrDefault (product, 0);
        inventory.put(product, currentQuantity + quantity);
    }

    public synchronized boolean checkAvailability(Product product, int quantity){
        return inventory.getOrDefault (product, 0) >= quantity;
    }
}

 */


/*
Don't you think Locking will be a bottleneck because this is a flash sale so thousands/millions of orders will come within a seconds and having locs on method level will be a huge bottlenect and this will block all calls which will increase loads on server which can lead to crash
at the end. I
For a flash sale system where thousands of orders are processed within seconds, traditional locking mechanisms can become a bottleneck. Instead, more advanced concurrency control mechanisms like Optimistic Concurrency Control (OCC) and Multi-Version Concurrency Control (MVCC) can help mitigate this issue. These methods reduce contention and improve performance by allowing more concurrency.
Here's an updated version of the Flash Sale System using OCC and MVCC for better scalability and performance:
I'll highlight only the changes and additions relevant to implementing MVCC and OCC in the flash sale system.
 */

public class InventoryManager {
    private static final InventoryManager instance = new InventoryManager(); // Singleton instance
    private ConcurrentHashMap<Product, AtomicInteger> inventory;

    private InventoryManager() {
        inventory = new ConcurrentHashMap<>();
    }

    // Public method to get the single instance
    public static InventoryManager getInstance() {
        return instance;
    }

    public void updateInventory(Product product, int quantity) {
        inventory.compute(product, (key, value) -> {
            if (value == null) {
                return new AtomicInteger(quantity); // Initialize if absent
            } else {
                value.addAndGet(quantity); // Update existing AtomicInteger
                return value;
            }
        });
    }

    public boolean checkAvailability(Product product, int quantity) {
        return inventory.getOrDefault(product, new AtomicInteger(0)).get() >= quantity;
    }
}