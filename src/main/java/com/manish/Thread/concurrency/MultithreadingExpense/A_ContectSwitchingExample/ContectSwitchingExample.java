package com.manish.Thread.concurrency.MultithreadingExpense.A_ContectSwitchingExample;

public class ContectSwitchingExample {
    public static void main(String[] args) {
        Runnable task = () -> {
            for(int i = 0; i < 100; i++){
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}

/*

Context switching occurs when the CPU switches from executing one thread to another.
This involves saving the state of the current thread and loading the state of the next thread.

COST : Context switching can be expensive in terms of CPU cycles, leading to decrease in overall
system performance if not managed properly.

Context switching between Thread-1 and Thread-2, incurring context switching overhead.

*/