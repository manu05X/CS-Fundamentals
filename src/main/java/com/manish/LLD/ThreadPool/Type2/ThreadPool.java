package com.manish.LLD.ThreadPool.Type2;

import com.manish.LLD.ThreadPool.Type2.strategy.TaskSchedulingStrategy;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadPool {
    private static ThreadPool instance;
    private final TaskSchedulingStrategy schedulingStrategy;
    private final Thread[] workers;
    private final AtomicBoolean isShutDownInitiated;

    // Private constructor now takes scheduling strategy
    private ThreadPool(int numberOfThreads, TaskSchedulingStrategy strategy) {
        this.schedulingStrategy = strategy;
        this.workers = new Thread[numberOfThreads];
        this.isShutDownInitiated = new AtomicBoolean(false);

        // Initialize workers
        for(int i = 0; i < numberOfThreads; i++) {
            workers[i] = new Worker(schedulingStrategy, isShutDownInitiated);
            workers[i].start();
        }
    }

    // Updated getInstance method with strategy parameter
    public static synchronized ThreadPool getThreadPoolInstance(
            int numberOfThreads,
            TaskSchedulingStrategy strategy
    ) {
        if(instance == null) {
            instance = new ThreadPool(numberOfThreads, strategy);
        }
        return instance;
    }

    // Submit task using the scheduling strategy
    public void submitTask(Runnable task) {
        if(!isShutDownInitiated.get()) {
            schedulingStrategy.schedule(task);
        }
    }

    public void shutDown() {
        isShutDownInitiated.set(true);
        for (Thread worker : workers) {
            worker.interrupt();
        }
    }
}