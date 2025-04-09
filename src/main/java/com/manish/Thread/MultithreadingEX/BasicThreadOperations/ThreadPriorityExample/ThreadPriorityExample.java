package com.manish.Thread.MultithreadingEX.BasicThreadOperations.ThreadPriorityExample;

public class ThreadPriorityExample {
    public ThreadPriorityExample() {
    }

    public static void main(String[] args) {
        MyPriorityThread t1 = new MyPriorityThread();
        MyPriorityThread t2 = new MyPriorityThread();
        MyPriorityThread t3 = new MyPriorityThread();

        t1.setName("Thread-1");
        t2.setName("Thread-2");
        t3.setName("Thread-3");

        t1.setPriority(1);
        t2.setPriority(5);
        t3.setPriority(10);

        t1.start();
        t2.start();
        t3.start();
    }
}
