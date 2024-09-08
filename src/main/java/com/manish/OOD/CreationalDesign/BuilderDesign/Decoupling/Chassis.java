package com.manish.OOD.CreationalDesign.BuilderDesign.Decoupling;

public class Chassis {
    private final String color;

    private Chassis(Builder builder) {
        this.color = builder.color;
    }

    public String getColor() {
        return color;
    }

    public static class Builder {
        private String color;

        public Builder withColor(String color) {
            this.color = color;
            return this;
        }

        public Chassis build() {
            return new Chassis(this);
        }
    }
}
