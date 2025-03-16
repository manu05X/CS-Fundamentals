package com.manish.Thread.Practice.YT1.B_ThredMethod.Ex5;

public class MyThread extends Thread{
    @Override
    public void run() {

        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + " is Running . . . ");
            Thread.yield(); // its a hint to JVM not strict rule
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        t2.start();

    }
}
