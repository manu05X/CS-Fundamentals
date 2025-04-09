package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities.ReentrantLockExample;


public class ReentrantLockExample {
    public ReentrantLockExample() {
    }

    public static void main(String[] args) {
        SharedCounter counter = new SharedCounter();
        CounterThread t1 = new CounterThread(counter);
        CounterThread t2 = new CounterThread(counter);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException var5) {
            InterruptedException e = var5;
            e.printStackTrace();
        }

        System.out.println("Counter value: " + counter.getCount());
    }
}