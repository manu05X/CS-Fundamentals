package com.manish.LLD.ThreadPool.Type1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Singleton ThreadPool implementation that manages worker threads
 * and a task queue for concurrent task execution.
 */
public class ThreadPool {
    // Singleton instance
    private static ThreadPool instance;

    // Thread-safe queue for holding pending tasks
    private final BlockingQueue<Runnable> taskQueue;

    // Array of worker threads
    private final Thread[] workers;

    // Atomic flag for shutdown status
    private final AtomicBoolean isShutDownInitiated;

    /**
     * Private constructor for singleton pattern
     * @param numberOfThreads - Number of worker threads in pool
     */
    private ThreadPool(int numberOfThreads) {
        this.taskQueue = new LinkedBlockingQueue<>();
        this.workers = new Thread[numberOfThreads];
        this.isShutDownInitiated = new AtomicBoolean(false);

        // Initialize and start worker threads
        for(int i = 0; i < numberOfThreads; i++) {
            workers[i] = new Worker(taskQueue, isShutDownInitiated);
            workers[i].start();
        }
    }

    /**
     * Singleton instance accessor
     * @param numberOfThreads - Number of threads in pool
     * @return ThreadPool instance
     */
    public static synchronized ThreadPool getInstance(int numberOfThreads) {
        if(instance == null) {
            instance = new ThreadPool(numberOfThreads);
        }
        return instance;
    }

    /**
     * Submits a task to the thread pool
     * @param task - Runnable task to execute
     */
    public void submitTask(Runnable task) {
        if(!isShutDownInitiated.get()) {
            taskQueue.offer(task);  // Non-blocking add to queue
        }
    }

    /**
     * Initiates graceful shutdown of the thread pool
     */
    public void shutdown() {
        isShutDownInitiated.set(true);
        // Interrupt all worker threads
        for (Thread worker : workers) {
            worker.interrupt();
        }
    }
}