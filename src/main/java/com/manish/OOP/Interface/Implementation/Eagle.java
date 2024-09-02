package com.manish.OOP.Interface.Implementation;

public class Eagle implements Bird {
    public void fly() {
        System.out.println("Eagle Fly Implementation");
    }
}

/*
if a method in interface is public then its implementation should also be public in its implementation class
public class Eagle implements Bird {
    protected void fly() {
        System.out.println("Eagle Fly Implementation");
    }
}
*/