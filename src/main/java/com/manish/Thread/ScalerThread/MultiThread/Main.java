package com.manish.Thread.ScalerThread.MultiThread;

public class Main {
    public static void main(String[] args) {
        //System.out.println("1");
        System.out.println("1 " + Thread.currentThread().getName());
        System.out.println("2");

        //1. Create instance of the task-->car
        // task is equivalent to car in a lane
        HelloWorldPrinter obj = new HelloWorldPrinter();
        //obj.run();

        // 2. Put that instance in an object of Thread
        // here t is the lane and "new Thread(obj)" here we are putting car(task) in the lane(thread)
        Thread t = new Thread(obj);

        // 3. Start the thread (it just tells the cpu that I want to run this thread)
        t.start();

        System.out.println("3");
        //System.out.println("4");
        System.out.println("4 " + Thread.currentThread().getName());
    }
}
