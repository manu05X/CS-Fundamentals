
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

**Pizza Store and Pizza Factory Analogy**
- **Step 1: Ordering the Pizza**
   - You walk into a Pizza Store and place an order for the type of pizza you want, such as cheese or pepperoni.
   - In the code, this is represented by calling pizzaStore.orderPizza("cheese"); where the customer orders a "cheese" pizza.

- **Step 2: Waiter Takes the Order to the Kitchen (Factory)**
  - After taking your order, the waiter passes the order to the Pizza Factory (which acts as the kitchen), where pizzas are actually prepared.
  - This is represented in the code by creating an instance of PizzaStore with the PizzaFactory inside: PizzaStore(pizzaFactory);.

- **Step 3: Chef Checks the Order Type** 
  - In the kitchen, the chef checks which type of pizza was ordered (cheese, pepperoni, or veggie). The chef ensures the requested pizza is available and can be made.
  - In the code, this happens when the factory checks if (type.equals("cheese")) to match the pizza type.
  
- **Step 4: Pizza is Prepared in the Kitchen (Factory)**
  - Once the chef confirms the type of pizza, the pizza is prepared in the oven. The specific type of pizza (CheesePizza, PepperoniPizza, VeggiePizza) is created based on your order.
  - This corresponds to the code where the factory creates the appropriate pizza object: pizza = new CheesePizza();.

- **Step 5: Waiter Receives the Pizza from the Kitchen** 
  - After the pizza is prepared, it is handed over to the waiter, who will take it to your table.
  - In the code, this is the moment when the PizzaFactory returns the pizza object to the PizzaStore: return pizza;.

- **Step 6: Pizza is Served to the Customer** 
  - Finally, the waiter brings your pizza to the table, and you can enjoy your meal.

- This corresponds to the code where the PizzaStore returns the final pizza to the main method, and the pizza’s preparation, baking, cutting, and boxing are displayed as output on the command line.

```java
// Product: Pizza interface
public interface Pizza {
    public void prepare();
    public void bake();
    public void cut();
    public void box();
}

// Concrete Product: CheesePizza class
public class CheesePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing cheese pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking cheese pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting cheese pizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing cheese pizza");
    }
}

// Concrete Product: PepperoniPizza class
public class PepperoniPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing pepperoni pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking pepperoni pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting pepperoni pizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing pepperoni pizza");
    }
}

// Concrete Product: VeggiePizza class
public class VeggiePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing veggie pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking veggie pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting veggie pizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing veggie pizza");
    }
}

// Simple Factory: PizzaFactory class
public class PizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }
        return pizza;
    }
}

// Client: PizzaStore class
public class PizzaStore {
    PizzaFactory pizzaFactory;

    public PizzaStore(PizzaFactory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = pizzaFactory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    public static void main(String[] args) {
        PizzaFactory pizzaFactory = new PizzaFactory();
        PizzaStore pizzaStore = new PizzaStore(pizzaFactory);

        pizzaStore.orderPizza("cheese");
        pizzaStore.orderPizza("pepperoni");
        pizzaStore.orderPizza("veggie");
    }
}
```




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
