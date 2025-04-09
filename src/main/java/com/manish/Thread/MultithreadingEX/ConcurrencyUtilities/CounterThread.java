package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities;

class CounterThread extends Thread {
    private SharedCounter counter;

    public CounterThread(SharedCounter counter) {
        this.counter = counter;
    }

    public void run() {
        for(int i = 0; i < 1000; ++i) {
            this.counter.increment();
        }

    }
}