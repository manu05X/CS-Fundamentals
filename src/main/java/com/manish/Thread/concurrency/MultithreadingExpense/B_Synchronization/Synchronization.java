package com.manish.Thread.concurrency.MultithreadingExpense.B_Synchronization;

public class Synchronization {
    private int counter = 0;

    public synchronized void increment(){
        counter++;
    }

    public static void main(String[] args) {
        Synchronization ex = new Synchronization();

        Runnable task = () -> {
            for(int i = 0; i < 1000; i++){
                ex.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter : "+ex.counter);
    }
}

/*

Synchronization is used to control access to shared resources to avoid race conditions and ensure thread safety.

Coast: The use of synchronization mechanisms like synchronized blocks or methods, locks, and other concurrency
utilities introduces overhead due to additional CPU instruction and potential blocking of
threads leading to performance bottlenecks

The increment method is synchronized to ensure thread safety, which introduces synchronization overhead.

 */