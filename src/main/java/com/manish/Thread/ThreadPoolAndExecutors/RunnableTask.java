package com.manish.Thread.ThreadPoolAndExecutors;

import java.io.PrintStream;

class RunnableTask implements Runnable {
    private String taskName;

    public RunnableTask(String taskName) {
        this.taskName = taskName;
    }

    public void run() {
        PrintStream var10000 = System.out;
        String var10001 = Thread.currentThread().getName();
        var10000.println(var10001 + " (Start) " + this.taskName);
        this.processTask();
        var10000 = System.out;
        var10001 = Thread.currentThread().getName();
        var10000.println(var10001 + " (End) " + this.taskName);
    }

    private void processTask() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException var2) {
            InterruptedException e = var2;
            e.printStackTrace();
        }

    }
}
