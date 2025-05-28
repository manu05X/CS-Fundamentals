package com.manish.Thread.concurrency.MultithreadingExpense.PerformanceDegradationExample;

public class PerformanceDegradationExample {
    private static final int NUM_THREADS = 100;
    private static final int NUM_ITERATIONS = 100000;

    public static void main(String[] args) throws InterruptedException{
        Runnable task = () -> {
            for(int i = 0; i < NUM_ITERATIONS; i++){
                // Perform a small task
            }
        };

        Thread[] threads = new Thread[NUM_THREADS];
        for(int i = 0; i < NUM_THREADS; i++){
            threads[i] = new Thread(task);
        }

        long startTime = System.currentTimeMillis();
        for(Thread t1 : threads){
            t1.start();
        }

        for(Thread t2 : threads){
            t2.join();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Time take : " + (endTime - startTime) + " ms");
    }
}

/*

Explanation: If not properly managed, the overhead from context switching, synchronization, and contention
                can outweigh the benefits of multithreading.

Cost: Instead of improving performance, poorly designed multithreaded applications can perform worse
       than their single-threaded counterparts.

 */


