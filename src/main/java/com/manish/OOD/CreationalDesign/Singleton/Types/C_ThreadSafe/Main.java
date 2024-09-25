package com.manish.OOD.CreationalDesign.Singleton.Types.C_ThreadSafe;

public class Main {
    public static void main(String[] args) {
        // Create two threads that try to get the Singleton instance
        Thread thread1 = new Thread(() -> {
            Singleton instance1 = Singleton.getInstance();
            System.out.println("Instance 1: " + instance1);
        });

        Thread thread2 = new Thread(() -> {
            Singleton instance2 = Singleton.getInstance();
            System.out.println("Instance 2: " + instance2);
        });

        // Start both threads
        thread1.start();
        thread2.start();
    }
}

