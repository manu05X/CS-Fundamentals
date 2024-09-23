package com.manish.Codes.CoreJava.CreationalPatterns.PrototypePattern.Example1;


// com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main class to test the Prototype pattern
public class PrototypePatternExample {
    public static void main(String[] args) {
        // Create a prototype registry
        PrototypeRegistry registry = new PrototypeRegistry();

        // Add a Circle prototype to the registry
        Circle1 circlePrototype = new Circle1(5);
        registry.addPrototype("Circle", circlePrototype);

        try {
            // Clone the Circle prototype
            Circle1 clonedCircle = (Circle1) registry.getPrototype("Circle");

            // Print the radius of the cloned Circle
            System.out.println("Radius of cloned Circle: " + clonedCircle.getRadius()); // Output: Radius of cloned Circle: 5
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
