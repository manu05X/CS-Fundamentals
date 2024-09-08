package com.manish.OOD.CreationalDesign.FactoryDesign.Car;

// Concrete factory for luxury cars
public class LuxuryCarFactory implements CarFactory {
    public Engine createEngine() {
        return new LuxuryEngine();
    }

    public Wheels createWheels() {
        return new LuxuryWheels();
    }

    public Seats createSeats() {
        return new LuxurySeats();
    }
}
