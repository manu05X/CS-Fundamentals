package com.manish.LLD.FlashSale.Type1.model;

//public class OptimisticConcurrencyControlStrategy implements ConcurrencyControlStrategy {
//
//    @Override
//    public boolean validateTransaction(Transaction transaction) {
//        // Validate the transaction by checking the availability before committing
//        FlashSaleOrder order = (FlashSaleOrder) transaction.getOrder();
//        InventoryManager inventoryManager = InventoryManager.getInstance();
//
//        // Check availability of the product before committing
//        return inventoryManager.checkAvailability(order.getProduct(), order.getQuantity());
//    }
//}

public class OptimisticConcurrencyControlStrategy implements ConcurrencyControlStrategy {

    @Override
    public void acquireLock() {
        // No-op: Optimistic Concurrency Control doesn't use explicit locks
    }

    @Override
    public void releaseLock() {
        // No-op: Optimistic Concurrency Control doesn't use explicit locks
    }

    @Override
    public boolean validateTransaction(Transaction transaction) {
        // Validate the transaction by checking availability before committing
        FlashSaleOrder order = (FlashSaleOrder) transaction.getOrder();
        InventoryManager inventoryManager = InventoryManager.getInstance();

        // Check product availability before committing
        return inventoryManager.checkAvailability(order.getProduct(), order.getQuantity());
    }
}

