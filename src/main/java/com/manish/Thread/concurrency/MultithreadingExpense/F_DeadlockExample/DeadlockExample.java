package com.manish.Thread.concurrency.MultithreadingExpense.F_DeadlockExample;

public class DeadlockExample {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1(){
        synchronized (lock1){
            System.out.println("Thread 1: Holding lock 1...");

            try{
                Thread.sleep(10);
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println("Thread 1: Holding lock 2...");

            synchronized (lock2){
                System.out.println("Thread 1: Holding lock 1 & 2...");
            }
        }
    }


    public void method2(){
        synchronized (lock2){
            System.out.println("Thread 2: Holding lock 2..");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println("Thread 2: Waiting for lock 1..");

            synchronized (lock1){
                System.out.println("Thread 2: Holding lock 2 & 1...");
            }
        }
    }

    public static void main(String[] args) {
        DeadlockExample example = new DeadlockExample();

        Thread t1 = new Thread(example::method1);
        Thread t2 = new Thread(example::method2);

        t1.start();
        t2.start();
    }
}

/*

Explanation: Deadlocks occur when two or more threads are waiting indefinitely for resources held by each other,
                causing the system to halt. Livelocks occur when threads are active but unable to make progress.

Cost: Deadlocks and livelocks can cause parts of the application to become unresponsive, requiring careful design to avoid.
 */
