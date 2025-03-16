package com.manish.Thread.Practice.YT1.F_Lambda.A;

public class LambdaExpression {
    public static void main(String[] args) {
        /*
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };
        */

        // As runnable is a functional interface so it uses a lambda expression
        Runnable runnable = () -> System.out.println("Hello");

        Thread t1 = new Thread(runnable);
        t1.start();
    }
}
