package com.manish.LLD.ThreadPool.Type1;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.BlockingQueue;

/**
 * Worker thread that executes tasks from the shared queue
 */
public class Worker extends Thread {
    // Shared task queue
    private final BlockingQueue<Runnable> taskQueue;

    // Shutdown flag shared across all workers
    private final AtomicBoolean isShutDownInitiated;

    /**
     * Worker constructor
     * @param taskQueue - Shared task queue
     * @param isShutDownInitiated - Shutdown flag
     */
    public Worker(BlockingQueue<Runnable> taskQueue, AtomicBoolean isShutDownInitiated) {
        this.taskQueue = taskQueue;
        this.isShutDownInitiated = isShutDownInitiated;
    }

    @Override
    public void run() {
        // Continue until shutdown AND queue is empty
        while (!isShutDownInitiated.get() || !taskQueue.isEmpty()) {
            try {
                // Blocking take from queue (waits for tasks)
                Runnable task = taskQueue.take();
                task.run();  // Execute the task
            } catch (InterruptedException e) {
                // Only exit if shutdown was initiated
                if(isShutDownInitiated.get()) {
                    Thread.currentThread().interrupt();
                    break;
                }
                // Otherwise continue working
            }
        }
    }
}