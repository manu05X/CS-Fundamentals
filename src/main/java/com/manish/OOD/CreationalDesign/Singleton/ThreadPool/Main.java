package com.manish.OOD.CreationalDesign.Singleton.ThreadPool;

public class Main {
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
