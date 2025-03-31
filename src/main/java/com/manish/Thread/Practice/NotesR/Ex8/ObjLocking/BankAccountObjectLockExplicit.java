package com.manish.Thread.Practice.NotesR.Ex8.ObjLocking;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccountObjectLockExplicit {
    private double balance;
    private final String accountId;
    private final ReentrantLock lock = new ReentrantLock();
    
    public BankAccountObjectLockExplicit(String id) {
        this.accountId = id;
    }
    
    public void deposit(double amount) {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " depositing to " + accountId);
            Thread.sleep(500);
            balance += amount;
            System.out.println("New balance for " + accountId + ": " + balance);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
    
    public static void main(String[] args) {
        BankAccountObjectLockExplicit acc1 = new BankAccountObjectLockExplicit("ACC-101");
        BankAccountObjectLockExplicit acc2 = new BankAccountObjectLockExplicit("ACC-102");
        
        Thread t1 = new Thread(() -> acc1.deposit(100), "Thread-A");
        Thread t2 = new Thread(() -> acc1.deposit(100), "Thread-B");
        Thread t3 = new Thread(() -> acc2.deposit(100), "Thread-C");
        
        t1.start();
        t2.start();
        t3.start();
    }
}