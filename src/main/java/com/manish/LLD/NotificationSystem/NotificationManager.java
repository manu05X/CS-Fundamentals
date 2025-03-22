package com.manish.LLD.NotificationSystem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotificationManager {
    private final ExecutorService executorService;

    public NotificationManager(int threadPoolSize){
        this.executorService = Executors.newFixedThreadPool(threadPoolSize);
    }

    public void notifySubscriber(Subscriber subscriber, String message){
        executorService.submit(() -> subscriber.notify(message));
    }

    public void shutDown(){
        executorService.shutdown();
    }
}
