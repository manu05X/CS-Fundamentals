package com.manish.Thread.Practice.YT1.E_ThreadCommunication;

// Shared resource between producer and consumer
class SharedResource {
    private int data; // Stores the data produced
    private boolean hasData; // Flag to check if data is available for consumption

    /**
     * Producer method to add data to the shared resource.
     * It waits if there is already data available (ensuring the consumer first consumes it).
     */
    public synchronized void produce(int value) {
        while (hasData) { // If data is available, wait until it's consumed
            try {
                wait(); // Release the lock and wait for notification from consumer
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Preserve interrupt status
            }
        }
        data = value; // Store the produced value
        hasData = true; // Mark data as available
        System.out.println("Produced: " + value);
        notify(); // Notify the consumer that data is available
    }

    /**
     * Consumer method to retrieve data from the shared resource.
     * It waits if no data is available (ensuring the producer first produces it).
     */
    public synchronized int consume() {
        while (!hasData) { // If no data is available, wait until producer produces it
            try {
                wait(); // Release the lock and wait for notification from producer
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Preserve interrupt status
            }
        }
        hasData = false; // Mark data as consumed
        System.out.println("Consumed: " + data);
        notify(); // Notify the producer that space is available for new data
        return data;
    }
}

// Producer class that generates data and calls produce() on the shared resource
class Producer implements Runnable {
    private SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) { // Produces 10 items
            resource.produce(i); // Calls the produce method
        }
    }
}

// Consumer class that consumes data and calls consume() on the shared resource
class Consumer implements Runnable {
    private SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) { // Consumes 10 items
            int value = resource.consume(); // Calls the consume method
        }
    }
}

// Main class that starts the producer and consumer threads
public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource(); // Shared object between threads
        Thread producerThread = new Thread(new Producer(resource)); // Producer thread
        Thread consumerThread = new Thread(new Consumer(resource)); // Consumer thread

        producerThread.start(); // Start producer thread
        consumerThread.start(); // Start consumer thread
    }
}
