package com.manish.Thread.MultithreadingEX.BasicThreadOperations;

class MyRunnable implements Runnable {
    MyRunnable() {
    }

    public void run() {
        System.out.println("Thread is running using Runnable");
    }
}