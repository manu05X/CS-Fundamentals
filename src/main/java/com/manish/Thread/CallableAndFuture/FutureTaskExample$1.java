package com.manish.Thread.CallableAndFuture;

import java.util.concurrent.Callable;

class FutureTaskExample$1 implements Callable<String> {
    FutureTaskExample$1() {
    }

    public String call() throws Exception {
        Thread.sleep(2000L);
        return "FutureTask result";
    }
}