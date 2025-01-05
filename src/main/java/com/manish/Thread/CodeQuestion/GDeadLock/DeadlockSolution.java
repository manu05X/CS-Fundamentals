package com.manish.Thread.CodeQuestion.GDeadLock;

public class DeadlockSolution {

        // Two locks used to simulate deadlock
        private final Object lock1 = new Object();
        private final Object lock2 = new Object();

        // Method where lock1 is acquired first and then lock2
        public void method1() {
            synchronized (lock1) { // Acquiring lock1
                System.out.println("Thread 1: Locked lock1 in method1");

                try {
                    Thread.sleep(100); // Simulating some work with lock1
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Handle interruption
                }

                synchronized (lock2) { // Attempting to acquire lock2
                    System.out.println("Thread 1: Locked lock2 in method1");
                }
            }
        }

        // Method where lock1 is acquired first and then lock2
        public void method2() {
            synchronized (lock1) { // Acquiring lock1
                System.out.println("Thread 2: Locked lock2 in method2");

                try {
                    Thread.sleep(100); // Simulating some work with lock1
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Handle interruption
                }

                synchronized (lock2) { // Attempting to acquire lock2
                    System.out.println("Thread 2: Locked lock1 in method2");
                }
            }
        }

        public static void main(String[] args) {
            DeadlockSolution example = new DeadlockSolution();

            // Thread 1 executes method1
            Thread thread1 = new Thread(() -> example.method1());

            // Thread 2 executes method2
            Thread thread2 = new Thread(() -> example.method2());

            // Start both threads
            thread1.start();
            thread2.start();
        }
    }

