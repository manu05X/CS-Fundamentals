package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public CyclicBarrierExample() {
    }

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("All threads reached the barrier, let's proceed");
        });
        Task task1 = new Task(barrier, "Task-1");
        Task task2 = new Task(barrier, "Task-2");
        Task task3 = new Task(barrier, "Task-3");
        task1.start();
        task2.start();
        task3.start();
    }
}