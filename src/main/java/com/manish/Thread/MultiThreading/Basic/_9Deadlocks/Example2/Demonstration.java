package com.manish.Thread.MultiThreading.Basic._9Deadlocks.Example2;

class Demonstration {

    public static void main(String args[]) throws Exception {
        NonReentrantLock nreLock = new NonReentrantLock();

        // First locking would be successful
        nreLock.lock();
        System.out.println("Acquired first lock");

        // Second locking results in a self deadlock
        System.out.println("Trying to acquire second lock");
        nreLock.lock();
        System.out.println("Acquired second lock");
    }
}

/*
For the impatient, the fix is presented below where we guard the read and write of the randInt variable using the RaceCondition object as the monitor. Don’t fret if the solution doesn’t make sense for now, it would, once we cover various topics in the lessons ahead.

 */