package com.manish.OOP.PassByValue;



public class ObjectPerson {
    String name;

    public ObjectPerson(String name){
        this.name = name;
    }

    static void modifyReference(ObjectPerson p) {
        p = new ObjectPerson("Alice");  // Changing where the copy points
    }

    static void modifyObject(ObjectPerson p) {
        p.name = "Bob";  // Modifying the object through the copy
    }

    public static void main(String[] args) {
        ObjectPerson original = new ObjectPerson("Charlie");
        System.out.println(original.name);

        modifyReference(original);
        System.out.println(original.name); // Still "Charlie"

        modifyObject(original);
        System.out.println(original.name); // Now "Bob"

    }
}

/*

When Changes Affect the Original
Object State Changes: When you modify the object's internal state through the passed reference (like p.name = "Bob"), the changes persist because both the original and copied references point to the same object.

Array Elements: Arrays are objects, so modifying elements affects the original array.

When Changes Don't Affect the Original
Reassigning the Parameter: When you assign a new object to the parameter (like p = new Person()), this only changes where the copy points, not the original reference.

Primitive Parameters: Any changes to primitive parameters don't affect the original.

Visual Analogy
Imagine references as remote controls for a TV:

Passing a reference is like giving someone a copy of your remote

They can change channels (modify object state)

But if they get a new remote (reassign the reference), your original remote still works the same way

This is why Java is pass-by-value - you're always passing copies, but with objects those copies are references to the same underlying object.
 */