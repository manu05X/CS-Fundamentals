package com.manish.OOD.CreationalDesign.FactoryDesign.AbstractFactory.Car;

// Abstract Factory interface
public interface CarFactory {
    public Engine createEngine();
    public Wheels createWheels();
    public Seats createSeats();
}

