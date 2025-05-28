package com.manish.Thread.concurrency.LocksInThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExample {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private boolean ready = false;

    public void awaitCondition() throws InterruptedException {
        lock.lock();

        try {
            while (!ready) {
                condition.await();
            }
            System.out.println("Condition met, proceeding...");
        } finally {
            lock.unlock();
        }
    }

    public void signalCondition(){
        lock.lock();
        try {
            ready = true;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

}
