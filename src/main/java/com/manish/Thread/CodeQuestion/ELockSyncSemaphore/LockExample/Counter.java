package com.manish.Thread.CodeQuestion.ELockSyncSemaphore.LockExample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count = 0; // Instance variable to hold the count value
    private final Lock lock = new ReentrantLock(); // Lock object to ensure thread safety

    // Method to increment the count using an explicit lock
    public void increment() {
        lock.lock(); // Acquire the lock before modifying the count
        try {
            count++; // Increment the count
        } finally {
            lock.unlock(); // Always release the lock in the finally block to avoid deadlocks
        }
    }

    // Method to get the current value of the count
    public int getCount() {
        return count; // Return the current count value
    }
}
