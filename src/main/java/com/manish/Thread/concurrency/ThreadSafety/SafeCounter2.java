package com.manish.Thread.concurrency.ThreadSafety;

import java.util.concurrent.locks.ReentrantLock;

public class SafeCounter2 {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment(){
        lock.lock();

        try{
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount(){
        lock.unlock();

        try{
            return count;
        } finally {
            lock.unlock();
        }
    }
}
