package com.manish.LLD.FlashSale.Type1;

import com.manish.LLD.FlashSale.Type1.model.*;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

/*
public class FlashSaleSystem {
    private ConcurrencyControlStrategy concurrencyControlStrategy;
    private InventoryManager inventoryManager;
    private OrderProcessingStrategy orderProcessingStrategy;

    public FlashSaleSystem(ConcurrencyControlStrategy concurrencyControlStrategy, OrderProcessingStrategy orderProcessingStrategy) {
        this.concurrencyControlStrategy = concurrencyControlStrategy;
        this.orderProcessingStrategy = orderProcessingStrategy;
        this.inventoryManager = InventoryManager.getInstance();
    }

    // Method to switch the concurrency control strategy at runtime
    public void setConcurrencyControlStrategy(ConcurrencyControlStrategy strategy) {
        this.concurrencyControlStrategy = strategy;
    }

    // Method to switch the order processing strategy at runtime
    public void setOrderProcessingStrategy(OrderProcessingStrategy strategy) {
        this.orderProcessingStrategy = strategy;
    }

    public void processOrder(Order order) throws InterruptedException {
        concurrencyControlStrategy.acquireLock();
        try {
            orderProcessingStrategy.processOrder(order, inventoryManager);
        } finally {
            concurrencyControlStrategy.releaseLock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Product product1 = new Product(1, "Product1");
        Product product2 = new Product(2, "Product2");

        InventoryManager inventoryManager = InventoryManager.getInstance();
        inventoryManager.updateInventory(product1, 100);
        inventoryManager.updateInventory(product2, 50);

        // Create the FlashSaleSystem with default strategies
        ConcurrencyControlStrategy concurrencyControlStrategy = new TwoPhaseLockingStrategy();
        OrderProcessingStrategy orderProcessingStrategy = new DefaultOrderProcessingStrategy();
        FlashSaleSystem flashSaleSystem = new FlashSaleSystem(concurrencyControlStrategy, orderProcessingStrategy);

        // Create orders
        Order order1 = new FlashSaleOrder(product1, 80);
        Order order2 = new FlashSaleOrder(product2, 60);

        // Process orders
        flashSaleSystem.processOrder(order1);
        flashSaleSystem.processOrder(order2);
    }
}

 */

public class FlashSaleSystem {
    private ConcurrencyControlStrategy concurrencyControlStrategy;
    private InventoryManager inventoryManager;
    private OrderProcessingStrategy orderProcessingStrategy;

    public FlashSaleSystem(ConcurrencyControlStrategy concurrencyControlStrategy, OrderProcessingStrategy orderProcessingStrategy) {
        this.concurrencyControlStrategy = concurrencyControlStrategy;
        this.orderProcessingStrategy = orderProcessingStrategy;
        this.inventoryManager = InventoryManager.getInstance();
    }

    public void setConcurrencyControlStrategy(ConcurrencyControlStrategy strategy) {
        this.concurrencyControlStrategy = strategy;
    }

    public void setOrderProcessingStrategy(OrderProcessingStrategy strategy) {
        this.orderProcessingStrategy = strategy;
    }

    public void processOrder(Order order) {
        TransactionManager transactionManager = new TransactionManager();
        transactionManager.beginTransaction();
        try {
            Transaction transaction = new Transaction(1,order);

            if (concurrencyControlStrategy.validateTransaction(transaction)) {
                transactionManager.commitTransaction();
            } else {
                System.out.println("Transaction validation failed");
                transactionManager.rollbackTransaction();
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            transactionManager.rollbackTransaction();
        }
    }

    public static void main(String[] args) {
        // Initialize products
        Product product1 = new Product(1, "Product1");
        Product product2 = new Product(2, "Product2");

        // Get InventoryManager instance and add stock
        InventoryManager inventoryManager = InventoryManager.getInstance();
        inventoryManager.updateInventory(product1, 100);
        inventoryManager.updateInventory(product2, 50);

        // Initialize concurrency control and order processing strategies
        ConcurrencyControlStrategy concurrencyControlStrategy = new OptimisticConcurrencyControlStrategy();
        OrderProcessingStrategy orderProcessingStrategy = new DefaultOrderProcessingStrategy();

        // Initialize Flash Sale System
        FlashSaleSystem flashSaleSystem = new FlashSaleSystem(concurrencyControlStrategy, orderProcessingStrategy);

        // Create and process orders
        Order order1 = new FlashSaleOrder(product1, 80);
        Order order2 = new FlashSaleOrder(product2, 60);

        flashSaleSystem.processOrder(order1);
        flashSaleSystem.processOrder(order2);
    }
}


/*
Why This Fix Works?
✅ Ensures Interface Compliance → Implements acquireLock() and releaseLock(), avoiding compilation errors.
✅ Optimized for OCC → Leaves locking methods empty since OCC does not require explicit locks.
✅ Validates Transaction Properly → Ensures that product availability is checked before committing.

Now your code should compile and work correctly! 🚀 Let me know if you need further improvements!

 */