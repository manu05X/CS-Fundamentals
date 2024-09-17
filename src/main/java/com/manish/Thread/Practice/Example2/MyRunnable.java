package com.manish.Thread.Practice.Example2;

public class MyRunnable implements Runnable {
    public void run() {
        System.out.println("MyRunnable is running : " + Thread.currentThread().getName());
    }
}
