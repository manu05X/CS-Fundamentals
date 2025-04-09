package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities.CyclicBarrierExample;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Task extends Thread {
    private CyclicBarrier barrier;

    public Task(CyclicBarrier barrier, String name) {
        super(name);
        this.barrier = barrier;
    }

    public void run() {
        System.out.println(this.getName() + " is waiting at the barrier");

        try {
            this.barrier.await();
            System.out.println(this.getName() + " crossed the barrier");
        } catch (BrokenBarrierException | InterruptedException var2) {
            Exception e = var2;
            ((Exception)e).printStackTrace();
        }

    }
}