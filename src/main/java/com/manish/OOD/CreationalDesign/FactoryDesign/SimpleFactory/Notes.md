
# Design Patterns: Simple Factory vs. Factory Method

## Simple Factory Pattern

### Concept
The Simple Factory Pattern encapsulates the object creation logic within a single factory class. The factory class contains a method that takes an input parameter and returns the appropriate object based on that parameter. The client interacts only with this factory class to obtain the desired object.

### Structure
1. **Product Interface**:
   Defines common operations that all concrete products must implement.

2. **Concrete Products**:
   Implement the product interface, providing specific behavior for each product type.

3. **Factory**:
   Contains a static method (or a non-static method in some variations) that decides which concrete product to instantiate based on the input parameter.

4. **Client**:
   Uses the factory class to create the product by passing parameters.

### Examples
#### Structure:

1. **Product Interface (`Vehicle`):**
Defines common operations for all products.
2. **Concrete Products (`Car`, `Bike`):**
Implement the Vehicle interface.
3. **Factory (`VehicleFactory`):**
Contains a static method `createVehicle(String type)` which decides which concrete product to instantiate based on the input parameter.
4. **Client:**
Calls `VehicleFactory.createVehicle("car")` to get the desired object.

```java
public interface Vehicle {
    void drive();
}

public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car.");
    }
}

public class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a bike.");
    }
}

public class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        if (type.equals("car")) {
            return new Car();
        } else if (type.equals("bike")) {
            return new Bike();
        } else {
            throw new IllegalArgumentException("Invalid vehicle type: " + type);
        }
    }
}

public class Client {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.createVehicle("car");
        car.drive();
    }
}

```

### Key Points
- **Encapsulation**: The factory class encapsulates the creation logic, simplifying client code.
- **Flexibility**: Adding new types requires modifying the factory class, which can make it complex as more types are added.
- **Dependency**: The client depends directly on the factory method, which can lead to tight coupling.

## Factory Method Pattern

### Concept
The Factory Method Pattern delegates the creation of objects to subclasses through an abstract method defined in an abstract creator class. Each concrete subclass implements this method to create a specific type of object. The client interacts with the abstract creator class, and the specific object creation is handled by the subclass.

### Structure
1. **Product Interface  (`Vehicle`):**
   Defines common operations for all concrete products.

2. **Concrete Products (`Car`, `Bike`)**:
   Implement the product interface, providing specific behavior for each product type. Implement the Vehicle interface.

3. **Abstract Creator (`VehicleFactory`)**:
   Defines an abstract method `createVehicle()` which must be implemented by subclasses for creating products. This class may also include other methods that use the product.

4. **Concrete Creators (`CarFactory`, `BikeFactory`)**:
   Implement the `createVehicle()` method to return specific product instances.. Each factory subclass is responsible for creating a particular type of product.

5. **Client**:
   Interacts with the abstract `creator class` and uses its factory method to obtain the product.

### Example
```java
public abstract class VehicleFactory {
    public abstract Vehicle createVehicle();
}

public class CarFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}

public class BikeFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Bike();
    }
}

public class Client {
    public static void main(String[] args) {
        VehicleFactory factory = new CarFactory();
        Vehicle car = factory.createVehicle();
        car.drive();
    }
}

```


### Key Points
- **Separation of Concerns**: Object creation logic is separated into different subclasses, improving modularity.
- **Flexibility**: Adding new types involves creating new factory subclasses without modifying existing code.
- **Extensibility**: The client interacts with the abstract creator, making it easier to extend the system with new types.

## Summary of Differences

| Aspect                       | Simple Factory                                      | Factory Method                                  |
|------------------------------|------------------------------------------------------|-------------------------------------------------|
| **Object Creation**          | Centralized in a single factory class               | Delegated to subclasses through an abstract method |
| **Flexibility**              | Requires modification of the factory class to add new types | Adding new types involves creating new factory subclasses |
| **Responsibility**           | Factory class handles all object creation logic     | Responsibility is divided among concrete factory subclasses |
| **Client Interaction**       | Directly interacts with the factory method          | Interacts with the abstract creator class       |







In summary, the Simple Factory Pattern centralizes the creation logic in one class, while the Factory Method Pattern uses subclassing to delegate the creation process, promoting better scalability and adherence to the Open/Closed Principle.
