package com.manish.Thread.CodeQuestion.BCreateThread.Lambda;

public class LambdaThread {
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Thread is running");
        };

        Thread t1 = new Thread(task);
        t1.start();
    }
}
