package com.manish.Thread.Practice.YT1.B_ThredMethod.Ex6;

public class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Hello world! ");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setDaemon(true); // myThread is daemon thread ( like Garbage collector ) now
//        MyThread t1 = new MyThread();
//        t1.start(); // t1 is user thread
        myThread.start();
        System.out.println("Main Done");
    }
}