package com.manish.OOD.CreationalDesign.FactoryDesign.Car;

// Concrete factory for sports cars
public class SportsCarFactory implements CarFactory {
    public Engine createEngine() {
        return new SportsEngine();
    }

    public Wheels createWheels() {
        return new SportsWheels();
    }

    public Seats createSeats() {
        return new SportsSeats();
    }
}
