package com.manish.CoreJava.JavaFeatures;

public class StaticKeywordExample {
    static int staticVar = 10;
    int instanceVar;

    static void staticMethod() {
        System.out.println("Inside static method.");
    }

    public StaticKeywordExample(int instanceVar) {
        this.instanceVar = instanceVar;
    }

    public static void main(String[] args) {
        System.out.println("Static variable: " + staticVar);
        staticMethod();
        StaticKeywordExample example = new StaticKeywordExample(5);
        System.out.println("Instance variable: " + example.instanceVar);
    }
}