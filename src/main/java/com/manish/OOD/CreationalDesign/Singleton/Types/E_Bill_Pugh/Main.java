package com.manish.OOD.CreationalDesign.Singleton.Types.E_Bill_Pugh;

public class Main {
    public static void main(String[] args) {
        // Create two threads to test Singleton instance access
        Thread t1 = new Thread(()-> {
            Singleton s1 = Singleton.getInstance();
            System.out.println("Inside from Thread 1: " + s1);
        });

        Thread t2 = new Thread(()-> {
            Singleton s2 = Singleton.getInstance();
            System.out.println("Inside from Thread 2: " + s2);
        });

        // Start both Thread
        t1.start();
        t2.start();
    }
}

/*
Explanation:
Thread Creation: Two threads (thread1 and thread2) are created. Both threads call Singleton.getInstance() to get the singleton instance.
Thread Safety: Since the SingletonHolder class is only loaded when getInstance() is called for the first time, this ensures lazy initialization, and because it's handled by the class loading mechanism, it is thread-safe.
Output: Both threads will print the same instance of the Singleton.

 */