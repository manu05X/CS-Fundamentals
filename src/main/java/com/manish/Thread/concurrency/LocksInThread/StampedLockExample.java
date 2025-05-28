package com.manish.Thread.concurrency.LocksInThread;

import java.util.concurrent.locks.StampedLock;

public class StampedLockExample {
    private final StampedLock lock = new StampedLock();
    private int count = 0;

    public void increment(){
        long stamp = lock.writeLock();

        try {
            count++;
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public int getCount(){
        long stamp = lock.tryOptimisticRead();
        int currentCount = count;

        if(!lock.validate(stamp)){
            stamp = lock.readLock();

            try {
                currentCount = count;
            } finally {
                lock.unlockRead(stamp);
            }
        }

        return currentCount;
    }

}
