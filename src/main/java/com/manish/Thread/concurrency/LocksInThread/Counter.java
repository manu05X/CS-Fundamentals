package com.manish.Thread.concurrency.LocksInThread;

public class Counter {
    private int count = 0;

    public synchronized void increment(){

        count++;
    }

    public synchronized int getCount(){

        return count;
    }
}