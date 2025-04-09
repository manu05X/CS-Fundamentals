package com.manish.Thread.MultithreadingEX.BasicThreadOperations.ThreadLifecycleExample;

class MyLifecycleThread extends Thread {
    MyLifecycleThread() {
    }

    public void run() {
        System.out.println("Thread is running");

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException var2) {
            System.out.println("Thread was interrupted");
        }

        System.out.println("Thread is terminating");
    }
}