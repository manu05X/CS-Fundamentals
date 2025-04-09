package com.manish.Thread.ThreadPoolAndExecutors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {
    public ScheduledExecutorServiceExample() {
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(new RunnableTask("Task 1"), 3L, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(new RunnableTask("Task 2"), 1L, 5L, TimeUnit.SECONDS);
        scheduler.scheduleWithFixedDelay(new RunnableTask("Task 3"), 1L, 4L, TimeUnit.SECONDS);
        scheduler.schedule(() -> {
            scheduler.shutdown();
            System.out.println("Scheduler shutdown initiated");
        }, 20L, TimeUnit.SECONDS);
    }
}
