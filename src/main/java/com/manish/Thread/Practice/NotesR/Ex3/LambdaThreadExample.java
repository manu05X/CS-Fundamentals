package com.manish.Thread.Practice.NotesR.Ex3;

public class LambdaThreadExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Thread running (Lambda)");
        });
        thread.start();
    }
}