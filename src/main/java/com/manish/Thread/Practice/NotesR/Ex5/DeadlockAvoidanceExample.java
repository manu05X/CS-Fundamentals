package com.manish.Thread.Practice.NotesR.Ex5;

public class DeadlockAvoidanceExample {
    private final Object lock1 = new Object(); // First lock
    private final Object lock2 = new Object(); // Second lock

    // Both methods acquire locks in the same order to prevent deadlock
    public void method1() {
        synchronized (lock1) { // Acquire lock1 first
            System.out.println("Thread 1: Locked lock1 in method1");
            try {
                Thread.sleep(100); // Simulate some work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            synchronized (lock2) { // Acquire lock2 second
                System.out.println("Thread 1: Locked lock2 in method1");
            }
        }
    }

    public void method2() {
        synchronized (lock1) { // Also acquires lock1 first
            System.out.println("Thread 2: Locked lock1 in method2");
            try {
                Thread.sleep(100); // Simulate some work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            synchronized (lock2) { // Then acquires lock2
                System.out.println("Thread 2: Locked lock2 in method2");
            }
        }
    }

    public static void main(String[] args) {
        DeadlockAvoidanceExample example = new DeadlockAvoidanceExample();

        // Create two threads for method1 and method2
        Thread thread1 = new Thread(example::method1);
        Thread thread2 = new Thread(example::method2);

        thread1.start();
        thread2.start();
    }
}
