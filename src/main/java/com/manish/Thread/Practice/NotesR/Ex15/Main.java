package com.manish.Thread.Practice.NotesR.Ex15;

public class Main {

    // Array containing numbers to be printed
    private static final int[] numbers = {1, 2, 3, 4, 5, 6};

    // Shared index to track the current position in the array
    private static int index = 0;

    public static void main(String[] args) throws InterruptedException {
        // Object used as a lock for thread synchronization
        Object lock = new Object();

        // Runnable for printing odd numbers
        Runnable printOdd = () -> {
            while (true) {
                synchronized (lock) { // Synchronize on the shared lock
                    // Wait if the current number is even
                    while (index < numbers.length && numbers[index] % 2 == 0) {
                        try {
                            lock.wait(); // Release lock and wait for notification
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt(); // Restore interrupt flag
                            return; // Exit the thread
                        }
                    }

                    // Exit condition: If all numbers are processed
                    if (index >= numbers.length) {
                        lock.notify(); // Notify the other thread before exiting
                        break; // Exit loop
                    }

                    // Print the odd number
                    System.out.println(Thread.currentThread().getName() + " Odd: " + numbers[index]);

                    index++; // Move to the next number

                    lock.notify(); // Notify the other thread to continue
                }
            }
        };

        // Runnable for printing even numbers
        Runnable printEven = () -> {
            while (true) {
                synchronized (lock) { // Synchronize on the shared lock
                    // Wait if the current number is odd
                    while (index < numbers.length && numbers[index] % 2 != 0) {
                        try {
                            lock.wait(); // Release lock and wait for notification
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt(); // Restore interrupt flag
                            return; // Exit the thread
                        }
                    }

                    // Exit condition: If all numbers are processed
                    if (index >= numbers.length) {
                        lock.notify(); // Notify the other thread before exiting
                        break; // Exit loop
                    }

                    // Print the even number
                    System.out.println(Thread.currentThread().getName() + " Even: " + numbers[index]);

                    index++; // Move to the next number

                    lock.notify(); // Notify the other thread to continue
                }
            }
        };

        // Create two threads: one for odd numbers, one for even numbers
        Thread oddThread = new Thread(printOdd, "OddThread");
        Thread evenThread = new Thread(printEven, "EvenThread");

        // Start both threads
        oddThread.start();
        evenThread.start();

        // Wait for both threads to finish before exiting main thread
        oddThread.join();
        evenThread.join();
    }
}
