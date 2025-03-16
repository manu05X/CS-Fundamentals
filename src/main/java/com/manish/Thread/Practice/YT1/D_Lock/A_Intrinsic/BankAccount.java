package com.manish.Thread.Practice.YT1.D_Lock.A_Intrinsic;

public class BankAccount {
    private int balance = 100;

    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " Attempting to withdraw " + amount);

        if(balance >= amount){
            System.out.println(Thread.currentThread().getName() + " Proceeding with withdrawal");
            try{
                Thread.sleep(4000);
            } catch (InterruptedException e){
                System.out.println("We encounter the error : " +e);
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " Completed withdrawal. Remaining balance " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " Insufficient balance");
        }
    }
}
