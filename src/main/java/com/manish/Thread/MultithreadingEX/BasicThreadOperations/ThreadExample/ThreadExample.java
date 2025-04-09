package com.manish.Thread.MultithreadingEX.BasicThreadOperations.ThreadExample;


public class ThreadExample {
    public ThreadExample() {
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
    }
}