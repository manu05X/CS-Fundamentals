package com.manish.Thread.concurrency.LocksInThread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

    private int count = 0;

    public void increment(){
        writeLock.lock();

        try {
            count++;
        } finally {
            writeLock.unlock();
        }
    }

    public int getCount(){
        readLock.lock();
        try {
            return count;
        } finally {
            readLock.unlock();
        }
    }
}
