package com.manish.Thread.Practice.NotesR.Ex9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterComparison {
    private static final int THREAD_COUNT = 10;
    private static final int INCREMENTS_PER_THREAD = 10000;
    private static final int TIMEOUT_SECONDS = 5;

    public static void main(String[] args) {
        testCounter("Atomic Counter", new CounterWithAtomic());
        testCounter("Lock Counter", new CounterWithLock());
        testCounter("Semaphore Counter", new CounterWithSemaphore());
        testCounter("Synchronized Counter", new CounterWithSynchronize());
    }

    private static void testCounter(String counterName, RunnableCounter counter) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < THREAD_COUNT; i++) {
            executor.submit(() -> {
                for (int j = 0; j < INCREMENTS_PER_THREAD; j++) {
                    try {
                        counter.increment();
                    } catch (Exception e) {
                        System.err.println(counterName + " error: " + e.getMessage());
                    }
                }
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        long duration = System.currentTimeMillis() - startTime;
        System.out.printf("%s:%n", counterName);
        System.out.printf("  Final count: %d (Expected: %d)%n", 
                         counter.getCount(), 
                         THREAD_COUNT * INCREMENTS_PER_THREAD);
        System.out.printf("  Time taken: %d ms%n%n", duration);
    }

    private interface RunnableCounter {
        void increment() throws Exception;
        int getCount();
    }

    // Adapter classes to make all counters work with the same interface
    private static class CounterWithAtomic implements RunnableCounter {
        private final AtomicInteger count = new AtomicInteger(0);
        public void increment() { count.incrementAndGet(); }
        public int getCount() { return count.get(); }
    }

    private static class CounterWithLock implements RunnableCounter {
        private int count = 0;
        private final Lock lock = new ReentrantLock();
        public void increment() {
            lock.lock();
            try { count++; } finally { lock.unlock(); }
        }
        public synchronized int getCount() { return count; }
    }

    private static class CounterWithSemaphore implements RunnableCounter {
        private int count = 0;
        private final Semaphore semaphore = new Semaphore(1);
        public void increment() throws InterruptedException {
            semaphore.acquire();
            try { count++; } finally { semaphore.release(); }
        }
        public synchronized int getCount() { return count; }
    }

    private static class CounterWithSynchronize implements RunnableCounter {
        private int count = 0;
        public void increment() { synchronized (this) { count++; } }
        public int getCount() { return count; }
    }
}