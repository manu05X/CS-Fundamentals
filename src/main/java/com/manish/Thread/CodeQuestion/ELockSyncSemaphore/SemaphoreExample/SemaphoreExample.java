package com.manish.Thread.CodeQuestion.ELockSyncSemaphore.SemaphoreExample;

public class SemaphoreExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource(2); // Create the shared resource with 2 permits
        // Only 2 threads can access the resource simultaneously

        // Create 4 threads attempting to access the shared resource
        for (int i = 1; i <= 4; i++) {
            final String threadName = "Thread-" + i;
            new Thread(() -> resource.accessResource(threadName)).start(); // Start a new thread for each access attempt
        }
    }
}

