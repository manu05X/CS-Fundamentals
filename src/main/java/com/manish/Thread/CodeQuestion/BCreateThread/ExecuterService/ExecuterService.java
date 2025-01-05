package com.manish.Thread.CodeQuestion.BCreateThread.ExecuterService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterService {
    public static void main(String[] args) {
        // Create a thread pool with 2 threads
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Define task1
        Runnable task1 = () -> {
            System.out.println("Task 1 is running");
        };

        // Define task2
        Runnable task2 = () -> {
            System.out.println("Task 2 is running");
        };

        // Submit tasks to the executor
        executorService.execute(task1);
        executorService.execute(task2);

        // Shut down the executor service
        executorService.shutdown();
    }
}
