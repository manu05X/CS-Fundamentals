package com.manish.Thread.Practice.NotesR.Ex5;

public class DeadlockExample {
    // Two lock objects that will be used for synchronization
    private final Object lock1 = new Object(); // First lock object
    private final Object lock2 = new Object(); // Second lock object

    // Method where Thread 1 attempts to acquire lock1 first, then lock2
    public void method1() {
        synchronized (lock1) { // Thread 1 acquires lock1
            System.out.println("Thread 1: Locked lock1 in method1");
            try {
                // Simulate some processing time while holding lock1
                Thread.sleep(100);
                // This sleep increases the chance of deadlock by giving Thread 2
                // time to acquire lock2 before Thread 1 tries to get it
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            // Thread 1 now tries to acquire lock2 while still holding lock1
            synchronized (lock2) {
                System.out.println("Thread 1: Locked lock2 in method1");
                // This code will only execute if both locks are acquired
            }
            // lock2 is automatically released here
        }
        // lock1 is automatically released here
    }

    // Method where Thread 2 attempts to acquire lock2 first, then lock1
    public void method2() {
        synchronized (lock2) { // Thread 2 acquires lock2
            System.out.println("Thread 2: Locked lock2 in method2");
            try {
                // Simulate some processing time while holding lock2
                Thread.sleep(100);
                // This sleep increases the chance of deadlock by giving Thread 1
                // time to acquire lock1 before Thread 2 tries to get it
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            // Thread 2 now tries to acquire lock1 while still holding lock2
            synchronized (lock1) {
                System.out.println("Thread 2: Locked lock1 in method2");
                // This code will only execute if both locks are acquired
            }
            // lock1 is automatically released here
        }
        // lock2 is automatically released here
    }

    public static void main(String[] args) {
        DeadlockExample example = new DeadlockExample();

        // Create two threads that will compete for the locks
        Thread thread1 = new Thread(example::method1); // Thread 1 runs method1
        Thread thread2 = new Thread(example::method2); // Thread 2 runs method2

        // Start both threads
        thread1.start();
        thread2.start();

        // The program may now deadlock:
        // - Thread 1 holds lock1 and wants lock2
        // - Thread 2 holds lock2 and wants lock1
        // Neither can proceed, resulting in a deadlock
    }
}