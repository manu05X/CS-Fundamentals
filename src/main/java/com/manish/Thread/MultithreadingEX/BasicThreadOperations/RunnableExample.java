package com.manish.Thread.MultithreadingEX.BasicThreadOperations;

public class RunnableExample {
    public RunnableExample() {
    }

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread t1 = new Thread(runnable);
        t1.start();
    }
}