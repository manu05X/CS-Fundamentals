package com.manish.Thread.Practice.YT1.D_Lock.D_DeadLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    /**
     * Method that acquires lock1 and then tries to acquire lock2.
     */
    public void method1() {
        lock1.lock(); // Acquire lock1
        try {
            System.out.println(Thread.currentThread().getName() + " acquired lock1");

            // Simulate some work
            Thread.sleep(100);

            System.out.println(Thread.currentThread().getName() + " trying to acquire lock2");
            lock2.lock(); // Try to acquire lock2
            try {
                System.out.println(Thread.currentThread().getName() + " acquired lock2");
            } finally {
                lock2.unlock(); // Release lock2
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted");
        } finally {
            lock1.unlock(); // Release lock1
        }
    }

    /**
     * Method that acquires lock2 and then tries to acquire lock1.
     */
    public void method2() {
        lock2.lock(); // Acquire lock2
        try {
            System.out.println(Thread.currentThread().getName() + " acquired lock2");

            // Simulate some work
            Thread.sleep(100);

            System.out.println(Thread.currentThread().getName() + " trying to acquire lock1");
            lock1.lock(); // Try to acquire lock1
            try {
                System.out.println(Thread.currentThread().getName() + " acquired lock1");
            } finally {
                lock1.unlock(); // Release lock1
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted");
        } finally {
            lock2.unlock(); // Release lock2
        }
    }

    public static void main(String[] args) {
        DeadlockExample example = new DeadlockExample();

        // Create two threads
        Thread thread1 = new Thread(() -> example.method1(), "Thread-1");
        Thread thread2 = new Thread(() -> example.method2(), "Thread-2");

        // Start the threads
        thread1.start();
        thread2.start();
    }
}