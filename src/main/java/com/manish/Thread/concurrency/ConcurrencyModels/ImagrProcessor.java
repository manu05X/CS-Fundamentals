package com.manish.Thread.concurrency.ConcurrencyModels;

import java.awt.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 1
/*
public class ImagrProcessor {
    public void processImage(List<Image> images){
        processImage(images);
    }

    private void processImage(Image image){

    }
}
 */

//2

public class ImagrProcessor {
    private final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void processImage(List<Image> images){
       for (Image image : images){
           executor.submit(()->processImage(image));
       }
       executor.shutdown();
    }

    private void processImage(Image image){
        // Image processing logic here
    }
}
