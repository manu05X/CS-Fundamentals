package com.manish.Thread.Practice.YT1.D_Lock.C_ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    // Create a ReentrantLock object -> this maintains the count of no of time the lock has been acquired and unlocked
    private final Lock lock = new ReentrantLock();

    /**
     * Outer method that acquires the lock and calls the inner method.
     */
    public void outerMethod() {
        // Acquire the lock
        lock.lock();
        try {
            System.out.println("Outer method");
            // Call the inner method
            innerMethod();
        } finally {
            // Release the lock in the finally block to ensure it is always released
            lock.unlock();
        }
    }

    /**
     * Inner method that also acquires the lock.
     */
    public void innerMethod() {
        // Acquire the lock again
        // so in normal case the same thread is acquiring lock on same thread this forms a dead-lock
        lock.lock(); // since java have ReentrantLock i.e re-enter-lock so in java we can re-enter lock on same thread again
        try {
            System.out.println("Inner method");
        } finally {
            // Release the lock in the finally block to ensure it is always released
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        // Create an instance of ReentrantExample
        ReentrantExample example = new ReentrantExample();
        // Call the outer method
        example.outerMethod();
    }
}

/*
lock
unlock
tryLock
deadlock prevention
lock Interruptibly()

* */