package com.manish.Thread.CodeQuestion.HThreadPool.SyncronizeThreadPool;

// Task class that implements the Runnable interface
class Task implements Runnable {
    private final int taskId; // Unique ID for each task
    private final TaskManager taskManager; // Shared TaskManager instance

    // Constructor to initialize the task with a specific ID and TaskManager
    public Task(int id, TaskManager taskManager) {
        this.taskId = id;
        this.taskManager = taskManager;
    }

    // The code to be executed when the task runs
    @Override
    public void run() {
        taskManager.executeTask(taskId); // Synchronized execution
    }
}
