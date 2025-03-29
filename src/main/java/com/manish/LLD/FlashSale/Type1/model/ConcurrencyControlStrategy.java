package com.manish.LLD.FlashSale.Type1.model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public interface ConcurrencyControlStrategy {
    
    void acquireLock() throws InterruptedException;
    
    void releaseLock();
    
    boolean validateTransaction(Transaction transaction);
}
