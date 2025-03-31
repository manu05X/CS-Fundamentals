package com.manish.Thread.Practice.NotesR.Ex10;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecuteVsSubmitDemo {
    public static void main(String[] args) {
        // Create a thread pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);
        AtomicInteger executeCounter = new AtomicInteger(0);
        AtomicInteger submitCounter = new AtomicInteger(0);

        System.out.println("=== execute() Examples ===");
        // Example 1: Basic execute() with Runnable
        executor.execute(() -> {
            System.out.println("execute() Task 1 - Simple task running in " + Thread.currentThread().getName());
            executeCounter.incrementAndGet();
        });

        // Example 2: execute() with exception (uncaught)
        executor.execute(() -> {
            System.out.println("execute() Task 2 - This will throw an exception");
            executeCounter.incrementAndGet();
            throw new RuntimeException("Exception from execute() task");
        });

        System.out.println("\n=== submit() Examples ===");
        // Example 3: submit() with Runnable
        Future<?> future1 = executor.submit(() -> {
            System.out.println("submit() Task 1 - Runnable task in " + Thread.currentThread().getName());
            submitCounter.incrementAndGet();
        });

        // Example 4: submit() with Callable (returning value)
        Future<String> future2 = executor.submit(() -> {
            System.out.println("submit() Task 2 - Callable task");
            submitCounter.incrementAndGet();
            return "Result from Callable";
        });

        // Example 5: submit() with exception
        Future<?> future3 = executor.submit(() -> {
            System.out.println("submit() Task 3 - This will throw an exception");
            submitCounter.incrementAndGet();
            throw new RuntimeException("Exception from submit() task");
        });

        // Demonstrate Future features
        try {
            // Wait for future1 completion (Runnable returns null)
            System.out.println("\nfuture1.get() (Runnable): " + future1.get());
            
            // Get result from Callable
            System.out.println("future2.get() (Callable): " + future2.get());
            
            // This will throw ExecutionException
            System.out.println("future3.get(): " + future3.get());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Task was interrupted");
        } catch (ExecutionException e) {
            System.err.println("Exception from task: " + e.getCause().getMessage());
        }

        // Monitoring
        try {
            Thread.sleep(1000); // Wait for tasks to complete
            System.out.println("\n=== Final Counters ===");
            System.out.println("execute() tasks completed: " + executeCounter.get());
            System.out.println("submit() tasks completed: " + submitCounter.get());
            
            // Attempt to cancel a task (too late in this case)
            boolean cancelled = future1.cancel(true);
            System.out.println("Was future1 cancelled? " + cancelled);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            executor.shutdown();
        }
    }
}