package com.manish.LLD.ThreadPool.Type2.strategy;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FIFOTaskSchedulingStrategy implements TaskSchedulingStrategy{
    private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    @Override
    public void schedule(Runnable task) {
        queue.offer(task);
    }

    @Override
    public Runnable nextTask() throws InterruptedException {
        return queue.take();
    }
}
