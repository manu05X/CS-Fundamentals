package com.manish.Thread.CodeQuestion.ELockSyncSemaphore.SynchronizedExample;

public class SynchronizedExample {
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

        System.out.println("Before Starting Thread count: " + counter.getCount());

        // Start both threads
        t1.start();
        System.out.println("After Starting Thread1 and Before Starting Thread2 count: " + counter.getCount());
        t2.start();

        /*
        The main thread is the one invoking the join() method for t1 and t2.
        The threads t1 and t2 are the ones that the main thread is waiting for to finish before continuing.
        The threads themselves are not joining; instead, they are being waited on by the main thread.
        */

        // Main Wait for both threads to finish execution
        t1.join(); // Main thread Wait for thread t1 to complete
        System.out.println("After Joining Thread 1 with main thread: " + counter.getCount());
        t2.join(); // Main thread Wait for thread t2 to complete

        // Output the final count value after both threads have finished
        System.out.println("Final count: " + counter.getCount());
    }
}

/*

Which threads join?
Thread t1 joins the main thread when the t1.join() method is called. This means that the main thread waits for t1 to complete before proceeding.
Thread t2 joins the main thread when the t2.join() method is called. Similarly, the main thread waits for t2 to finish after t1 has completed.

*/
