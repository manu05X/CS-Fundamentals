package com.manish.Thread.CodeQuestion.HThreadPool.SyncronizeThreadPool;

// Shared TaskManager class to synchronize task execution order
class TaskManager {
    private int currentTask = 0; // Keeps track of the current task to be executed

    // Synchronized method to control task execution order
    public synchronized void executeTask(int taskId) {
        while (taskId != currentTask) {
            try {
                wait(); // Wait until it's this task's turn
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted while waiting.");
            }
        }

        // Execute the task
        System.out.println("Task ID: " + taskId +
                " performed by " + Thread.currentThread().getName());

        // Move to the next task and notify all waiting threads
        currentTask++;
        notifyAll();
    }
}
