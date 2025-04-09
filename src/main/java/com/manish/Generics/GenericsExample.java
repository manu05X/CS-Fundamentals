package com.manish.Generics;

public class GenericsExample {
    public GenericsExample() {
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box(123);
        System.out.println("Integer Box content: " + String.valueOf(integerBox.getContent()));
        Box<String> stringBox = new Box("Hello, Generics");
        System.out.println("String Box content: " + (String)stringBox.getContent());
    }
}