package com.manish.CoreJava.JavaFeatures;

public class CopyConstructorExample {
    int var1;
    int var2;

    public CopyConstructorExample(int var1, int var2) {
        this.var1 = var1;
        this.var2 = var2;
        System.out.println("Parameterized constructor called.");
    }

    public CopyConstructorExample(CopyConstructorExample example) {
        this.var1 = example.var1;
        this.var2 = example.var2;
        System.out.println("Copy constructor called.");
    }

    public void display() {
        System.out.println("var1: " + this.var1 + ", var2: " + this.var2);
    }

    public static void main(String[] args) {
        CopyConstructorExample original = new CopyConstructorExample(30, 40);
        CopyConstructorExample copy = new CopyConstructorExample(original);
        original.display();
        copy.display();
    }
}
