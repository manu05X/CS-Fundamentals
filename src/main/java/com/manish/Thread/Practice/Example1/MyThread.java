package com.manish.Thread.Practice.Example1;

public class MyThread extends Thread{
    public void run(){
        System.out.println("Thread is running: "+ Thread.currentThread().getName());
    }
}
