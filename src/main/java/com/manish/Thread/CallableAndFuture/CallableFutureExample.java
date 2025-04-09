package com.manish.Thread.CallableAndFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Demonstrates the use of Callable and Future interfaces to execute tasks
 * that return results and may throw exceptions.
 * Shows how to get results from asynchronous computations.
 */
public class CallableFutureExample {

    /**
     * Default constructor (not explicitly needed in this example)
     */
    public CallableFutureExample() {
    }

    /**
     * Main method demonstrating Callable and Future usage
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a single-threaded executor
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Define a Callable task that returns a result
        Callable<String> callableTask = new Callable<String>() {
            /**
             * The task to be executed in background
             * @return String result after computation
             * @throws Exception if execution fails
             */
            public String call() throws Exception {
                // Simulate long-running task (2 seconds)
                Thread.sleep(2000L);
                return "Callable task result";
            }
        };

        // Submit the task to executor and get Future object
        Future<String> future = executor.submit(callableTask);

        try {
            // Get the result of the computation (blocks until available)
            String result = future.get();
            System.out.println("Result from callable task: " + result);
        } catch (ExecutionException | InterruptedException e) {
            // Handle exceptions from task execution or interruption
            e.printStackTrace();
        } finally {
            // Shutdown the executor service
            executor.shutdown();
        }
    }
}