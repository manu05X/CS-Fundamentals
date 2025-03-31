package com.manish.Thread.Practice.NotesR.Ex3;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture.runAsync(() -> {
            System.out.println("Async task running (CompletableFuture)");
        }).thenRun(() -> {
            System.out.println("Callback after task completes");
        });

        // Keep main thread alive to see output
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
    }
}