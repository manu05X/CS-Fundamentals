package com.manish.Thread.CodeQuestion.HThreadPool.UnOrderedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//public class ThreadPoolExample {
//    public static void main(String[] args) {
//        // Create a thread pool with a fixed number of 10 threads
//        ExecutorService service = Executors.newFixedThreadPool(10);
//
//        // Submit 100 tasks to the thread pool
//        for (int i = 0; i < 100; i++) {
//            service.submit(new Task(i)); // Submit each task with a unique ID
//        }
//
//        // Shutdown the executor service after all tasks are submitted
//        service.shutdown();
//    }
//}


public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService thredPool = Executors.newFixedThreadPool(10);

        for(int i = 0; i < 100; i++){
            thredPool.submit(new Task(i));
        }

        thredPool.shutdown();
    }
}