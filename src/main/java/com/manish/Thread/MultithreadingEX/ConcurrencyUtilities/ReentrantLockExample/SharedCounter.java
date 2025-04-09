package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities.ReentrantLockExample;

import java.util.concurrent.locks.ReentrantLock;

class SharedCounter {
    private int count = 0;
    private ReentrantLock lock = new ReentrantLock();

    SharedCounter() {
    }

    public void increment() {
        this.lock.lock();

        try {
            ++this.count;
        } finally {
            this.lock.unlock();
        }

    }

    public int getCount() {
        return this.count;
    }
}