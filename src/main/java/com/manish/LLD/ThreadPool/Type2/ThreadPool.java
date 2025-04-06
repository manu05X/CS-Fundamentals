package com.manish.LLD.ThreadPool.Type2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadPool {
    private static ThreadPool instance;
    private final BlockingQueue<Runnable> taskQueue;
    private final Thread[] workers;
    private final AtomicBoolean isShutDownInitiated;

    private ThreadPool(int numberOfThreads){
        this.taskQueue = new LinkedBlockingQueue<>();
        this.workers = new Thread[numberOfThreads];
        this.isShutDownInitiated = new AtomicBoolean(false);

        for(int i = 0; i < numberOfThreads; i++){
            workers[i] = new Worker(taskQueue, isShutDownInitiated);
            workers[i].start();
        }
    }


    public static synchronized ThreadPool getThreadPoolInstance(int numberOfThreads){
        if(instance == null){
            instance = new ThreadPool(numberOfThreads);
        }
        return instance;
    }


    public void submitTask(Runnable task){
        if(!isShutDownInitiated.get()){
            taskQueue.offer(task);
        }
    }


    public void shutDown(){
        isShutDownInitiated.set(false);

        for (Thread worker : workers){
            worker.interrupt();
        }
    }

}
