package com.manish.Thread.Practice.NotesR.Ex12;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) {
        // Initialize CountDownLatch with count 2 (for 2 worker threads)
        final CountDownLatch latch = new CountDownLatch(2);

        // Worker Thread 1: Simulates API call with 1 second processing
        Thread worker1 = new Thread(() -> {
            System.out.println("[Worker-1] Starting API 1 call...");
            try {
                Thread.sleep(1000); // Simulate API processing time
                System.out.println("[Worker-1] API 1 call completed successfully");
            } catch (InterruptedException e) {
                System.err.println("[Worker-1] was interrupted!");
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown(); // Decrement latch count when done
                System.out.println("[Worker-1] Latch count decreased to: " + latch.getCount());
            }
        });

        // Worker Thread 2: Simulates API call with 2 seconds processing
        Thread worker2 = new Thread(() -> {
            System.out.println("[Worker-2] Starting API 2 call...");
            try {
                Thread.sleep(2000); // Simulate longer API processing time
                System.out.println("[Worker-2] API 2 call completed successfully");
            } catch (InterruptedException e) {
                System.err.println("[Worker-2] was interrupted!");
                Thread.currentThread().interrupt();
            } finally {
                latch.countDown(); // Decrement latch count when done
                System.out.println("[Worker-2] Latch count decreased to: " + latch.getCount());
            }
        });

        System.out.println("[Main] Starting both workers...");
        worker1.start();
        worker2.start();

        // Main thread waits for both workers to complete
        System.out.println("[Main] Waiting for workers to finish...");
        try {
            latch.await(); // Blocks until latch count reaches 0
            System.out.println("[Main] All workers completed! Latch count: " + latch.getCount());
        } catch (InterruptedException e) {
            System.err.println("[Main] was interrupted while waiting!");
            Thread.currentThread().interrupt();
        }

        System.out.println("[Main] Continuing with main program execution...");
    }
}