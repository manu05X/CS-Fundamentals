package com.manish.Thread.JavaConcurrencyReference.B.AJoiningThreads;

public class Demonstration {
    public static void main( String args[] ) throws InterruptedException {

        ExecuteMe executeMe = new ExecuteMe();
        Thread innerThread = new Thread(executeMe);
        innerThread.setDaemon(true);
        innerThread.start();
    }
}
