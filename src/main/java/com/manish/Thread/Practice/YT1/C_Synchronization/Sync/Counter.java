package com.manish.Thread.Practice.YT1.C_Synchronization.Sync;
/*
public class Counter {
    private int count = 0;
    // Synchronized Method
    public synchronized void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }

}
*/
/*
public class Counter {
    private int count = 0;
    // Synchronized Method
    public void increment(){
        // critical section
        synchronized(this) {
            count++;
        }
    }

    public synchronized int getCount(){
        return count;
    }
}
*/
/*
// What if we synchronized getCount()
public class Counter {
    private int count = 0;

    // Synchronized Method for Increment
    public synchronized void increment() {
        count++;
    }

    // Synchronized Method for Get Count
    public synchronized int getCount() {
        return count;
    }
}
*/

//import java.util.concurrent.atomic.AtomicInteger;
//
//// Better Alternative: Use volatile Instead
//public class Counter {
//    private volatile int count = 0;
//
//    public  void increment() {
//        // critical section
//        synchronized(this) {
//            count++;
//        }
//    }
//
//    public int getCount() {  // No need to synchronize
//        return count;
//    }
//}

// Synchronizing getCount() is generally unnecessary and can reduce performance due to lock contention.
// Instead, using volatile (for simple types like int) or atomic variables like AtomicInteger would
// be a more efficient approach:

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
