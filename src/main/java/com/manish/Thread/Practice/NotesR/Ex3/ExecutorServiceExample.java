package com.manish.Thread.Practice.NotesR.Ex3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//public class ExecutorServiceExample {
//    public static void main(String[] args) {
//        ExecutorService executor = Executors.newFixedThreadPool(2); // 2 threads in pool
//
//        executor.submit(() -> {
//            System.out.println("Task 1 running (ExecutorService)");
//        });
//
//        executor.submit(() -> {
//            System.out.println("Task 2 running (ExecutorService)");
//        });
//
//        executor.shutdown(); // Shutdown after tasks complete
//    }
//}


public class ExecutorServiceExample {
    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit 3 tasks
        executor.submit(() -> {
            System.out.println("Task 1 running on " + Thread.currentThread().getName());
        });

        executor.submit(() -> {
            System.out.println("Task 2 running on " + Thread.currentThread().getName());
        });

        executor.submit(() -> {
            System.out.println("Task 3 running on " + Thread.currentThread().getName());
        });

        // Shutdown the executor (no new tasks accepted)
        executor.shutdown();
    }
}
