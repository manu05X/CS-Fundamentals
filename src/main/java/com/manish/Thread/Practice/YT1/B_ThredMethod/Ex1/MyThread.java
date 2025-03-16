package com.manish.Thread.Practice.YT1.B_ThredMethod.Ex1;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread is Running!");
        //for(int i = 1; i <= 5; i++){
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //System.out.println(i);
        //}
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        t1.start();
        System.out.println(t1.getState());
        t1.join();
    }
}
