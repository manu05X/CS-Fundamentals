package com.manish.Thread.MultithreadingEX.BasicThreadOperations;

import java.io.PrintStream;

class MyPriorityThread extends Thread {
    MyPriorityThread() {
    }

    public void run() {
        PrintStream var10000 = System.out;
        String var10001 = Thread.currentThread().getName();
        var10000.println(var10001 + " with priority " + Thread.currentThread().getPriority() + " is running");
    }
}