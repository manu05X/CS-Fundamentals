package com.manish.LLD.FlashSale.Type1.model;

public class StrictTwoPhaseLockingStrategy implements ConcurrencyControlStrategy {
    private boolean locked = false;

    @Override
    public synchronized void acquireLock() throws InterruptedException {
        while (locked) {
            wait();
        }
        locked = true;
    }

    @Override
    public synchronized void releaseLock() {
        locked = false;
        notify();
    }

    @Override
    public boolean validateTransaction(Transaction transaction) {
        // Implement validation logic for Strict Two-Phase Locking
        return true;
    }
}