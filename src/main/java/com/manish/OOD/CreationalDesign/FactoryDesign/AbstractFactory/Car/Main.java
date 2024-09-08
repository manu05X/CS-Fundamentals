package com.manish.OOD.CreationalDesign.FactoryDesign.AbstractFactory.Car;

// Example usage
public class Main {
    public static void main(String[] args) {
        CarFactory factory = new LuxuryCarFactory();
        Car luxuryCar = new Car(factory);
        luxuryCar.design();

        factory = new SportsCarFactory();
        Car sportsCar = new Car(factory);
        sportsCar.design();
    }
}
