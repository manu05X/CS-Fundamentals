package com.manish.Thread.Practice.NotesR.Ex8.ObjLocking;

public class BankAccountObjectLock {
    private double balance;
    private final String accountId;
    
    public BankAccountObjectLock(String id) {
        this.accountId = id;
    }
    
    // Object-level locked methods (use 'this' monitor)
    public synchronized void deposit(double amount) {
        System.out.println(Thread.currentThread().getName() + 
                         " depositing to " + accountId);
        try { Thread.sleep(500); } // Simulate work
        catch (InterruptedException e) {}
        balance += amount;
        System.out.println("New balance for " + accountId + 
                          ": " + balance);
    }
    
    public synchronized double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        // Create two separate accounts
        BankAccountObjectLock acc1 = new BankAccountObjectLock("ACC-101");
        BankAccountObjectLock acc2 = new BankAccountObjectLock("ACC-102");
        
        // Demonstrate object-level locking
//        Runnable depositTask = account -> {
//            account.deposit(100);
//        };
        
//        Thread t1 = new Thread(() -> depositTask.run(acc1), "Thread-A");
//        Thread t2 = new Thread(() -> depositTask.run(acc1), "Thread-B");
//        Thread t3 = new Thread(() -> depositTask.run(acc2), "Thread-C");
        
//        t1.start(); // Locks acc1
//        t2.start(); // Waits for acc1's lock
//        t3.start(); // Works on acc2 immediately (different instance)
    }
}