package com.manish.OOD.CreationalDesign.BuilderDesign.Validate;

public class Main {
    public static void main(String[] args) {
        // Using the builder to create a Person object
        Person person = new Person.Builder()
                .name("John Doe")
                .age(25)
                .email("johndoe@example.com")
                .build();

        // Displaying the person's details
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Email: " + person.getEmail());
    }
}