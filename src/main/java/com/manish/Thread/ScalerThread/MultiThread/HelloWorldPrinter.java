package com.manish.Thread.ScalerThread.MultiThread;

public class HelloWorldPrinter implements Runnable{
    public void run(){
//        System.out.println("Hello World 1 ");
//        System.out.println("Hello World 2 ");
        System.out.println("Hello World 1 " + Thread.currentThread().getName());
        System.out.println("Hello World 2 " + Thread.currentThread().getName());
        blabla();
    }
    private void blabla() {
        System.out.println("Bla Bla "+ Thread.currentThread().getName());;
    }
}
