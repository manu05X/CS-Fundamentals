package com.manish.Thread.concurrency.MultithreadingExpense.G_DebuggingExample;



public class DebuggingExample {
    private int counter = 0;

    public synchronized void increment(){
        counter++;
    }

    public synchronized void decrement(){
        counter--;
    }

    public static void main(String[] args) {
        DebuggingExample ex = new DebuggingExample();

        Runnable incrementTask = ex::increment;
        Runnable decrementTask = ex::decrement;

        for(int i = 0; i < 100; i++){
            new Thread(incrementTask).start();
            new Thread(decrementTask).start();
        }

        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final Counter : " + ex.counter);
    }

}
