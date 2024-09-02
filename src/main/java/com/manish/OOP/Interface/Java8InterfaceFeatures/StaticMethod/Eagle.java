package com.manish.OOP.Interface.Java8InterfaceFeatures.StaticMethod;

public class Eagle implements Bird {
    public Eagle() {
    }
    public void digestiveSystemTestMethod() {
        if (Bird.canBreath()) {
            //do Somthing
        }

    }
}


//If you try to override it, it will be treated as new method in eagle class
// if you try to add annotation to it, it will throw compilation Error
/*
public class Eagle implements Bird {
    public boolean canBreath() {
        System.out.println("In interface");
        return true;
    }
}
*/