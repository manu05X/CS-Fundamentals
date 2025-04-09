package com.manish.Thread.CallableAndFuture;

import java.util.concurrent.Callable;

/**
 * Anonymous inner class implementation of Callable<String> interface.
 * This class is automatically generated to implement the callable task
 * defined in CallableFutureExample.
 *
 * <p>Performs a simulated long-running operation and returns a result.
 */
class CallableFutureExample$1 implements Callable<String> {

    /**
     * Default constructor for the anonymous callable implementation.
     */
    CallableFutureExample$1() {
        // Constructor for the anonymous Callable implementation
    }

    /**
     * The task to be executed in the background thread.
     * Simulates work by sleeping for 2 seconds and returns a result string.
     *
     * @return String The result of the callable task
     * @throws Exception if the thread is interrupted during sleep
     */
    public String call() throws Exception {
        // Simulate processing time (2 seconds)
        Thread.sleep(2000L);

        // Return the task result
        return "Callable task result";
    }
}