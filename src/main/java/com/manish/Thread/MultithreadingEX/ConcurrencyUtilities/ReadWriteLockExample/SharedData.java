package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities.ReadWriteLockExample;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedData {
    private int data = 0;
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    SharedData() {
    }

    public void writeData(int data) {
        this.reentrantReadWriteLock.writeLock().lock();

        try {
            this.data = data;
            System.out.println("Written data: " + data);
        } finally {
            this.reentrantReadWriteLock.writeLock().unlock();
        }

    }

    public int readData() {
        this.reentrantReadWriteLock.readLock().lock();

        int var1;
        try {
            System.out.println("Read data: " + this.data);
            var1 = this.data;
        } finally {
            this.reentrantReadWriteLock.readLock().unlock();
        }

        return var1;
    }
}