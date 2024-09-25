package com.manish.OOD.CreationalDesign.Singleton.Types.D_DoubleLock;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            Singleton instance1 = Singleton.getInstance();
            System.out.println("Instance accessed by Thread 1: " + instance1);
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            Singleton instance2 = Singleton.getInstance();
            System.out.println("Instance accessed by Thread 2: " + instance2);
        }, "Thread-2");

        // Start both threads
        thread1.start();

        // Adding a small delay to ensure thread1 starts first
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
    }
}
