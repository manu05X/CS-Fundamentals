package com.manish.Thread.ThreadPoolAndExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public ThreadPoolExample() {
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(int i = 1; i <= 5; ++i) {
            Runnable worker = new WorkerThread("Task " + i);
            executor.execute(worker);
        }

        executor.shutdown();

        while(!executor.isTerminated()) {
        }

        System.out.println("All tasks are finished!");
    }
}
