package com.manish.Thread.CodeQuestion.ELockSyncSemaphore.LockExample;

public class LockExample {
    public static void main(String[] args) throws InterruptedException {
        // Create an instance of the Counter class
        Counter counter = new Counter();

        // Create two threads that will increment the counter 1000 times each
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment(); // Increment the counter 1000 times
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment(); // Increment the counter 1000 times
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both threads to finish execution
        t1.join(); // Wait for thread t1 to complete
        t2.join(); // Wait for thread t2 to complete

        // Output the final count value after both threads have finished
        System.out.println("Final count: " + counter.getCount());
    }
}
