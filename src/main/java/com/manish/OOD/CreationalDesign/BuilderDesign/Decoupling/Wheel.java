package com.manish.OOD.CreationalDesign.BuilderDesign.Decoupling;

public class Wheel {
    private final int size;

    private Wheel(Builder builder) {
        this.size = builder.size;
    }

    public int getSize() {
        return size;
    }

    public static class Builder {
        private int size;

        public Builder withSize(int size) {
            this.size = size;
            return this;
        }

        public Wheel build() {
            return new Wheel(this);
        }
    }
}
