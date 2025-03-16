package com.manish.Thread.Practice.YT1.A_ThreadLife.Ex2;

public class A extends B implements Runnable {

    @Override
    public void run() {
        System.out.println("Task executed by implementing Runnable in class A");
    }

    public static void main(String[] args) {
        A a = new A();
        Thread thread = new Thread(a); // Pass the Runnable task to the Thread
        thread.start(); // Start the thread
    }
}