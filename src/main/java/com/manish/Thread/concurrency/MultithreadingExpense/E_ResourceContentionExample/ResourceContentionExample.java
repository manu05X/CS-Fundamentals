package com.manish.Thread.concurrency.MultithreadingExpense.E_ResourceContentionExample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


// This class simulates a scenario where multiple threads try to access a shared resource.
public class ResourceContentionExample {

    // A reentrant lock to enforce mutual exclusion on a critical section.
    private final Lock lock = new ReentrantLock();

    // This method simulates some task that should be accessed by one thread at a time.
    public void performTask() {
        lock.lock(); // Acquire the lock before entering the critical section
        try {
            // Simulate a time-consuming operation (e.g., file access, DB transaction)
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // If the thread is interrupted while sleeping, restore the interrupt status
            Thread.currentThread().interrupt();
        } finally {
            // Always release the lock to avoid deadlocks
            lock.unlock();
        }
    }

    // Entry point of the program
    public static void main(String[] args) {
        ResourceContentionExample ex = new ResourceContentionExample();

        // Define a task that each thread will run (calls performTask method)
        Runnable task = ex::performTask;

        // Launch 10 threads that will all try to perform the task simultaneously
        for (int i = 0; i < 10; i++) {
            new Thread(task).start();
        }
    }
}


/*

Explanation: When multiple threads compete for shared resources (e.g., CPU, memory, I/0), contention can occur,
             causing threads to block and wait for resources to become available.

Cost: Resource contention can lead to reduced throughput and increased latency in multithreaded applications.
Multiple thread contending for the same lock can lead to contention and performance degradation.

 */
