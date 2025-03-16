package com.manish.Thread.Practice.YT1.A_ThreadLife.Ex2;

public class B extends Thread {

    @Override
    public void run() {
        System.out.println("Task executed by extending Thread in class B");
    }

    public static void main(String[] args) {
        B b = new B();
        b.start(); // Start the thread directly
    }
}