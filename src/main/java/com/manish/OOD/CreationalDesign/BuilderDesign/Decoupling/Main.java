package com.manish.OOD.CreationalDesign.BuilderDesign.Decoupling;

public class Main {
    public static void main(String[] args) {
        Car car = new Car.Builder()
                .withEngine(new Engine.Builder().withType("V8").build())
                .withChassis(new Chassis.Builder().withColor("red").build())
                .withWheels(new Wheel.Builder().withSize(20).build())
                .withWheels(new Wheel.Builder().withSize(20).build())
                .withWheels(new Wheel.Builder().withSize(20).build())
                .withWheels(new Wheel.Builder().withSize(20).build())
                .build();

        System.out.println("Engine type: " + car.getEngine().getType());
        System.out.println("Chassis color: " + car.getChassis().getColor());
        System.out.println("Number of wheels: " + car.getWheels().size());
    }
}