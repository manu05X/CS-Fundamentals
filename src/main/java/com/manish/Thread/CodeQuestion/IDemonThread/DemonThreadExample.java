package com.manish.Thread.CodeQuestion.IDemonThread;

public class DemonThreadExample {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(()->{
            while (true){
                System.out.println("Daemon thread is running ..." );
                try{
                    Thread.sleep(1000); // Simulate some task
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        daemonThread.setDaemon(true); // Set the thread as daemon
        daemonThread.start(); // Start the daemon thread
    }
}
