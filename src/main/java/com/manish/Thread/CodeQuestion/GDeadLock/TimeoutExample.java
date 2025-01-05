package com.manish.Thread.CodeQuestion.GDeadLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class TimeoutExample {

    // Two ReentrantLocks to simulate potential deadlock scenarios
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    // Method 1: Tries to acquire lock1 first, then lock2
    public void method1() {
        try {
            // Try to acquire lock1 within 1 second
            if (lock1.tryLock(1, TimeUnit.SECONDS)) {
                System.out.println("Thread 1: Acquired lock1 in method1");
                try {
                    // Simulate work while holding lock1
                    Thread.sleep(100);

                    // Try to acquire lock2 within 1 second
                    if (lock2.tryLock(1, TimeUnit.SECONDS)) {
                        try {
                            System.out.println("Thread 1: Acquired lock2 in method1");
                            // Simulate work with both locks acquired
                        } finally {
                            // Release lock2
                            lock2.unlock();
                        }
                    } else {
                        // Unable to acquire lock2
                        System.out.println("Thread 1: Could not acquire lock2 in method1");
                    }
                } finally {
                    // Release lock1
                    lock1.unlock();
                }
            } else {
                // Unable to acquire lock1
                System.out.println("Thread 1: Could not acquire lock1 in method1");
            }
        } catch (InterruptedException e) {
            // Handle thread interruption
            Thread.currentThread().interrupt();
            System.out.println("Thread 1: Interrupted");
        }
    }

    // Method 2: Tries to acquire lock2 first, then lock1
    public void method2() {
        try {
            // Try to acquire lock2 within 1 second
            if (lock2.tryLock(1, TimeUnit.SECONDS)) {
                System.out.println("Thread 2: Acquired lock2 in method2");
                try {
                    // Simulate work while holding lock2
                    Thread.sleep(100);

                    // Try to acquire lock1 within 1 second
                    if (lock1.tryLock(1, TimeUnit.SECONDS)) {
                        try {
                            System.out.println("Thread 2: Acquired lock1 in method2");
                            // Simulate work with both locks acquired
                        } finally {
                            // Release lock1
                            lock1.unlock();
                        }
                    } else {
                        // Unable to acquire lock1
                        System.out.println("Thread 2: Could not acquire lock1 in method2");
                    }
                } finally {
                    // Release lock2
                    lock2.unlock();
                }
            } else {
                // Unable to acquire lock2
                System.out.println("Thread 2: Could not acquire lock2 in method2");
            }
        } catch (InterruptedException e) {
            // Handle thread interruption
            Thread.currentThread().interrupt();
            System.out.println("Thread 2: Interrupted");
        }
    }

    public static void main(String[] args) {
        TimeoutExample example = new TimeoutExample();

        // Start two threads executing method1 and method2
        Thread thread1 = new Thread(() -> example.method1());
        Thread thread2 = new Thread(() -> example.method2());

        thread1.start();
        thread2.start();
    }
}

