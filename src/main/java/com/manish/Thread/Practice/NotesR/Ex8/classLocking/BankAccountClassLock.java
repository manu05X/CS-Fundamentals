package com.manish.Thread.Practice.NotesR.Ex8.classLocking;

/*
public class BankAccountClassLock {
    private static double interestRate = 0.03; // Shared across all accounts
    
    // Class-level locked methods (use BankAccount.class monitor)
    public static synchronized void updateInterestRate(double newRate) {
        System.out.println(Thread.currentThread().getName() + " updating rate...");
        try { Thread.sleep(1000); } // Simulate work
        catch (InterruptedException e) {}
        interestRate = newRate;
        System.out.println("New interest rate: " + interestRate);
    }
    
    public static synchronized double getInterestRate() {
        return interestRate;
    }

    public static void main(String[] args) {
        // Demonstrate class-level locking
        Runnable task = () -> {
            updateInterestRate(0.05);
        };
        
        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        
        t1.start();
        t2.start(); // Will wait for t1 to finish
    }
}

 */

import java.util.concurrent.locks.ReentrantLock;

// BankAccountClassLockExplicit
public class BankAccountClassLock {
    private static double interestRate = 0.03;
    private static final ReentrantLock classLock = new ReentrantLock();

    public static void updateInterestRate(double newRate) {
        classLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " updating rate...");
            Thread.sleep(1000); // Simulate work
            interestRate = newRate;
            System.out.println("New interest rate: " + interestRate);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            classLock.unlock();
        }
    }

    public static double getInterestRate() {
        classLock.lock();
        try {
            return interestRate;
        } finally {
            classLock.unlock();
        }
    }

    public static void main(String[] args) {
        Runnable task = () -> updateInterestRate(0.05);

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}