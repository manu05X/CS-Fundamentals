package com.manish.Thread.concurrency.LocksInThread;

import java.util.concurrent.atomic.AtomicInteger;

public class TicketLock {
    private final AtomicInteger ticketNumber = new AtomicInteger(0);
    private final AtomicInteger servingNumber = new AtomicInteger(0);

    public void lock(){
        int myTicket = ticketNumber.getAndIncrement();
        while (servingNumber.get() != myTicket){
            // Busy-wait
        }
    }

    public void unlock(){
        servingNumber.incrementAndGet();
    }

}
