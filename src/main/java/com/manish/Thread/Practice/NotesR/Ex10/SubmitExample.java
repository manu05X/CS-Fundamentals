package com.manish.Thread.Practice.NotesR.Ex10;

import java.util.concurrent.*;

public class SubmitExample {
    public static void main(String[] args) {
        // Create thread pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        System.out.println("Starting tasks with submit()...");
        
        // Store Futures for all tasks
        Future<?>[] futures = new Future[5];
        
        // Submit 5 tasks using submit()
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            futures[i-1] = executor.submit(() -> {
                System.out.println("Task " + taskId + " running in " + Thread.currentThread().getName());
                
                // Simulate work
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Task " + taskId + " interrupted");
                    return "Interrupted";
                }
                
                // Throw exception for one task
                if (taskId == 3) {
                    throw new RuntimeException("Error in task " + taskId);
                }
                
                return "Success";
            });
        }
        
        // Check results
        for (int i = 0; i < futures.length; i++) {
            try {
                Object result = futures[i].get();
                System.out.println("Task " + (i+1) + " result: " + result);
            } catch (InterruptedException e) {
                System.out.println("Task " + (i+1) + " was interrupted");
            } catch (ExecutionException e) {
                System.out.println("Task " + (i+1) + " failed: " + 
                                  e.getCause().getMessage());
            }
        }
        
        // Try to cancel the last task (may be too late)
        boolean cancelled = futures[4].cancel(true);
        System.out.println("Task 5 cancellation status: " + cancelled);
        
        executor.shutdown();
        System.out.println("Executor shutdown complete");
    }
}