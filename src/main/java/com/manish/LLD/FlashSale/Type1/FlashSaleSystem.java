package com.manish.LLD.FlashSale.Type1;

import com.manish.LLD.FlashSale.Type1.model.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class FlashSaleSystem {
    private Map<String, Product> products = new ConcurrentHashMap<>();
    private Map<String, FlashSale> flashSales = new ConcurrentHashMap<>();
    private Map<String, Inventory> inventories = new ConcurrentHashMap<>();
    private Map<String, User> users = new ConcurrentHashMap<>();
    private List<Order> orders = new CopyOnWriteArrayList<>();
    private Map<String, Lock> productLocks = new ConcurrentHashMap<>();

    public FlashSaleSystem() {
        initializeData();
    }

    private void initializeData() {
        Product p1 = new Product("p1", "Smartphone", "Latest model", new BigDecimal("999.99"), "Electronics");
        Product p2 = new Product("p2", "Laptop", "High performance", new BigDecimal("1499.99"), "Electronics");

        products.put(p1.getProductId(), p1);
        products.put(p2.getProductId(), p2);

        inventories.put(p1.getProductId(), new Inventory(p1.getProductId(), 100));
        inventories.put(p2.getProductId(), new Inventory(p2.getProductId(), 50));

        FlashSale fs = new FlashSale("fs1", LocalDateTime.now().plusMinutes(1), LocalDateTime.now().plusMinutes(31), FlashSaleStatus.UPCOMING);
        fs.addProduct(new FlashSaleProduct("fp1", "fs1", "p1", new BigDecimal("999.99"), new BigDecimal("799.99"), 10, 2));
        fs.addProduct(new FlashSaleProduct("fp2", "fs1", "p2", new BigDecimal("1499.99"), new BigDecimal("1199.99"), 5, 1));

        flashSales.put(fs.getFlashSaleId(), fs);

        users.put("u1", new User("u1", "Alice", "alice@example.com"));
        users.put("u2", new User("u2", "Bob", "bob@example.com"));

        productLocks.put("p1", new ReentrantLock());
        productLocks.put("p2", new ReentrantLock());
    }

    public static void main(String[] args) {
        FlashSaleSystem system = new FlashSaleSystem();
        system.flashSales.get("fs1").setStatus(FlashSaleStatus.ACTIVE);
    }
}