package com.manish.Thread.Practice.NotesR.Ex16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

// TicketCounter class implementing the ticket selling logic
class TicketCounter implements Runnable {

    private final AtomicInteger tickets; // Thread-safe ticket counter using AtomicInteger
    private volatile boolean running = true; // Flag to control thread execution

    // Constructor to initialize the total number of tickets
    public TicketCounter(int totalTickets) {
        this.tickets = new AtomicInteger(totalTickets);
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName(); // Get current thread's name

        while (running) {
            int currentTicket;

            synchronized (this) { // Synchronizing the critical section to prevent race conditions
                currentTicket = tickets.getAndDecrement(); // Atomically decrement ticket count

                // If no tickets are left, stop the execution
                if (currentTicket <= 0) {
                    running = false; // Stop thread execution
                    break; // Exit the loop
                }

                // Print ticket selling information
                System.out.println(threadName + " is selling ticket #" + currentTicket);
            }

            try {
                Thread.sleep(10); // Simulate delay in processing, mimicking real-world ticket selling
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Reset interrupt flag
                System.err.println(threadName + " was interrupted."); // Log interruption
                break; // Exit loop if interrupted
            }
        }
    }
}

// Main application class
public class Main {
    public static void main(String[] args) {
        int totalTickets = 1000; // Total number of tickets available for sale
        int numberOfThreads = 5; // Number of ticket counters (threads)

        // Create a TicketCounter instance with the total tickets
        TicketCounter ticketCounter = new TicketCounter(totalTickets);

        // Create a fixed thread pool with the specified number of ticket counters
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        // Submit ticket counter tasks to the executor (each thread will sell tickets)
        for (int i = 0; i < numberOfThreads; i++) {
            executor.submit(ticketCounter);
        }

        // Initiate an orderly shutdown of the executor after all tasks are submitted
        executor.shutdown();
    }
}
