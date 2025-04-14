package com.manish.Thread.MultithreadingEX.SynchronizationandCommunication.DeadlockExample;

public class DeadlockExample {
    public DeadlockExample() {
    }

    public static void main(String[] args) {
        Resource resource1 = new Resource();
        Resource resource2 = new Resource();

        // Thread 1 tries to call method1 on resource1 with resource2 as parameter
        Thread t1 = new Thread(() -> {
            resource1.method1(resource2);
        }, "Thread-1");

        // Thread 2 tries to call method1 on resource2 with resource1 as parameter
        Thread t2 = new Thread(() -> {
            resource2.method1(resource1);
        }, "Thread-2");

        t1.start();
        t2.start();
    }
}

/**

 Where Locks Are Taken
 In method1():

     When a thread enters method1(), it acquires the lock on the current object (this) because the method is synchronized
     The lock is held for the entire duration of the method execution
     While still holding this lock, the thread calls method2() on the other resource object

 In method2():

     Similarly, when a thread enters method2(), it acquires the lock on the current object (this)
     The lock is held for the entire duration of the method execution
     While still holding this lock, the thread calls method1() on the other resource object

 Deadlock Scenario
 The deadlock occurs in the following sequence:

 Thread-1:
     Acquires lock on resource1 when entering resource1.method1(resource2)
     Sleeps for 100ms (still holding the lock)
     Tries to call resource2.method2(this) - needs lock on resource2

 Thread-2:
     Acquires lock on resource2 when entering resource2.method1(resource1)
     Sleeps for 100ms (still holding the lock)
     Tries to call resource1.method2(this) - needs lock on resource1

 Deadlock:
     Thread-1 holds lock on resource1 and waits for resource2's lock
     Thread-2 holds lock on resource2 and waits for resource1's lock
     Neither thread can proceed, resulting in a deadlock

 Prevention
 This deadlock could be prevented by:

 Acquiring locks in a consistent global order (always lock resource1 before resource2)
 Using tryLock() with timeouts
 Reducing synchronized blocks to smaller critical sections
 Using higher-level concurrency utilities from java.util.concurrent


 */