package com.manish.Thread.concurrency.VirtualThreads;

import java.util.concurrent.Executors;

public class VirtualThreadsExample {
    public static void main(String[] args) {
        Thread vThread = Thread.ofVirtual().start(()-> {
           System.out.println("Hello from a virtual thread! ");
        });

        try{
            vThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try(var executor = Executors.newVirtualThreadPerTaskExecutor()){
            for(int i = 0; i < 1000; i++){
                executor.submit(()-> {
                    System.out.println("Task running in virtual thread: " + Thread.currentThread());
                });
            }
        }
    }
}
