package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities.SemaphoreExample;

import java.util.concurrent.Semaphore;

class SharedResource {
    private Semaphore semaphore = new Semaphore(2);

    SharedResource() {
    }

    public void accessResource(String threadName) {
        try {
            this.semaphore.acquire();
            System.out.println(threadName + " acquired semaphore.");
            Thread.sleep(1000L);
            System.out.println(threadName + " released semaphore.");
        } catch (InterruptedException var6) {
            InterruptedException e = var6;
            e.printStackTrace();
        } finally {
            this.semaphore.release();
        }

    }
}