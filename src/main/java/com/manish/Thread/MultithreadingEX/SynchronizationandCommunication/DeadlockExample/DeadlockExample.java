package com.manish.Thread.MultithreadingEX.SynchronizationandCommunication.DeadlockExample;

public class DeadlockExample {
    public DeadlockExample() {
    }

    public static void main(String[] args) {
        Resource resource1 = new Resource();
        Resource resource2 = new Resource();

        Thread t1 = new Thread(() -> {
            resource1.method1(resource2);
        }, "Thread-1");
        Thread t2 = new Thread(() -> {
            resource2.method1(resource1);
        }, "Thread-2");

        t1.start();
        t2.start();
    }
}