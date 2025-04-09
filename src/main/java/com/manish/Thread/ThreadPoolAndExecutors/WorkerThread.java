package com.manish.Thread.ThreadPoolAndExecutors;

import java.io.PrintStream;

/**
 * A worker thread implementation that processes messages with simulated work.
 * This class implements Runnable to be executed by a thread pool.
 */
class WorkerThread implements Runnable {
    // The message that this worker thread will process
    private String message;

    /**
     * Constructs a WorkerThread with the specified message.
     * @param message The message to be processed by this worker
     */
    public WorkerThread(String message) {
        this.message = message;
    }

    /**
     * The main execution method called when the thread starts.
     * Logs start/end messages and processes the assigned message.
     */
    public void run() {
        // Print start message with thread name
        PrintStream var10000 = System.out;
        String var10001 = Thread.currentThread().getName();
        var10000.println(var10001 + " (Start) " + this.message);

        // Process the message (simulated work)
        this.processMessage();

        // Print end message with thread name
        var10000 = System.out;
        var10001 = Thread.currentThread().getName();
        var10000.println(var10001 + " (End) " + this.message);
    }

    /**
     * Simulates message processing by putting the thread to sleep.
     * Represents time-consuming work being done on the message.
     */
    private void processMessage() {
        try {
            // Simulate work by sleeping for 2 seconds
            Thread.sleep(2000L);
        } catch (InterruptedException var2) {
            // Handle thread interruption
            InterruptedException e = var2;
            e.printStackTrace();
        }
    }
}