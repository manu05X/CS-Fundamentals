package com.manish.Thread.Practice.NotesR.Ex13.BlockingQueu;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class SharedResource {
    // Thread-safe queue with capacity 1 acts as synchronization mechanism
    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>(1);

    /**
     * Producer method - called by updater thread
     * Inserts message into queue, blocks if queue is full
     */
    public void updateResource() {
        try {
            System.out.println(Thread.currentThread().getName() + ": Preparing update...");
            Thread.sleep(2000); // Simulate work before update
            queue.put("DATA_READY"); // Blocks until space available
            System.out.println(Thread.currentThread().getName() + ": Update notification sent");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ": Update interrupted");
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Consumer method - called by processor thread
     * Retrieves message from queue, blocks if queue is empty
     */
    public void waitForUpdate() {
        try {
            System.out.println(Thread.currentThread().getName() + ": Awaiting resource update");
            String status = queue.take(); // Blocks until element available
            System.out.println(Thread.currentThread().getName() + ": Received status - " + status);
            processUpdate();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ": Wait interrupted");
            Thread.currentThread().interrupt();
        }
    }

    private void processUpdate() {
        System.out.println(Thread.currentThread().getName() + ": Processing resource changes...");
        // Add actual processing logic here
    }
}

public class SharedResourceApp2 {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(resource::updateResource, "ProducerThread");
        Thread consumer = new Thread(resource::waitForUpdate, "ConsumerThread");

        consumer.start(); // Start consumer first to ensure it's waiting
        producer.start(); // Start producer after consumer
    }
}
