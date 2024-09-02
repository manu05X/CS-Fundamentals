package com.manish.Thread.JavaConcurrencyReference.A.Example3;

public class Demonstration {
    public static void main( String args[] ) throws Exception {
        ExecuteMe executeMe = new ExecuteMe();
        executeMe.start();
        executeMe.join();

    }
}