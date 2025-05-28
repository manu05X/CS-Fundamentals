package com.manish.Thread.concurrency.MultithreadingExpense.C_ComplexMultithreadingExample;

public class ComplexMultithreadingExample {
    private int balance = 0;

    public synchronized void deposit(int amount) {
        balance += amount;
    }

    public synchronized void withdraw(int amount){
        if(balance >= amount){
            balance -= amount;
        }
    }

    public static void main(String[] args) {
        ComplexMultithreadingExample ex = new ComplexMultithreadingExample();

        Runnable depositTask = () -> ex.deposit(200);
        Runnable withdrawTask = () -> ex.withdraw(50);

        Thread t1 = new Thread(depositTask);
        Thread t2 = new Thread(withdrawTask);

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (RuntimeException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Balance in Account : "+ex.balance);
    }

}
/*

Writing multithreaded code is inherently more complex than single-threaded code due to the need to manage
shared resources, avoid deadlocks, and ensure proper synchronization.

COST : Increase complexity can lead to large bugs , hard to maintain code and longer development and debugging time.

Managing deposit and withdrawal in multithreaded environment increases code complexity;

 */
