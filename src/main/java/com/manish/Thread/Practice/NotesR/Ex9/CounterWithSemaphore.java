package com.manish.Thread.Practice.NotesR.Ex9;

import java.util.concurrent.Semaphore;

public class CounterWithSemaphore {
    private int count = 0;
    private final Semaphore semaphore = new Semaphore(1); // Binary semaphore acts as mutex
    
    public void increment() throws InterruptedException {
        semaphore.acquire();
        try {
            count++;
        } finally {
            semaphore.release(); // Ensure permit is always released
        }
    }
    
    // Synchronized getter for thread-safe read access
    public synchronized int getCount() {
        return count;
    }
}