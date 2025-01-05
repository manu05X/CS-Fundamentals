package com.manish.Thread.CodeQuestion.HThreadPool.UnOrderedThreadPool;

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
