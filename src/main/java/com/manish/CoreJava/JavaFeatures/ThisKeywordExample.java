package com.manish.CoreJava.JavaFeatures;

public class ThisKeywordExample {
    int var1;
    int var2;

    public ThisKeywordExample(int var1, int var2) {
        this.var1 = var1;
        this.var2 = var2;
    }

    public void display() {
        System.out.println("var1: " + this.var1 + ", var2: " + this.var2);
    }

    public static void main(String[] args) {
        ThisKeywordExample example = new ThisKeywordExample(10, 20);
        example.display();
    }
}