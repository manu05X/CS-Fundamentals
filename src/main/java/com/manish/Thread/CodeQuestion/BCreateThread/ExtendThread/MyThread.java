package com.manish.Thread.CodeQuestion.BCreateThread.ExtendThread;

public class MyThread extends Thread{
    public void run(){
        System.out.println("Thread is running : " +Thread.currentThread().getName());
    }
}
