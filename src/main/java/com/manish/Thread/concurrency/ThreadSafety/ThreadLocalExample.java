package com.manish.Thread.concurrency.ThreadSafety;

public class ThreadLocalExample {
    private ThreadLocal<Integer> threadLocalCount = ThreadLocal.withInitial(()->0);

    public void increment(){
        threadLocalCount.set(threadLocalCount.get()+1);
    }

    public int getCount(){
        return threadLocalCount.get();
    }
}
