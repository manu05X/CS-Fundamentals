package com.manish.Thread.JavaConcurrencyReference.A.Example2;

public class Demonstration {
    public static void main( String args[] ) {

        ExecuteMe executeMe = new ExecuteMe();
        Thread t = new Thread(executeMe);
        t.start();
    }
}