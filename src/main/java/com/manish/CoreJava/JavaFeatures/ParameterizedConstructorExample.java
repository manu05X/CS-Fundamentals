package com.manish.CoreJava.JavaFeatures;

public class ParameterizedConstructorExample {
    int var1;
    int var2;

    public ParameterizedConstructorExample(int var1, int var2) {
        this.var1 = var1;
        this.var2 = var2;
        System.out.println("Parameterized constructor called.");
    }

    public void display() {
        System.out.println("var1: " + this.var1 + ", var2: " + this.var2);
    }

    public static void main(String[] args) {
        ParameterizedConstructorExample example = new ParameterizedConstructorExample(10, 20);
        example.display();
    }
}