package com.manish.LLD.ThredPool;


import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.BlockingQueue;

// Worker class implementing Runnable (Factory Method Pattern)
public class Worker extends Thread{
    private final BlockingQueue<Runnable> taskQueue;
    private final AtomicBoolean isShutDownInitiated;


    public Worker(BlockingQueue<Runnable> taskQueue,  AtomicBoolean isShutDownInitiated){
        this.taskQueue = taskQueue;
        this.isShutDownInitiated = isShutDownInitiated;
    }

    @Override
    public void run() {
        while (!isShutDownInitiated.get() || !taskQueue.isEmpty()){
            try{
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
