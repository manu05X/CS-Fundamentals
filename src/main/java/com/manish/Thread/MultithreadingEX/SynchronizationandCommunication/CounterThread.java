package com.manish.Thread.MultithreadingEX.SynchronizationandCommunication;

class CounterThread extends Thread {
    private Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for(int i = 0; i < 1000; ++i) {
            this.counter.increment();
        }

    }
}