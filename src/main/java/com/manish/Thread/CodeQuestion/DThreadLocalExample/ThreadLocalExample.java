package com.manish.Thread.CodeQuestion.DThreadLocalExample;

public class ThreadLocalExample {

    // Create a ThreadLocal variable
    private static ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 1);

    public static void main(String[] args) {
        System.out.println("ThreadLocalValue initial value : " + threadLocalValue.get());

        // Thread 1
        Thread thread1 = new Thread(() -> {
            threadLocalValue.set(100);  // Thread 1 sets the ThreadLocal value to 100
            System.out.println("Thread 1: " + threadLocalValue.get());  // Print ThreadLocal value for Thread 1
        });

        // Thread 2
        Thread thread2 = new Thread(() -> {
            threadLocalValue.set(200);  // Thread 2 sets the ThreadLocal value to 200
            System.out.println("Thread 2: " + threadLocalValue.get());  // Print ThreadLocal value for Thread 2
        });

        // Start both threads
        thread1.start();
        thread2.start();
    }
}

