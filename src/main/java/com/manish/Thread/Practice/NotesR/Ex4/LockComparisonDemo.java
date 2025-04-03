package com.manish.Thread.Practice.NotesR.Ex4;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class LockComparisonDemo {
    private int counter = 0;
    private final Object syncLock = new Object();
    private final Lock reentrantLock = new ReentrantLock(true); // Fair lock
    private final Semaphore semaphore = new Semaphore(2); // 2 permits

    // 1. synchronized method
    public void incrementSync() {
        synchronized (syncLock) {
            counter++;
            System.out.println(Thread.currentThread().getName() + " (synchronized): " + counter);
            //System.out.println("The Counter value is : " + counter);
        }
    }

    // 2. Lock method
    public void incrementLock() {
        reentrantLock.lock();
        try {
            counter++;
            System.out.println(Thread.currentThread().getName() + " (Lock): " + counter);
        } finally {
            reentrantLock.unlock();
        }
    }

    // 3. Semaphore method
    public void incrementSemaphore() throws InterruptedException {
        semaphore.acquire();
        try {
            counter++;
            System.out.println(Thread.currentThread().getName() + " (Semaphore): " + counter);
            Thread.sleep(100); // Simulate work
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockComparisonDemo demo = new LockComparisonDemo();
        int threadCount = 5;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        System.out.println("=== Testing synchronized ===");
        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                for (int j = 0; j < 3; j++) {
                    demo.incrementSync();
                }
            });
        }

        System.out.println("=== First for loop ends ===");

        Thread.sleep(2000); // Wait for completion
        demo.counter = 0; // Reset counter

        System.out.println("\n=== Testing Lock ===");
        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                for (int j = 0; j < 3; j++) {
                    demo.incrementLock();
                }
            });
        }

        System.out.println("=== Testing Lock Second for loop ends ===");

        Thread.sleep(2000);
        demo.counter = 0;

        System.out.println("\n=== Testing Semaphore (2 permits) ===");
        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    for (int j = 0; j < 4; j++) {
                        demo.incrementSemaphore();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("\nFinal counter value: " + demo.counter);
    }
}