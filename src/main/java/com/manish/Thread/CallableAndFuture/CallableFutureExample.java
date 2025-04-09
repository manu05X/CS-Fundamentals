package com.manish.Thread.CallableAndFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureExample {
    public CallableFutureExample() {
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<String> callableTask = new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(2000L);
                return "Callable task result";
            }
        };
        Future<String> future = executor.submit(callableTask);

        try {
            String result = (String)future.get();
            System.out.println("Result from callable task: " + result);
        } catch (ExecutionException | InterruptedException var5) {
            Exception e = var5;
            ((Exception)e).printStackTrace();
        }

        executor.shutdown();
    }
}
