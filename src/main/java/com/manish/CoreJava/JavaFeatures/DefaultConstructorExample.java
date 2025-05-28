package com.manish.CoreJava.JavaFeatures;

public class DefaultConstructorExample {
    int var1 = 0;
    int var2 = 0;

    public DefaultConstructorExample() {
        System.out.println("Default constructor called.");
    }

    public void display() {
        System.out.println("var1: " + this.var1 + ", var2: " + this.var2);
    }

    public static void main(String[] args) {
        DefaultConstructorExample example = new DefaultConstructorExample();
        example.display();
    }
}