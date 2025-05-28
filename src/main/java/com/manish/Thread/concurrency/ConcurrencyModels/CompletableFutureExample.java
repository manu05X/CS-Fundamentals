package com.manish.Thread.concurrency.ConcurrencyModels;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> "Hello ")
                .thenApplyAsync(s -> s + "World")
                .thenAcceptAsync(System.out::println);

        // Optional: Give time for async tasks to complete before main thread exits
        try {
            Thread.sleep(500); // Or use join() on the final future
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
