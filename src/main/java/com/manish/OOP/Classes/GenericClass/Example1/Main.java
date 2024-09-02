package com.manish.OOP.Classes.GenericClass.Example1;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Print printObj1 = new Print();
        printObj1.setPrintValue(1);
        Object printValue = printObj1.getPrintValue();
        if ((Integer)printValue == 1) {
        }

    }
}
