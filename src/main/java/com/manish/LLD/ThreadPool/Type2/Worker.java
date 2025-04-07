package com.manish.LLD.ThreadPool.Type2;

import com.manish.LLD.ThreadPool.Type2.strategy.TaskSchedulingStrategy;
import java.util.concurrent.atomic.AtomicBoolean;

public class Worker extends Thread {
    private final TaskSchedulingStrategy schedulingStrategy;
    private final AtomicBoolean isShutDownInitiated;

    public Worker(TaskSchedulingStrategy strategy, AtomicBoolean shutdownFlag) {
        this.schedulingStrategy = strategy;
        this.isShutDownInitiated = shutdownFlag;
    }

    @Override
    public void run() {
        while (!isShutDownInitiated.get() || hasPendingTasks()) {
            try {
                // Get next task using the strategy
                Runnable task = schedulingStrategy.nextTask();
                task.run();
            } catch (InterruptedException e) {
                if(isShutDownInitiated.get()) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    private boolean hasPendingTasks() {
        // Strategy-specific check for pending tasks
        // May need to add a method to the strategy interface for this
        return true; // Simplified for this example
    }
}