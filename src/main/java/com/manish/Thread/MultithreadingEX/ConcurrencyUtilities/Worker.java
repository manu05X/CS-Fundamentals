package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities;

import java.util.concurrent.CountDownLatch;

class Worker extends Thread {
    private CountDownLatch latch;

    public Worker(CountDownLatch latch, String name) {
        super(name);
        this.latch = latch;
    }

    public void run() {
        System.out.println(this.getName() + " is working");

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException var2) {
            InterruptedException e = var2;
            e.printStackTrace();
        }

        System.out.println(this.getName() + " finished work");
        this.latch.countDown();
    }
}