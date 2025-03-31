package com.manish.Thread.Practice.NotesR.Ex14;// CompletableFuture Version
import java.util.List;
import java.util.concurrent.*;

public class ParallelApiRequests {
    private static final int MAX_CONCURRENT_REQUESTS = 3;
    private static final ExecutorService REQUEST_EXECUTOR = 
        Executors.newFixedThreadPool(MAX_CONCURRENT_REQUESTS);

    public static void main(String[] args) {
        List<String> apiRequests = List.of(
            "Request1", "Request2", "Request3", "Request4", "Request5"
        );

        // Create a Semaphore to enforce rate limiting
        Semaphore rateLimiter = new Semaphore(MAX_CONCURRENT_REQUESTS);

        List<CompletableFuture<Void>> futures = apiRequests.stream()
            .map(request -> CompletableFuture.runAsync(() -> {
                try {
                    rateLimiter.acquire();
                    makeApiCall(request);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    rateLimiter.release();
                }
            }, REQUEST_EXECUTOR))
            .toList();

        // Combine all futures and wait for completion
        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new))
            .exceptionally(ex -> {
                System.err.println("Request failed: " + ex.getMessage());
                return null;
            })
            .join();

        REQUEST_EXECUTOR.shutdown();
        System.out.println("All API requests completed");
    }

    private static void makeApiCall(String request) {
        System.out.printf("[%s] Processing %s%n", 
            Thread.currentThread().getName(), request);
        try {
            // Simulate API response time
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(request + " completed");
    }
}