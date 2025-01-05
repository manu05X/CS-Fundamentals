package com.manish.Thread.CodeQuestion.AVolatile;

/*
public class VolatileFlagExample {

    // Volatile variable ensures changes to 'running' are visible across threads
    private volatile boolean running = true;

    // Method to stop the worker thread
    public void stop() {
        running = false; // Updates the flag to signal the thread to stop
    }

    // Method where the worker thread performs its task
    public void doWork() {
        System.out.println("Worker thread started");
        while (running) {
            // This loop continues as long as 'running' is true
            // In a real-world scenario, some work would be done here
        }
        System.out.println("Worker thread stopped"); // Indicates the thread has stopped
    }

    public static void main(String[] args) {
        // Create an instance of the VolatileFlagExample class
        VolatileFlagExample example = new VolatileFlagExample();

        // Create a new thread to execute the doWork method
        Thread workerThread = new Thread(example::doWork);
        workerThread.start(); // Start the worker thread

        try {
            // Pause the main thread for 2 seconds to simulate some processing
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle any interruption during sleep
        }

        // Signal the worker thread to stop by setting the flag to false
        example.stop();

        try {
            // Wait for the worker thread to finish its execution
            workerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle any interruption during join
        }

        // Indicate that the main thread has finished its execution
        System.out.println("Main thread finished");
    }
}

*/

/*

public class VolatileFlagExample {

    // Volatile variable ensures changes to 'running' are visible across threads
    private volatile boolean running = true;

    // Method to stop the worker thread
    public void stop() {
        running = false; // Updates the flag to signal the thread to stop
        System.out.println("Running False");
    }

    // Method where the worker thread performs its task
    public void doWork() {
        System.out.println("Worker thread started");
        while (running) {
            // This loop continues as long as 'running' is true
            // In a real-world scenario, some work would be done here
        }
        System.out.println("Worker thread stopped"); // Indicates the thread has stopped
    }

    public static void main(String[] args) {
        VolatileFlagExample example = new VolatileFlagExample(); // Create an instance of the class

        // Thread to perform work
        Thread workerThread = new Thread(example::doWork);
        workerThread.start(); // Start the worker thread

        try {
            // Sleep for a while and then stop the worker thread
            System.out.println("Main thread Sleeping for 2 sec");
            Thread.sleep(8000); // Main thread sleeps for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace(); // Print stack trace if an exception occurs
        }


        System.out.println("Main thread WakeUp and calls for Stopping the worker thread");
        example.stop(); // Stop the worker thread


        try {
            // Wait for the worker thread to finish
            System.out.println("This causes the main thread to pause and wait until the worker thread finishes execution");
            workerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace(); // Print stack trace if an exception occurs
        }

        System.out.println("Main thread finished");
    }
}

*/


public class VolatileFlagExample {

    private volatile boolean running = true;
    private final Object lock = new Object(); // Lock object for synchronization

    public void stop() {
        running = false; // Updates the flag to signal the thread to stop
    }

    public void doWork() {
        synchronized (lock) {
            System.out.println("Worker thread started");
            lock.notify(); // Notify the main thread that the worker has started
        }

        while (running) {
            // This loop continues as long as 'running' is true
            // In a real-world scenario, some work would be done here
        }

        System.out.println("Worker thread stopped"); // Indicates the thread has stopped
    }

    public static void main(String[] args) {
        VolatileFlagExample example = new VolatileFlagExample(); // Create an instance of the class

        // Thread to perform work
        Thread workerThread = new Thread(example::doWork);
        workerThread.start(); // Start the worker thread

        // Synchronize to ensure the main thread waits for the worker thread to start
        synchronized (example.lock) {
            try {
                System.out.println("Main thread Sleeping for 2 sec");
                // Wait for the worker thread to notify that it has started
                example.lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Main thread WakeUp and calls for Stopping the worker thread");
        example.stop(); // Stop the worker thread

        try {
            // Wait for the worker thread to finish
            System.out.println("This causes the main thread to pause and wait until the worker thread finishes execution");
            workerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished");
    }
}