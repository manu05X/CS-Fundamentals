package com.manish.Thread.concurrency.ThreadSafety;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount(){
        return count.get();
    }
}
