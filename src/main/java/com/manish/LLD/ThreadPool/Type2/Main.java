package com.manish.LLD.ThreadPool.Type2;

/*
public class Main {
    public static void main(String[] args) {
        System.out.println("The ThreadPool LLD");

        ThreadPool threadPool = ThreadPool.getThreadPoolInstance(3);

        for(int i = 0; i <= 10; i++){
            Task task = new Task("Task "+i);
            threadPool.submitTask(task);
        }

        threadPool.shutDown();
    }
}
*/

import com.manish.LLD.ThreadPool.Type2.strategy.FIFOTaskSchedulingStrategy;
import com.manish.LLD.ThreadPool.Type2.strategy.TaskSchedulingStrategy;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("The ThreadPool LLD");

        // Create FIFO strategy
        TaskSchedulingStrategy fifoStrategy = new FIFOTaskSchedulingStrategy();

// Initialize thread pool with strategy
        ThreadPool pool = ThreadPool.getThreadPoolInstance(2, fifoStrategy);

        // Submit tasks
        pool.submitTask(() -> System.out.println("Task 1"));
        pool.submitTask(() -> System.out.println("Task 2"));

        for (int i = 0; i <= 10; i++){
            Task task = new Task("Task l "+i);
            pool.submitTask(task);
        }
//        Thread.sleep(4000);
        // Shutdown when done
        pool.shutDown();


        ThreadPool pool2 = ThreadPool.getThreadPoolInstance(2, fifoStrategy);

        for (int i = 0; i <= 20; i++){
            Task task = new Task("Foor Loop Task  "+i);
            pool2.submitTask(task);
        }



    }
}



