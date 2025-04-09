package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public CountDownLatchExample() {
    }

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        Worker worker1 = new Worker(latch, "Worker-1");
        Worker worker2 = new Worker(latch, "Worker-2");
        Worker worker3 = new Worker(latch, "Worker-3");
        worker1.start();
        worker2.start();
        worker3.start();

        try {
            latch.await();
        } catch (InterruptedException var6) {
            InterruptedException e = var6;
            e.printStackTrace();
        }

        System.out.println("All workers finished their tasks");
    }
}