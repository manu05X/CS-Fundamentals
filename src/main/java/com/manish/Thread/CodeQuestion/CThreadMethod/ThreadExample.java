package com.manish.Thread.CodeQuestion.CThreadMethod;

public class ThreadExample {

    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(new MyRunnable());

        // Start the thread
        myThread.start();

        // Check if the thread is alive
        System.out.println("Thread is alive: " + myThread.isAlive());

        // Get and print the thread's name
        System.out.println("Thread name: " + myThread.getName());

        // Set a new name for the thread
        myThread.setName("MyCustomThread");
        System.out.println("Thread new name: " + myThread.getName());

        // Get and print the thread's ID
        System.out.println("Thread ID: " + myThread.getId());

        // Get and print the thread's priority
        System.out.println("Thread priority: " + myThread.getPriority());

        // Set a new priority for the thread
        myThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Thread new priority: " + myThread.getPriority());

        // Sleep for a specified time
        Thread.sleep(1000);

        // Wait for the thread to finish execution
        myThread.join();

        // Interrupt the thread (this won't interrupt since it's not actively doing anything)
        myThread.interrupt();
        System.out.println("Thread interrupted: " + myThread.isInterrupted());

        // Current thread
        System.out.println("Current thread: " + Thread.currentThread().getName());

        // Wait for a specific time with nanos
        synchronized (myThread) {
            myThread.wait(500, 1000); // Wait for 500 milliseconds with 1000 nanoseconds
        }

        // Notify the thread to wake up if it's waiting
        synchronized (myThread) {
            myThread.notify();
        }

        // Notify all threads if there are more than one waiting
        synchronized (myThread) {
            myThread.notifyAll();
        }

        // Yield the current thread
        Thread.yield();
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("This is a runnable thread.");
        }
    }
}

