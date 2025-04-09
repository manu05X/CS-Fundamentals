package com.manish.Thread.ThreadPoolAndExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Demonstrates the use of a fixed thread pool to execute multiple tasks concurrently.
 * Creates a pool of worker threads to process tasks in parallel.
 */
public class ThreadPoolExample {
    //Default constructor (not explicitly needed in this example)
    public ThreadPoolExample() {
    }

    // Main method that demonstrates thread pool usage @param args Command line arguments (not used)
    public static void main(String[] args) {
        // Create a thread pool with 3 fixed threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit 5 tasks to the thread pool
        for(int i = 1; i <= 5; ++i) {
            // Create a new worker task
            Runnable worker = new WorkerThread("Task " + i);
            // Execute the task using the thread pool
            executor.execute(worker);
        }

        // Initiate orderly shutdown of the thread pool
        executor.shutdown();

        // Wait until all tasks are completed
        while(!executor.isTerminated()) {
            // Busy wait - in real applications, consider using awaitTermination()
        }

        // Print completion message
        System.out.println("All tasks are finished!");
    }
}


/**
The while(!executor.isTerminated()) busy wait could be replaced with executor.awaitTermination() for better efficiency

The fixed thread pool size of 3 means only 3 tasks will execute concurrently

The 5 tasks will be distributed among the 3 available threads

The shutdown() call prevents new tasks from being submitted but allows existing tasks to complete
 */
