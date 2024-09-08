package com.manish.OOD.CreationalDesign.BuilderDesign.Example1;

public class Car {
    private String make;
    private String model;
    private int year;
    private String color;

    private Car(String make, String model, int year, String color) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                '}';
    }

    public static class CarBuilder {
        private String make;
        private String model;
        private int year;
        private String color;

        public CarBuilder() {
        }

        public CarBuilder setMake(String make) {
            this.make = make;
            return this;
        }

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(make, model, year, color);
        }
    }
}
/*
In this example, the Car class represents the object that we want to create.
We have a separate Car.CarBuilder class, which sets each attribute of the Car object separately,
and then constructs the final Car object using the Car.CarBuilder.build() method.
 */