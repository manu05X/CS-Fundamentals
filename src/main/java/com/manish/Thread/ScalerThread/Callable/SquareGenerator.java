package com.manish.Thread.ScalerThread.Callable;

import java.util.concurrent.Callable;

public class SquareGenerator implements Callable<Integer> {
    private Integer number;

    public SquareGenerator(Integer number) {
        this.number = number;
    }

    public Integer call() throws InterruptedException {
        Thread.sleep(1000);
        return number*number;
    }
}
