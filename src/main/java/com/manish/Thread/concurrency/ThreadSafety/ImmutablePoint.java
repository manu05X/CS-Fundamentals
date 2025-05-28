package com.manish.Thread.concurrency.ThreadSafety;

public final class ImmutablePoint {
    private final int x;
    private final int y;

    public ImmutablePoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

}
