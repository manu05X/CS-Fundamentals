package com.manish.Thread.MultithreadingEX.BasicThreadOperations.RunnableExample;

class MyRunnable implements Runnable {
    MyRunnable() {
    }

    public void run() {
        System.out.println("Thread is running using Runnable");
    }
}