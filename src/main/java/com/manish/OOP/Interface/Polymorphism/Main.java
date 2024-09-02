package com.manish.OOP.Interface.Polymorphism;

public class Main {
    public static void main(String[] args) {
        Bird birdObj1 = new Eagle();
        Bird birdObj2 = new Hen();
        birdObj1.fly();
        birdObj2.fly();
    }
}
