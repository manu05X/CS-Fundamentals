package com.manish.Thread.concurrency.ConcurrencyModels;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorSeviceExample {
    public static void main(String[] args) {
        ExecutorService executorSevice = Executors.newFixedThreadPool(10);

        for(int i = 0; i < 10; i++){
            executorSevice.submit(() -> {
                System.out.println("Task is running ..");
            });
        }

        executorSevice.shutdown();
    }
}
