package com.manish.OOD.CreationalDesign.Singleton.Practice;

public class Main {
    public static void main(String[] args) {

        Singleton singleton = Singleton.getInstance();

        singleton.sayHello();
    }
}


