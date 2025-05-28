package com.manish.CoreJava.JavaFeatures;

public class WrapperClassExample {
    public WrapperClassExample() {
    }

    public static void main(String[] args) {
        int intPrimitive = 5;
        Integer intWrapper = Integer.valueOf(intPrimitive);
        System.out.println("Integer wrapper: " + intWrapper);
        Integer anotherIntWrapper = new Integer(10);
        int anotherIntPrimitive = anotherIntWrapper;
        System.out.println("Primitive int: " + anotherIntPrimitive);
        String str = "123";
        int parsedInt = Integer.parseInt(str);
        System.out.println("Parsed int: " + parsedInt);
        System.out.println("Integer MAX_VALUE: 2147483647");
        System.out.println("Double MIN_VALUE: 4.9E-324");
    }
}