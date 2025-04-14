package com.manish.Thread.MultithreadingEX.SynchronizationandCommunication.ThreadSynchronizationExample;

//public class Counter {
//    private int count = 0;
//
//    Counter() {
//    }
//
//    public synchronized void increment() {
//        ++this.count;
//    }
//
//    public int getCount() {
//        return this.count;
//    }
//}


import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private final AtomicInteger count = new AtomicInteger(0);

    Counter() {
    }

    public  void increment() {
        count.getAndIncrement();
    }

    public int getCount() {
        return count.get();
    }
}

