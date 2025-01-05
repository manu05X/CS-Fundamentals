package com.manish.Thread.CodeQuestion.BCreateThread.Runnable;

public class Main{
    public static void main(String[] args) {
        // Create an instance of MyRunnable
        MyRunnable runnable = new MyRunnable();
        // Create a Thread instance and pass MyRunnable as a parameter
        Thread thread = new Thread(runnable);
        // Start the thread
        thread.start();
    }
}
