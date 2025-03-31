package com.manish.Thread.Practice.NotesR.Ex9;

public class CounterWithSynchronize {
    private int count = 0;

    public void increment(){
        synchronized (this){
            count++;
        }
    }

    public int getCount(){
        return count;
    }
}
