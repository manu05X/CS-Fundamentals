package com.manish.CoreJava.JavaFeatures;

public class StringBufferExample {
    public StringBufferExample() {
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World");
        System.out.println("Apended string: " + String.valueOf(sb));
        sb.insert(6, "Beautiful ");
        System.out.println("String after insertion: " + String.valueOf(sb));
        sb.replace(6, 16, "Amazing");
        System.out.println("String after replacement: " + String.valueOf(sb));
        sb.delete(6, 13);
        System.out.println("String after deletion: " + String.valueOf(sb));
        sb.reverse();
        System.out.println("Reversed string: " + String.valueOf(sb));
    }
}