package com.manish.Codes.ThreadPoolAndExecutors.ExecutorServiceExample;

import java.util.concurrent.Callable;

class CallableTask implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(2000); // Simulating some work
        return "Callable task completed!";
    }
}
