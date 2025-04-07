package com.manish.LLD.ThreadPool.Type2.strategy;

import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PrioritySchedulingStrategy implements TaskSchedulingStrategy {
    private final Comparator<Runnable> priorityComparator;
    private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();



    public PrioritySchedulingStrategy(Comparator<Runnable> priorityComparator) {
        this.priorityComparator = priorityComparator;
    }

    @Override
    public void schedule(Runnable task) {
        // Requires a PriorityBlockingQueue
        ((PriorityBlockingQueue<Runnable>)queue).offer(task);
    }

    @Override
    public Runnable nextTask() throws InterruptedException {
        return queue.take(); // Priority queue handles ordering
    }
}