package com.manish.Thread.Practice.NotesR.Ex17;

public class Main {

    // Shared lock object for synchronization between threads
    private static final Object lock = new Object();

    // Flag to control thread execution order: 
    // `true` -> Number thread prints, `false` -> Letter thread prints
    private static boolean printNumber = true;

    public static void main(String[] args) {

        // Thread to print numbers (1 to 10)
        Thread numberThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) { // Loop from 1 to 10
                synchronized (lock) { // Synchronize access to shared resources

                    while (!printNumber) { // Wait if it's not the number thread's turn
                        try {
                            lock.wait(); // Release lock and wait for notification
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt(); // Restore interrupted status
                        }
                    }

                    System.out.print(i + " "); // Print the number

                    printNumber = false; // Set flag to false, so letter thread can run

                    lock.notify(); // Notify the letter thread
                }
            }
        });

        // Thread to print letters (A to J)
        Thread letterThread = new Thread(() -> {
            for (char ch = 'A'; ch < 'A' + 10; ch++) { // Loop from 'A' to 'J'
                synchronized (lock) { // Synchronize access to shared resources

                    while (printNumber) { // Wait if it's not the letter thread's turn
                        try {
                            lock.wait(); // Release lock and wait for notification
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt(); // Restore interrupted status
                        }
                    }

                    System.out.print(ch + " "); // Print the letter

                    printNumber = true; // Set flag to true, so number thread can run

                    lock.notify(); // Notify the number thread
                }
            }
        });

        // Start both threads
        numberThread.start();
        letterThread.start();
    }
}
