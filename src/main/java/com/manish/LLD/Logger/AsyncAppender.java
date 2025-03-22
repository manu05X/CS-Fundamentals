package com.manish.LLD.Logger;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class AsyncAppender implements Appender{
    private BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    private Thread worker;

    public AsyncAppender(Appender realAppender){
        worker = new Thread(()->{
            while (true){
                try {
                    String message = queue.take();
                    realAppender.append(message);
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        worker.start();
    }

    @Override
    public void append(String message){
        queue.offer(message);
    }
}
