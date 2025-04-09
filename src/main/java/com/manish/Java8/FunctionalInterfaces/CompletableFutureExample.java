package com.manish.Java8.FunctionalInterfaces;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    public static void main(String[] args) {
        // Example 1: Simple asynchronous task (void return)
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println("Running an asynchronous task...");
        });

        try {
            future1.get(); // Wait for completion
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Example 2: Asynchronous task with return value
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            return "Result from asynchronous task";
        });

        try {
            String result = future2.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Example 3: Combining two futures
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<String> combinedFuture = future3.thenCombine(future4,
                (String result1, String result2) -> result1 + " " + result2);

        try {
            String combinedResult = combinedFuture.get();
            System.out.println(combinedResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        /*
        // Example 4: Exception handling
        CompletableFuture<String> futureWithException = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("Exception in asynchronous task");
        }).exceptionally(ex -> {
            System.out.println("Exception: " + ex.getMessage());
            return "Default result after exception";
        });

        try {
            String result = futureWithException.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

         */
    }
}



