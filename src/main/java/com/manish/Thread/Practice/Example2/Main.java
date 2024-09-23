package com.manish.Thread.Practice.Example2;

import com.manish.Thread.Practice.Example1.MyThread;

//public class com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main {
//    public static void main(String[] args) {
//        //create instance of MyRunnable
//        MyRunnable myRunnable = new MyRunnable();
//        // Create a Thread instance and pass MyRunnable as a parameter
//        Thread thread = new Thread(myRunnable);
//        // Start the thread
//        thread.start();
//    }
//}

public class Main {
    public static void main(String[] args) {
        // Create a Thread instance using a lambda expression
        Thread thread = new Thread(() -> {
            System.out.println("MyRunnable is running : " + Thread.currentThread().getName());
        });

        // Start the thread
        thread.start();
    }
}

