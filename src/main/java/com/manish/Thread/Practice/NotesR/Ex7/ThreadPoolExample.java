package com.manish.Thread.Practice.NotesR.Ex7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a thread pool with a fixed number of 10 threads
        ExecutorService service = Executors.newFixedThreadPool(10);

        // Submit 100 tasks to the thread pool
        for (int i = 0; i < 100; i++) {
            service.submit(new Task(i)); // Submit each task with a unique ID
        }

        // Shutdown the executor service after all tasks are submitted
        service.shutdown();
    }
}

// Task class that implements the Runnable interface
final class Task implements Runnable {
    private final int taskId; // Unique ID for each task

    // Constructor to initialize the task with a specific ID
    public Task(int id) {
        this.taskId = id;
    }

    // The code to be executed when the task runs
    @Override
    public void run() {
        // Print the task ID and the thread executing it
        System.out.println("Task ID: " + this.taskId +
                           " performed by " + Thread.currentThread().getName());
    }
}