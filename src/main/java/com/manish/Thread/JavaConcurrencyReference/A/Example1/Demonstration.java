package com.manish.Thread.JavaConcurrencyReference.A.Example1;

public class Demonstration {
    public static void main( String args[] ) {
        Thread t = new Thread(new Runnable() {

            public void run() {
                System.out.println("Say Hello");
            }
        });
        t.start();
    }
}