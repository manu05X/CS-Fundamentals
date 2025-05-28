package com.manish.Thread.concurrency.ConcurrencyModels;

import com.sun.net.httpserver.Request;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadedServer {
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public void handleRequests(List<Request> requests){
        for (Request request : requests){
            executor.submit(() -> handleRequest(request));
        }
        executor.shutdown();
    }

    private void handleRequest(Request request){
        // Request handling logic here
    }
}
