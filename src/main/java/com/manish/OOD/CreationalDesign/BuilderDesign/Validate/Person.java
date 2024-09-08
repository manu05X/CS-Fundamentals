package com.manish.OOD.CreationalDesign.BuilderDesign.Validate;

public class Person {
    private String name;  // Name of the person
    private int age;      // Age of the person
    private String email; // Email of the person

    // Private constructor to initialize the Person object using the Builder
    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
    }

    // Getters for name, age, and email
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    // Static inner Builder class for constructing Person objects
    public static class Builder {
        private String name;
        private int age;
        private String email;

        // Method to set the name in the builder
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        // Method to set the age in the builder, with validation
        public Builder age(int age) {
            if (age < 0 || age > 120) {
                throw new IllegalArgumentException("Invalid age: " + age);
            }
            this.age = age;
            return this;
        }

        // Method to set the email in the builder, with validation
        public Builder email(String email) {
            if (!isValidEmail(email)) {
                throw new IllegalArgumentException("Invalid email: " + email);
            }
            this.email = email;
            return this;
        }

        // Private helper method to validate email
        private boolean isValidEmail(String email) {
            // Implement a basic email validation logic
            return email.contains("@") && email.contains(".");
        }

        // Method to construct the final Person object
        public Person build() {
            if (name == null || name.isEmpty()) {
                throw new IllegalStateException("Name is required");
            }
            if (age == 0) {
                throw new IllegalStateException("Age is required");
            }
            if (email == null || email.isEmpty()) {
                throw new IllegalStateException("Email is required");
            }
            return new Person(this);
        }
    }
}
