package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities.SemaphoreExample;


public class SemaphoreExample {
    public SemaphoreExample() {
    }

    public static void main(String[] args) {
        // Create shared resource protected by semaphore
        SharedResource resource = new SharedResource();

        // Create three worker threads
        WorkerThread t1 = new WorkerThread(resource, "Thread-1");
        WorkerThread t2 = new WorkerThread(resource, "Thread-2");
        WorkerThread t3 = new WorkerThread(resource, "Thread-3");

        // Start all threads
        t1.start();
        t2.start();
        t3.start();

        try {
            // Wait for all threads to complete
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException var6) {
            InterruptedException e = var6;
            e.printStackTrace();
        }
    }
}

/*

Initialization:
    A SharedResource is created with a semaphore of 2 permits
    Three worker threads are created to access this resource

Execution:
    Thread-1 and Thread-2 acquire the first two permits and start working
    Thread-3 blocks because no permits are available (semaphore count = 0)
    After 1 second, Thread-1 and Thread-2 release their permits
    Thread-3 then acquires a permit and executes


 */