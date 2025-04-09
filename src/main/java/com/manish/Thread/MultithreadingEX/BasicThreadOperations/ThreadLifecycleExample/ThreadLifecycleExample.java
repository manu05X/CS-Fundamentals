package com.manish.Thread.MultithreadingEX.BasicThreadOperations.ThreadLifecycleExample;


public class ThreadLifecycleExample {
    public ThreadLifecycleExample() {
    }

    public static void main(String[] args) {
        MyLifecycleThread t1 = new MyLifecycleThread();
        t1.start();
        System.out.println("Thread state after start: " + String.valueOf(t1.getState()));

        try {
            t1.join();
        } catch (InterruptedException var3) {
            InterruptedException e = var3;
            e.printStackTrace();
        }

        System.out.println("Thread state after completion: " + String.valueOf(t1.getState()));
    }
}