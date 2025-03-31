package com.manish.Thread.Practice.NotesR.Ex5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class TimeoutExample {
    private final Lock lock1 = new ReentrantLock(); // First lock
    private final Lock lock2 = new ReentrantLock(); // Second lock

    public void method1() {
        try {
            // Try to acquire lock1 with a timeout
            if (lock1.tryLock(1, TimeUnit.SECONDS)) {
                System.out.println("Thread 1: Acquired lock1 in method1");
                try {
                    Thread.sleep(100); // Simulate some work with lock1
                    // Try to acquire lock2 with a timeout
                    if (lock2.tryLock(1, TimeUnit.SECONDS)) {
                        try {
                            System.out.println("Thread 1: Acquired lock2 in method1");
                        } finally {
                            lock2.unlock(); // Always release lock2
                        }
                    } else {
                        System.out.println("Thread 1: Could not acquire lock2 in method1");
                    }
                } finally {
                    lock1.unlock(); // Always release lock1
                }
            } else {
                System.out.println("Thread 1: Could not acquire lock1 in method1");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread 1: Interrupted");
        }
    }

    public void method2() {
        try {
            // Try to acquire lock2 with a timeout
            if (lock2.tryLock(1, TimeUnit.SECONDS)) {
                System.out.println("Thread 2: Acquired lock2 in method2");
                try {
                    Thread.sleep(100); // Simulate some work with lock2
                    // Try to acquire lock1 with a timeout
                    if (lock1.tryLock(1, TimeUnit.SECONDS)) {
                        try {
                            System.out.println("Thread 2: Acquired lock1 in method2");
                        } finally {
                            lock1.unlock(); // Always release lock1
                        }
                    } else {
                        System.out.println("Thread 2: Could not acquire lock1 in method2");
                    }
                } finally {
                    lock2.unlock(); // Always release lock2
                }
            } else {
                System.out.println("Thread 2: Could not acquire lock2 in method2");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread 2: Interrupted");
        }
    }

    public static void main(String[] args) {
        TimeoutExample example = new TimeoutExample();

        // Create two threads for method1 and method2
        Thread thread1 = new Thread(example::method1);
        Thread thread2 = new Thread(example::method2);

        thread1.start();
        thread2.start();
    }
}
