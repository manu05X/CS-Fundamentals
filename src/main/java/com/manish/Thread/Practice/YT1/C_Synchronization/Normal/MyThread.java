package com.manish.Thread.Practice.YT1.C_Synchronization.Normal;

public class MyThread extends Thread{
    private Counter counter;
    public MyThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++){
            counter.increment();
        }
    }
}
