package com.manish.Thread.CodeQuestion.ELockSyncSemaphore.SemaphoreExample;

import java.util.concurrent.Semaphore;

class SharedResource {
    private final Semaphore semaphore; // Semaphore to control access to the shared resource

    // Constructor to initialize the semaphore with a specified number of permits
    public SharedResource(int permits) {
        this.semaphore = new Semaphore(permits); // Initialize semaphore with the given number of permits
    }

    // Method for accessing the shared resource
    public void accessResource(String threadName) {
        try {
            semaphore.acquire(); // Acquire a permit before accessing the resource
            System.out.println(threadName + " is accessing the resource.");
            Thread.sleep(1000); // Simulate some work with the resource (sleep for 1 second)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Handle interruption and restore the interrupted status
        } finally {
            System.out.println(threadName + " is releasing the resource.");
            semaphore.release(); // Release the permit after using the resource
        }
    }
}
