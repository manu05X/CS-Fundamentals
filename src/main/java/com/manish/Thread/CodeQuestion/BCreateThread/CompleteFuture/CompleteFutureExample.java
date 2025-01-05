package com.manish.Thread.CodeQuestion.BCreateThread.CompleteFuture;

import java.util.concurrent.CompletableFuture;

public class CompleteFutureExample {
    public static void main(String[] args) {
        CompletableFuture.runAsync(()->{
            System.out.println("Running Async Task");
        });

        CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(result -> result + " World ")
                .thenAccept(System.out::println);
    }
}
