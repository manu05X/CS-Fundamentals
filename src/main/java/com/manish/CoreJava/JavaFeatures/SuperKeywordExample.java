package com.manish.CoreJava.JavaFeatures;

public class SuperKeywordExample extends ParentClass {
    public SuperKeywordExample() {
        System.out.println("Child class constructor.");
    }

    public void display() {
        super.display();
        System.out.println("Inside child class method.");
    }

    public static void main(String[] args) {
        SuperKeywordExample example = new SuperKeywordExample();
        example.display();
    }
}
