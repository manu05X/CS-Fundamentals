package com.manish.Thread.Practice.NotesR.Ex9;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterWithLock {
    private int count = 0;
    private final Lock lock = new ReentrantLock(); // Make lock final
    
    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock(); // Ensure lock is always released
        }
    }
    
    // Synchronized getter for thread-safe read access
    public synchronized int getCount() {
        return count;
    }
}