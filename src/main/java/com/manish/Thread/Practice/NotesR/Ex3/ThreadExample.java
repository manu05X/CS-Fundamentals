package com.manish.Thread.Practice.NotesR.Ex3;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread running (extends Thread)");
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start(); // Starts the thread
    }
}