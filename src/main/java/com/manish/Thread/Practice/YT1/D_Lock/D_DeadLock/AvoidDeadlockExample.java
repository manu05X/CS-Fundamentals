package com.manish.Thread.Practice.YT1.D_Lock.D_DeadLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AvoidDeadlockExample {
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();


    public void method1() {
        lock1.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired lock1");
            Thread.sleep(100);
            lock2.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " acquired lock2");
            } finally {
                lock2.unlock();
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted");
        } finally {
            lock1.unlock();
        }
    }

    public void method2() {
        lock1.lock(); // Acquire lock1 first (same order as method1)
        try {
            System.out.println(Thread.currentThread().getName() + " acquired lock1");
            Thread.sleep(100);
            lock2.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " acquired lock2");
            } finally {
                lock2.unlock();
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted");
        } finally {
            lock1.unlock();
        }
    }



    public static void main(String[] args) {
        AvoidDeadlockExample example = new AvoidDeadlockExample();

        // Create two threads
        Thread thread1 = new Thread(() -> example.method1(), "Thread-1");
        Thread thread2 = new Thread(() -> example.method2(), "Thread-2");

        // Start the threads
        thread1.start();
        thread2.start();
    }
}
