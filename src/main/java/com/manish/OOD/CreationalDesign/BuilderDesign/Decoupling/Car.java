package com.manish.OOD.CreationalDesign.BuilderDesign.Decoupling;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final Engine engine;
    private final Chassis chassis;
    private final List<Wheel> wheels;

    private Car(Builder builder) {
        this.engine = builder.engine;
        this.chassis = builder.chassis;
        this.wheels = builder.wheels;
    }

    public Engine getEngine() {
        return engine;
    }

    public Chassis getChassis() {
        return chassis;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public static class Builder {
        private Engine engine;
        private Chassis chassis;
        private List<Wheel> wheels;

        public Builder withEngine(Engine engine) {
            this.engine = engine;
            return this;
        }

        public Builder withChassis(Chassis chassis) {
            this.chassis = chassis;
            return this;
        }

        public Builder withWheels(Wheel wheel) {
            if (this.wheels == null) {
                this.wheels = new ArrayList<>();
            }
            this.wheels.add(wheel);
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}

