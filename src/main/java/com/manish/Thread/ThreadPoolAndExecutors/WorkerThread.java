package com.manish.Thread.ThreadPoolAndExecutors;

import java.io.PrintStream;

class WorkerThread implements Runnable {
    private String message;

    public WorkerThread(String message) {
        this.message = message;
    }

    public void run() {
        PrintStream var10000 = System.out;
        String var10001 = Thread.currentThread().getName();
        var10000.println(var10001 + " (Start) " + this.message);
        this.processMessage();
        var10000 = System.out;
        var10001 = Thread.currentThread().getName();
        var10000.println(var10001 + " (End) " + this.message);
    }

    private void processMessage() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException var2) {
            InterruptedException e = var2;
            e.printStackTrace();
        }

    }
}
