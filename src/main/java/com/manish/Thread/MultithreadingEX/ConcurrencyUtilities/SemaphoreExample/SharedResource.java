package com.manish.Thread.MultithreadingEX.ConcurrencyUtilities.SemaphoreExample;

import java.util.concurrent.Semaphore;

class SharedResource {
    // Create a semaphore with 2 permits (allows 2 threads simultaneously)
    private Semaphore semaphore = new Semaphore(2);

    SharedResource() {
    }

    public void accessResource(String threadName) {
        try {
            // Acquire a permit (blocks if none available)
            this.semaphore.acquire();
            System.out.println(threadName + " acquired semaphore.");

            // Simulate resource usage (critical section)
            Thread.sleep(1000L);

            System.out.println(threadName + " released semaphore.");
        } catch (InterruptedException var6) {
            InterruptedException e = var6;
            e.printStackTrace();
        } finally {
            // Always release the permit
            this.semaphore.release();
        }
    }
}