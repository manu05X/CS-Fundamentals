package com.manish.Thread.CodeQuestion.AVolatile.RaceCondition;

public class RaceConditionExample {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // Create 10 threads, each incrementing the counter 1000 times
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
        }

        // Start all threads
        for (Thread thread : threads) {
            thread.start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Print the final counter value
        System.out.println("Final counter value: " + counter.getCount());
    }
}
