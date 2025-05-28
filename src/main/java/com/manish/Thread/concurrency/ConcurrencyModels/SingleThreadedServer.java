package com.manish.Thread.concurrency.ConcurrencyModels;

import com.sun.net.httpserver.Request;

import java.util.List;

public class SingleThreadedServer {
    public void handleRequest(List<Request> requests){
        for (Request request : requests){
            handleRequest(request);
        }
    }

    private void handleRequest(Request request){
        // Request Handling logic here
    }
}
