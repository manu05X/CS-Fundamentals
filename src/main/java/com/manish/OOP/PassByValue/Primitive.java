package com.manish.OOP.PassByValue;

public class Primitive {
    static void modify(int x){
        x = 10; // Modifying the copy
    }

    public static void main(String[] args) {
        int original = 5;

        modify(original);

        System.out.println(original); // Still 5 (unchanged)
    }
}
