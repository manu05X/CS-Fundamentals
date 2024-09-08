package com.manish.OOD.CreationalDesign.BuilderDesign.Decoupling;

public class Engine {
    private final String type;

    private Engine(Builder builder) {
        this.type = builder.type;
    }

    public String getType() {
        return type;
    }

    public static class Builder {
        private String type;

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Engine build() {
            return new Engine(this);
        }
    }
}
