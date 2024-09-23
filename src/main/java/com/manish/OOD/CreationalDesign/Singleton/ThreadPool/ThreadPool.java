package com.manish.OOD.CreationalDesign.Singleton.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    private static volatile ThreadPool instance;
    private ExecutorService executor;

    // Private constructor to prevent instantiation
    private ThreadPool() {
        // Initialize thread pool
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    // Singleton instance retrieval
    public static ThreadPool getInstance() {
        if (instance == null) {
            synchronized (ThreadPool.class) {
                if (instance == null) {
                    instance = new ThreadPool();
                }
            }
        }
        return instance;
    }

    // Method to execute a task using the thread pool
    public void execute(Runnable task) {
        executor.execute(task);
    }

    // Method to gracefully shutdown the thread pool
    public void shutdown() {
        executor.shutdown();
    }
}

/*
// When an application needs to use a pool of threads to execute tasks, it's often useful to use a Singleton to manage the pool of threads. This ensures that there is only one instance of the thread pool and that all tasks are executed on the same pool of threads.
public class com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main {
    public static void main(String[] args) {
        ThreadPool threadPool = ThreadPool.getInstance();

        // Submit tasks to the thread pool
        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                // Task logic
                System.out.println("Task executed by thread: " + Thread.currentThread().getName());
            });
        }

        // Shutdown the thread pool
        threadPool.shutdown();
    }
}
 */
