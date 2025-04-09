package com.manish.Generics;

public class BoundedTypeParameterExample {
    public BoundedTypeParameterExample() {
    }

    public static void main(String[] args) {
        NumberBox<Integer> integerBox = new NumberBox(123);
        System.out.println("Integer Box content: " + String.valueOf(integerBox.getContent()));
        System.out.println("Integer Box content as double: " + integerBox.getDoubleValue());
        NumberBox<Double> doubleBox = new NumberBox(45.67);
        System.out.println("Double Box content: " + String.valueOf(doubleBox.getContent()));
        System.out.println("Double Box content as double: " + doubleBox.getDoubleValue());
        NumberBox<Float> floatBox = new NumberBox(8.9F);
        System.out.println("Float Box content: " + String.valueOf(floatBox.getContent()));
        System.out.println("Float Box content as double: " + floatBox.getDoubleValue());
    }
}