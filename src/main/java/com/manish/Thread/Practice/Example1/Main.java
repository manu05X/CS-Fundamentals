package com.manish.Thread.Practice.Example1;

//public class com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main {
//    public static void main(String[] args) {
//        // Create a instance of thread
//        MyThread myThread = new MyThread();
//        //Start a thread
//        myThread.start();
//    }
//}
/*
You can create a thread instance by either extending the Thread class or implementing the Runnable interface. Once you have created a thread instance, you can start it by calling the start() method
 */

public class Main {
    public static void main(String[] args) {
        // Create a thread using a lambda expression
        Thread myThread = new Thread(() -> {
            System.out.println("Thread is running: " + Thread.currentThread().getName());
        });

        // Start the thread
        myThread.start();
    }
}
