package com.manish.Codes.CoreJava.Oops.EncapsulationExample;

public class EncapsulationExample {
    public static void main(String[] args) {

        //Think of a capsule as a person.
        // The person's name and age are private information,
        // and they have methods to get or update this information safely.
        Person person = new Person("John", 30);
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());

        person.setAge(35); // updating age
        System.out.println("Updated Age: " + person.getAge());
    }
}
