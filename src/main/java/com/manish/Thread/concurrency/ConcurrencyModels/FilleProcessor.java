package com.manish.Thread.concurrency.ConcurrencyModels;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
public class FilleProcessor {
    public void processFiles(List<File> files){
        for (File file : files){
            processFiles(file);
        }
    }

    private void processFiles(File file){
        // File reading and processing logic here
    }
}

 */


public class FilleProcessor {
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public void processFiles(List<File> files){
        for (File file : files){
            executor.submit(() -> processFiles(file));
        }
        executor.shutdown();
    }

    private void processFiles(File file){
        // File reading and processing logic here
    }
}

