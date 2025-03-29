package com.manish.LLD.FlashSale.Type1.model;

public interface OrderProcessingStrategy {
    void processOrder(Order order, InventoryManager inventoryManager);
}