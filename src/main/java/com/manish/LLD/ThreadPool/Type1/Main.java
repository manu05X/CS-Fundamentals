package com.manish.LLD.ThreadPool.Type1;

/**
 * Demonstration of ThreadPool usage
 */
public class Main {
    public static void main(String[] args) {
        // Get thread pool with 3 workers
        ThreadPool threadPool = ThreadPool.getInstance(3);

        // Submit 10 tasks to the pool
        for (int i = 1; i <= 10; i++) {
            Task task = new Task("Task-"+i);
            threadPool.submitTask(task);
        }

        // Shutdown the pool (waits for completion)
        threadPool.shutdown();
    }
}