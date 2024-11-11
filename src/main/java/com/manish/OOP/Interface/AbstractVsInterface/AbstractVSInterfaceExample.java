package com.manish.OOP.Interface.AbstractVsInterface;

// Abstract class
abstract class Animal {
    private String name;

    // Constructor in abstract class
    public Animal(String name) {
        this.name = name;
    }

    // Abstract method (no implementation)
    public abstract void makeSound();

    // Concrete method
    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
}

// Interface with abstract methods and default method
interface Pet {
    // Abstract method
    void play();

    // Default method (concrete method)
    default void beFriendly() {
        System.out.println("Being friendly.");
    }

    // Static method (concrete method)
    static void showAffection() {
        System.out.println("Showing affection.");
    }
}

/*
 In Java, interfaces can now provide concrete methods using the default and static access modifiers, introduced in Java 8.
 This allows for greater flexibility and functionality within interfaces. Here's a breakdown of how these methods work and their significance:
*/

// Class that extends abstract class and implements interface
class Dog extends Animal implements Pet {
    public Dog(String name) {
        super(name); // Call the constructor of the abstract class
    }

    @Override
    public void makeSound() {
        System.out.println("Dog barks.");
    }

    @Override
    public void play() {
        System.out.println("Dog is playing.");
    }
}


public class AbstractVSInterfaceExample {
    public static void main(String[] args) {
        Dog myDog = new Dog("Buddy");
        myDog.makeSound(); // Dog barks.
        myDog.sleep(); // Buddy is sleeping.
        myDog.play(); // Dog is playing.
        myDog.beFriendly(); // Being friendly.

        Pet.showAffection(); // Showing affection.
    }
}


/*

## What is difference between abstract class and interface?

Abstract classes and interfaces are both used to achieve abstraction and define contracts for classes in Java, but they have some key differences:

**Abstract****Class**:

- An abstract class is a class that cannot be instantiated on its own and may contain abstract methods (methods without implementation) as well as concrete methods (methods with implementation).
- Abstract classes can have constructors, instance variables, and non-abstract methods, in addition to abstract methods.
- A subclass must provide implementations for all abstract methods defined in its abstract superclass, or it must itself be declared abstract.
- Abstract classes are used to define common behavior and characteristics shared among subclasses, serving as a blueprint for creating concrete subclasses.

**Interface**:

- An interface is a reference type similar to a class but contains only abstract methods, constants (static final fields), and default/static methods (methods with default implementations).
- An interface is a collection of abstract methods and constants (i.e., fields with static and final modifiers) that define a contract between a class and the outside world.
- It specifies a set of methods that a class that implements the interface must implement, but it does not provide any implementation for those methods
- Interfaces cannot have constructors or instance variables, only method signatures.
- A class implements an interface by providing concrete implementations for all the methods declared in the interface.
- Interfaces are used to define contracts that classes can choose to implement, enabling multiple inheritance of type (a class can implement multiple interfaces).

**Key Differences:**

- An abstract class can have both abstract and concrete methods, while an interface can have abstract methods, default methods, and static methods.
- A class can extend only one abstract class, but it can implement multiple interfaces.
- Abstract classes can have constructors, whereas interfaces cannot.
- Abstract classes are used to provide a common base for subclasses to extend, while interfaces define contracts that classes can implement to achieve polymorphism.


 */