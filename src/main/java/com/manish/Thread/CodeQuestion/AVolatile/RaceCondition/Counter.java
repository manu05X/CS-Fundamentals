package com.manish.Thread.CodeQuestion.AVolatile.RaceCondition;

class Counter {
    private int count = 0; // Shared counter variable

    // Increment the counter
    public void increment() {
        count++; // Not synchronized, prone to race conditions
    }

    // Get the counter's current value
    public int getCount() {
        return count; // May not reflect the latest value
    }
}

// Method 1 :
//class Counter {
//    private int count = 0;
//
//    public synchronized void increment() {
//        count++;
//    }
//
//    public synchronized int getCount() {
//        return count;
//    }
//}


// Method 2 :

// import java.util.concurrent.atomic.AtomicInteger;

//class Counter {
//    private final AtomicInteger count = new AtomicInteger(0);
//
//    public void increment() {
//        count.incrementAndGet();
//    }
//
//    public int getCount() {
//        return count.get();
//    }
//}