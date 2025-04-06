package com.manish.LLD.ThreadPool.Type2;

import com.manish.LLD.ThreadPool.Type1.Task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Worker extends Thread{
    // Shared task queue
    private final BlockingQueue<Runnable> taskQueue;

    // Shutdown flag shared across all workers
    private final AtomicBoolean isShutDownInitiated;

    public Worker(BlockingQueue<Runnable> taskQueue, AtomicBoolean isShutDownInitiated){
        this.taskQueue = taskQueue;
        this.isShutDownInitiated = isShutDownInitiated;
    }


    @Override
    public void run() {
        while (!taskQueue.isEmpty() || !isShutDownInitiated.get()){
            try {
                Runnable task = taskQueue.take();
                task.run();

            } catch (InterruptedException e){
                if(isShutDownInitiated.get()){
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
}
