package com.manish.Thread.concurrency.MultithreadingExpense.D_MemoryConsumptionExample;

public class MemoryConsumptionExample {
    public static void main(String[] args) {
        Runnable task = () -> {
            try{
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        for(int i = 0; i < 1000; i++){
            new Thread(task).start();
        }
    }
}

/*

Explanation: Each thread requires its own stack space for execution. Additionally,
thread creation involves memory allocation for thread objects and associated resources.

Cost: More threads mean higher memory consumption, which can lead to memory pressure and, in extreme cases,
OutOfMemoryError if the JVM runs out of allocatable memory.

 */