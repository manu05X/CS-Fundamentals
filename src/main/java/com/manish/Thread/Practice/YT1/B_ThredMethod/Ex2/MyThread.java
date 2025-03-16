package com.manish.Thread.Practice.YT1.B_ThredMethod.Ex2;

public class MyThread extends Thread{
    @Override
    public void run() {

        for(int i = 1; i < 5; i++){
            System.out.println(Thread.currentThread().getName() + " - Priority: " + Thread.currentThread().getPriority() + " - count: " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        t1.start();

    }
}
