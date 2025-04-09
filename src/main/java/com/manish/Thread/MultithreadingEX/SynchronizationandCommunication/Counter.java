package com.manish.Thread.MultithreadingEX.SynchronizationandCommunication;

class Counter {
    private int count = 0;

    Counter() {
    }

    public synchronized void increment() {
        ++this.count;
    }

    public int getCount() {
        return this.count;
    }
}