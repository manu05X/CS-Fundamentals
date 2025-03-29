package com.manish.LLD.FlashSale.Type1.model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TwoPhaseLockingStrategy implements ConcurrencyControlStrategy {
    private final Lock lock = new ReentrantLock();

    @Override
    public void acquireLock() {
        lock.lock();
    }

    @Override
    public void releaseLock() {
        lock.unlock();
    }

    @Override
    public boolean validateTransaction(Transaction transaction) {
        // Implement validation logic for Two-Phase Locking
        return true;
    }
}