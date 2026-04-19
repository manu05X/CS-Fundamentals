package com.manish.OOP.Classes.Example;

public class Cat {
    public static final String name = "Rob";

//    public Cat(String name){
//        this.name = name;
//    }

    public static void main(String[] args) {
        Cat a = new Cat(); // making a new object using constructor

        //a.name = "bob";
        System.out.println("The name of Cat is : "+a.name); // bob

        makeCatUpperCase(a);
        System.out.println("The name of Cat is : "+a.name); // BOB

        Cat b = makeCatUpperCase(a); // only function call and b is pointing to a cat obj
        System.out.println("The name of Cat is : "+b.name); // BOB

        //b.name = "Builder";
        System.out.println("The name of Cat is : "+b.name); // Builder

        System.out.println("The name of Cat is : "+a.name); // BOB

    }

    // This method/function convert any cat parameter to UPPER case letter
    public static Cat makeCatUpperCase(Cat parm){
        //parm.name = parm.name.toUpperCase();
        return parm;
    }
}


