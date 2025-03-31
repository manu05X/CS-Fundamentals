package com.manish.Thread.Practice.NotesR.Ex10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteExample {
    public static void main(String[] args) {
        // Create thread pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        System.out.println("Starting tasks with execute()...");
        
        // Submit 5 tasks using execute()
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println("Task " + taskId + " running in " + Thread.currentThread().getName());
                
                // Simulate work
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Task " + taskId + " interrupted");
                }
                
                // Uncaught exception (will be lost)
                if (taskId == 3) {
                    throw new RuntimeException("Error in task " + taskId);
                }
            });
        }
        
        // Graceful shutdown
        executor.shutdown();
        System.out.println("All tasks submitted. Shutting down executor...");
    }
}