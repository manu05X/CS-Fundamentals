package com.manish.Thread.concurrency.LocksInThread;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
   private final ReentrantLock lock = new ReentrantLock();

    private int count = 0;

    public void increment(){
        lock.lock();
        try{
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount(){
        lock.lock();
        try{
            return count;
        } finally {
            lock.unlock();
        }
    }

}
