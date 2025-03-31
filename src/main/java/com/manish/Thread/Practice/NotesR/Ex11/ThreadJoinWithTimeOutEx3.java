package com.manish.Thread.Practice.NotesR.Ex11;

/*
public class ThreadJoinWithTimeOutEx3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println("Thread-1 is running....");
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread-1 is finished !");
        });

        Thread t2 = new Thread(()->{
            System.out.println("Thread-2 is running....");
            try{
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread-2 is finished !");
        });

        t1.start();;
        t2.start();

        try {
            t1.join(1000);;
            t2.join(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Both Thread-1 and Thread-2 is finished !");
    }
}

 */



public class ThreadJoinWithTimeOutEx3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread-1 started execution...");
            try {
                Thread.sleep(1000); // Simulate work (1 second)
            } catch (InterruptedException e) {
                System.out.println("Thread-1 was interrupted");
                Thread.currentThread().interrupt();
            }
            System.out.println("Thread-1 completed its work");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread-2 started execution...");
            try {
                Thread.sleep(4000); // Simulate work (4 seconds)
            } catch (InterruptedException e) {
                System.out.println("Thread-2 was interrupted");
                Thread.currentThread().interrupt();
            }
            System.out.println("Thread-2 completed its work");
        });

        t1.start();
        t2.start();

        System.out.println("Main thread waiting for threads (max 1 second each)...");

        try {
            // Wait for Thread-1 with timeout
            long startTime = System.currentTimeMillis();
            t1.join(1000);
            if (!t1.isAlive()) {
                System.out.println("Thread-1 finished within " +
                        (System.currentTimeMillis() - startTime) + "ms");
            } else {
                System.out.println("Thread-1 did not finish within timeout");
            }

            // Wait for Thread-2 with timeout
            startTime = System.currentTimeMillis();
            t2.join(5000);
            if (!t2.isAlive()) {
                System.out.println("Thread-2 finished within " +
                        (System.currentTimeMillis() - startTime) + "ms");
            } else {
                System.out.println("Thread-2 did not finish within timeout");
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted while waiting");
            Thread.currentThread().interrupt();
        }

        System.out.println("\nFinal thread status:");
        System.out.println("Thread-1 state: " + t1.getState() + " (alive: " + t1.isAlive() + ")");
        System.out.println("Thread-2 state: " + t2.getState() + " (alive: " + t2.isAlive() + ")");

        System.out.println("\nMain thread continuing execution...");
    }
}