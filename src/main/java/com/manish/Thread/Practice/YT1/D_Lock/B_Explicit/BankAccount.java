package com.manish.Thread.Practice.YT1.D_Lock.B_Explicit;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100; // Initial balance of the bank account
    private Lock lock = new ReentrantLock(); // Explicit lock for synchronization

    /**
     * Method to withdraw money from the bank account.
     * Uses a ReentrantLock to ensure thread-safe access to the balance.
     *
     * @param amount The amount to withdraw.
     */
    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " Attempting to withdraw " + amount);

        try {
            // Try to acquire the lock with a timeout of 1000 milliseconds (1 second)
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    // Check if there is sufficient balance for the withdrawal
                    if (balance >= amount) {
                        System.out.println(Thread.currentThread().getName() + " Proceeding with withdrawal");

                        // Simulate processing time for the withdrawal
                        Thread.sleep(3000);

                        // Deduct the amount from the balance
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " Completed withdrawal. Remaining balance: " + balance);
                    } else {
                        // If insufficient balance, print a message
                        System.out.println(Thread.currentThread().getName() + " Insufficient balance");
                    }
                } catch (Exception e) {
                    // Handle interruption during sleep
                    System.out.println(Thread.currentThread().getName() + " Withdrawal interrupted");
                    Thread.currentThread().interrupt();
                } finally {
                    // Always release the lock in the finally block to avoid deadlocks
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName() + " Released the lock");
                }
            } else {
                // If the lock could not be acquired within the timeout, print a message
                System.out.println(Thread.currentThread().getName() + " Could not acquire the lock, will try later");
            }
        } catch (InterruptedException e) {
            // Handle interruption during lock acquisition
            System.out.println(Thread.currentThread().getName() + " Lock acquisition interrupted ");
            Thread.currentThread().interrupt();
        }
        if(Thread.currentThread().isInterrupted()){
            System.out.println("Do Something if Thread is Interrupted");
        }
    }
}




/*
package com.manish.Thread.Practice.YT1.D_Lock.B_Explicit;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;

    private Lock lock = new ReentrantLock();

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " Attempting to withdraw " + amount);

//        if(lock.tryLock()){
//
//        } else {
//
//        }

        try{

            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                if(balance >= amount){
                   try{
                       System.out.println(Thread.currentThread().getName() + " Proceeding with withdrawal ");
                       Thread.sleep(3000);
                       balance -= amount;
                       System.out.println(Thread.currentThread().getName() + " Completed withdrawal. Remaining balance " + balance);

                   } catch (Exception e) {
                   } finally {
                       lock.unlock();
                   }
                } else {
                    System.out.println(Thread.currentThread().getName() + " Insufficient balance");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " Could not acquire the lock, will try later ");
            }

        } catch (InterruptedException e) {
            // Handle interruption during lock acquisition
            System.out.println(Thread.currentThread().getName() + " Lock acquisition interrupted due to " +e);
        }
    }
}
 */
