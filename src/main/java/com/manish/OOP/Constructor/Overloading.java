package com.manish.OOP.Constructor;

public class Overloading {
    private String name;
    private int id;
    //no-args constructor
    public Overloading() {
        this.name = "Default Name";
    }
    //one parameter constructor
    public Overloading(String n) {
        this.name = n;
    }
    //two parameter constructor
    public Overloading(String n, int i) {
        this.name = n;
        this.id = i;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "ID=" +id+ ", Name="+name;
    }

    public static void main(String[] args) {
        Overloading d = new Overloading();
        System.out.println(d);
        d = new Overloading("Java");
        System.out.println(d);
        d = new Overloading("Pankaj", 25);
        System.out.println(d);
    }
}
