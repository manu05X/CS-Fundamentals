package com.manish.Thread.concurrency.LocksInThread;

import java.util.concurrent.atomic.AtomicBoolean;

public class SpinLock {
    private final AtomicBoolean lock = new AtomicBoolean(false);

    public void lock(){
        while (!lock.compareAndSet(false, true)){
            // Busy-wait (spinning)
        }
    }

    public void unlock(){
        lock.set(false);
    }
}
