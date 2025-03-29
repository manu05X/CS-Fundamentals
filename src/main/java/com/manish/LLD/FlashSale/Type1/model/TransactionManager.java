package com.manish.LLD.FlashSale.Type1.model;

public class TransactionManager {

    public void beginTransaction() {
        // Begin transaction logic
        System.out.println("Transaction started");
    }

    public void commitTransaction() {
        // Commit transaction logic
        System.out.println("Transaction committed");
    }

    public void rollbackTransaction() {
        // Rollback transaction logic
        System.out.println("Transaction rolled back");
    }
}
