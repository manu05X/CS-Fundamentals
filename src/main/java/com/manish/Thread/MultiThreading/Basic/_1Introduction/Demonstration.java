package com.manish.Thread.MultiThreading.Basic._1Introduction;

class Demonstration {
    public static void main( String args[] ) throws InterruptedException {
        SumUpExample.runTest();
    }
}
/*
Performance Gains via Multi-Threading
As a concrete example, consider the example code below. The task is to compute the sum of all the integers from 0 to Integer.MAX_VALUE. In the first scenario, we have a single thread doing the summation while in the second scenario we split the range into two parts and have one thread sum for each range. In the end, we add the two half sums to get the combined sum. We measure the time taken for each scenario and print it.



In my run, I see the two threads scenario run within 652 milliseconds whereas the single thread scenario runs in 886 milliseconds. You may observe different numbers but the time taken by two threads would always be less than the time taken by a single thread. The performance gains can be many folds depending on the availability of multiple CPUs and the nature of the problem being solved. However, there will always be problems that don't yield well to a multi-threaded approach and may very well be solved efficiently using a single thread.

Problems with Threads
However, as it is said, there's no free lunch in life. The premium for using threads manifests in the following forms:

Usually very hard to find bugs, some that may only rear head in production environments
Higher cost of code maintenance since the code inherently becomes harder to reason about
Increased utilization of system resources. Creation of each thread consumes additional memory, CPU cycles for book-keeping and waste of time in context switches.
Programs may experience slowdown as coordination amongst threads comes at a price. Acquiring and releasing locks adds to program execution time. Threads fighting over acquiring locks cause lock contention.
With this backdrop lets delve into more details of concurrent programming about which you are likely to be quizzed in an interview.


*/