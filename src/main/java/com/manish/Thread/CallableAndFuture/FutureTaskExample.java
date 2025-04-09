package com.manish.Thread.CallableAndFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {
    public FutureTaskExample() {
    }

    public static void main(String[] args) {
        Callable<String> callableTask = new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(2000L);
                return "FutureTask result";
            }
        };
        FutureTask<String> futureTask = new FutureTask(callableTask);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(futureTask);

        try {
            String result = (String)futureTask.get();
            System.out.println("Result from FutureTask: " + result);
        } catch (ExecutionException | InterruptedException var5) {
            Exception e = var5;
            ((Exception)e).printStackTrace();
        }

        executor.shutdown();
    }
}
