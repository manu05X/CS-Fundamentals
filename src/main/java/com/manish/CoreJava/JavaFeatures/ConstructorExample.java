package com.manish.CoreJava.JavaFeatures;

public class ConstructorExample {
    int var1;
    int var2;

    public ConstructorExample() {
        this.var1 = 0;
        this.var2 = 0;
        System.out.println("Default constructor called.");
    }

    public ConstructorExample(int var1, int var2) {
        this.var1 = var1;
        this.var2 = var2;
        System.out.println("Parameterized constructor called.");
    }

    public void display() {
        System.out.println("var1: " + this.var1 + ", var2: " + this.var2);
    }

    public static void main(String[] args) {
        ConstructorExample defaultExample = new ConstructorExample();
        defaultExample.display();
        ConstructorExample paramExample = new ConstructorExample(10, 20);
        paramExample.display();
    }
}