package com.manish.Thread.CallableAndFuture;

import java.util.concurrent.Callable;

class CallableFutureExample$1 implements Callable<String> {
    CallableFutureExample$1() {
    }

    public String call() throws Exception {
        Thread.sleep(2000L);
        return "Callable task result";
    }
}