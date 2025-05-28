package com.manish.Thread.concurrency.LocksInThread;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private final Semaphore semaphore = new Semaphore(3);

    public void accessResource(){
        try{
            semaphore.acquire();
            System.out.println("Resource accessed by "+ Thread.currentThread().getName());
            // Simulate resource access
            Thread.sleep(1000);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }
}
