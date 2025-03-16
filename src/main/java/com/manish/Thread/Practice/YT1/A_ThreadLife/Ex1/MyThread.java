package com.manish.Thread.Practice.YT1.A_ThreadLife.Ex1;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("RUNNING");
        try {
            Thread.sleep(2000); // TIMED_WAITING
            System.out.println("Do some Work till T1 is sleeping!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //System.out.println(Thread.currentThread().getState()); // Main thread state
        MyThread t1 = new MyThread();
        System.out.println(t1.getState()); // NEW

        t1.start();
        System.out.println(t1.getState()); // RUNNABLE
        //System.out.println(Thread.currentThread().getState()); // Main thread state
        Thread.sleep(100);
        System.out.println(t1.getState());

        t1.join(); // main is waiting for t1 to be finished as it is run by main thread so that main can terminate
        System.out.println(t1.getState()); // TERMINATED
    }
}
