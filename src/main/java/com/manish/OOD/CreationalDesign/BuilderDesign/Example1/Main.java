package com.manish.OOD.CreationalDesign.BuilderDesign.Example1;

public class Main {
    public static void main(String[] args) {
        Car car = new Car.CarBuilder()
                .setMake("Toyota")
                .setModel("Camry")
                .setYear(2021)
                .setColor("Red")
                .build();
        System.out.println(car);

    }
}
/*
In this example, we use the Car.CarBuilder class to create a Car object with a make of Toyota,
model of Camry, the year of 2021, and color of Red.
The Car.CarBuilder.build() method constructs the final Car object, which we then print to the console
 */
