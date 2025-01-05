package com.manish.Thread.CodeQuestion.BCreateThread.Runnable;

public class MyRunnable implements Runnable {
    public void run(){
        // Code to be executed by thread
        System.out.println("Thread is Running :" +Thread.currentThread().getName());
    }
}
