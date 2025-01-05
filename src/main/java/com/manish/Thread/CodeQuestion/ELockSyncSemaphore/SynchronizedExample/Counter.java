package com.manish.Thread.CodeQuestion.ELockSyncSemaphore.SynchronizedExample;

class Counter {
    private int count = 0; // Instance variable to hold the count value

    // Synchronized method to increment the count
    // This ensures that only one thread can increment the count at a time
    public synchronized void increment() {
        count++; // Increment the count
    }

    // Method to get the current value of the count
    public int getCount() {
        return count; // Return the current count value
    }
}
