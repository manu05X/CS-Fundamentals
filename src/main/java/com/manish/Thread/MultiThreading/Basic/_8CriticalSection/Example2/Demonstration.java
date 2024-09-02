package com.manish.Thread.MultiThreading.Basic._8CriticalSection.Example2;

import com.manish.Thread.MultiThreading.Basic._8CriticalSection.Example2.RaceCondition;

class Demonstration {

    public static void main(String args[]) throws InterruptedException {
          RaceCondition.runTest();
    }
}

/*
For the impatient, the fix is presented below where we guard the read and write of the randInt variable using the RaceCondition object as the monitor. Don’t fret if the solution doesn’t make sense for now, it would, once we cover various topics in the lessons ahead.

 */