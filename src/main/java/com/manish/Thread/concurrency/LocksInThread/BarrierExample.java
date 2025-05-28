package com.manish.Thread.concurrency.LocksInThread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierExample {
    private final CyclicBarrier barrier;

    public BarrierExample(int parties){
        barrier = new CyclicBarrier(parties, ()-> System.out.println("All parties have reached the barrier"));
    }

    public void awaitBarrier(){
        try {
            barrier.await();
            System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
        } catch (InterruptedException | BrokenBarrierException e){
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        BarrierExample barrierExample = new BarrierExample(3);

        Runnable task = barrierExample::awaitBarrier;

        new Thread(task, "Thread 1").start();
        new Thread(task, "Thread 2").start();
        new Thread(task, "Thread 3").start();
    }

}
