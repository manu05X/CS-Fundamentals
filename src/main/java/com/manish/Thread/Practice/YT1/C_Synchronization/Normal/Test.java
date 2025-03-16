package com.manish.Thread.Practice.YT1.C_Synchronization.Normal;

public class Test {
    public static void main(String[] args) {
        Counter counter = new Counter();

        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (Exception e){
            System.out.println("The Exception : "+ e);
        }

        System.out.println(counter.getCount());
    }
}
