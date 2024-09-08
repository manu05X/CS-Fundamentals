package com.manish.OOD.CreationalDesign.FactoryDesign.AbstractFactory.Car;

// Client code that uses the abstract factory to create related objects
public class Car {
    private Engine engine;
    private Wheels wheels;
    private Seats seats;

    public Car(CarFactory factory) {
        engine = factory.createEngine();
        wheels = factory.createWheels();
        seats = factory.createSeats();
    }

    public void design() {
        engine.design();
        wheels.design();
        seats.design();
    }
}
