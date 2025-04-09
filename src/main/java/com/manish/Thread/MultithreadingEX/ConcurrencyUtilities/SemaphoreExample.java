package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities;

public class SemaphoreExample {
    public SemaphoreExample() {
    }

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        WorkerThread t1 = new WorkerThread(resource, "Thread-1");
        WorkerThread t2 = new WorkerThread(resource, "Thread-2");
        WorkerThread t3 = new WorkerThread(resource, "Thread-3");
        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException var6) {
            InterruptedException e = var6;
            e.printStackTrace();
        }

    }
}