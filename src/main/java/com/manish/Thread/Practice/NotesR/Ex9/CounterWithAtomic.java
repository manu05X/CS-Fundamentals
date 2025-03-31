package com.manish.Thread.Practice.NotesR.Ex9;


import java.util.concurrent.atomic.AtomicInteger;

public class CounterWithAtomic {
    private final AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
