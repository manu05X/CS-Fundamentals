package com.manish.Thread.Practice.NotesR.Ex13.ProducerConsumer;


class SharedResource {
    private boolean isChanged = false;

    // Called by producer/modifier thread
    public synchronized void modifyResource() {
        // Simulate resource modification
        isChanged = true;

        System.out.println(Thread.currentThread().getName() + ": Notifying waiting thread");
        notify(); // Wake up waiting consumer thread
    }

    // Called by consumer thread
    public synchronized void waitForChange() throws InterruptedException {
        // Prevent spurious wakeups with while loop
        while (!isChanged) {
            System.out.println(Thread.currentThread().getName() + ": Entering wait state");
            wait(); // Releases lock and waits
        }

        // Reset flag for subsequent changes
        System.out.println(Thread.currentThread().getName() + ": Processing changes");
        isChanged = false;
    }
}

public class SharedResourceApp {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread consumer = new Thread(() -> {
            try {
                resource.waitForChange();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "ConsumerThread");

        Thread producer = new Thread(() -> {
            try {
                Thread.sleep(2000); // Simulate delay before modification
                resource.modifyResource();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "ProducerThread");

        consumer.start();
        producer.start();
    }
}
