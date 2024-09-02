package com.manish.Thread.JavaConcurrencyReference.A.Example3;

public class ExecuteMe extends Thread {
    @Override
    public void run() {
        System.out.println("I ran after extending Thread class");
    }

}
