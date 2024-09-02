package com.manish.Thread.MultiThreading.Multithreading.L.Example;

class LockBasedCounter {
    private long value;

    public synchronized long getValue() {
        return value;
    }

    // When multiple threads attempt to invoke the method at the same time,
    // only one is allowed to do so while the rest are suspended
    public synchronized void increment() {
        value++;
    }
}