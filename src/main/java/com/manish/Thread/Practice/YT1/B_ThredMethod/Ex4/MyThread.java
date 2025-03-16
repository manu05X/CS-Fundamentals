package com.manish.Thread.Practice.YT1.B_ThredMethod.Ex4;

public class MyThread extends Thread{
    @Override
    public void run() {
        //System.out.println("MyThread is Running!");
        //for(int i = 1; i <= 5; i++){
            try{
                Thread.sleep(5000);
                System.out.println("Thread is Running........");
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e);
            }
            //System.out.println(i);
        //}
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        t1.start();
        System.out.println(t1.getState());
        t1.interrupt();
        //System.out.println(t1.getState());
        t1.join();
    }
}
