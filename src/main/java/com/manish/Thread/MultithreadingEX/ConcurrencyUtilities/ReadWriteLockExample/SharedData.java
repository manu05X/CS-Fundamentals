package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities.ReadWriteLockExample;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedData {
    private int data = 0;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    SharedData() {
    }

    public void writeData(int data) {
        this.lock.writeLock().lock();

        try {
            this.data = data;
            System.out.println("Written data: " + data);
        } finally {
            this.lock.writeLock().unlock();
        }

    }

    public int readData() {
        this.lock.readLock().lock();

        int var1;
        try {
            System.out.println("Read data: " + this.data);
            var1 = this.data;
        } finally {
            this.lock.readLock().unlock();
        }

        return var1;
    }
}