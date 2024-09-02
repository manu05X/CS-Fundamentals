package com.manish.Thread.JavaConcurrencyReference.B.AJoiningThreads;

public class ExecuteMe implements Runnable {

    public void run() {
        while (true) {
            System.out.println("Say Hello over and over again.");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                // swallow interrupted exception
            }
        }
    }
}
