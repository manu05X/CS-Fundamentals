package com.manish.LLD.ThreadPool.Type2.strategy;

import com.manish.Thread.Interview.BlockingQueue.Ex1.BlockingQueue;

public interface TaskSchedulingStrategy {
    void schedule(Runnable task);
    Runnable nextTask() throws InterruptedException;
}
