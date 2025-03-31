package com.manish.Thread.Practice.NotesR.Ex1;

/*
public class Counter {
    private int count = 0;

    public void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }
}

 */


public class Counter {
    private int count = 0;

    public synchronized void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }
}