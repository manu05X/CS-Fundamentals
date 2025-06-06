## Creational Design Pattern:
___

# Index

1. [Creational Design Pattern](#creational-design-pattern)
    - [Types of Creational Design Patterns](#types-of-creational-design-patterns)
        - [Singleton Pattern](#singleton-pattern)
        - [Factory Method Pattern](#factory-method-pattern)
        - [Abstract Factory Pattern](#abstract-factory-pattern)
        - [Builder Pattern](#builder-pattern)
        - [Prototype Pattern](#prototype-pattern)

2. [Singleton Design Pattern](#singleton-design-pattern)
    - [Example 1](#example-1)
    - [Example 2](#example-2)
    - [Usage Scenarios](#usage-scenarios)
        - [Database Connection](#database-connection)

3. [Factory Design Pattern](#factory-design-pattern)
    - [Types of Factory Design Pattern](#types-of-factory-design-pattern)
        - [Simple Factory](#simple-factory)
        - [Factory Method](#factory-method)
        - [Abstract Factory](#abstract-factory)
        - [Practical Factory Pattern](#practical-factory-pattern)
    - [When to Use the Factory Method Pattern](#when-to-use-the-factory-method-pattern)

4. [Simple Factory Design Pattern](#simple-factory-design-pattern)
    - [Key Concepts](#key-concepts)
    - [Pizza Ordering System Example](#pizza-ordering-system-example)
    - [Refined Pizza Store and Pizza Factory Analogy](#refined-pizza-store-and-pizza-factory-analogy)


___

## Types of Creational Design Patterns
In software engineering, `Creational Design Patterns` are a category of design patterns that focus on object creation mechanisms, trying to create objects in a manner suitable to the situation. The main goal of these patterns is to provide more flexibility and reusability to the code.

There are `five types` of `Creational Design Patterns:`

1. **Singleton Pattern :** This pattern ensures that a class has `only one instance`, and provides a `global point of access to it`. It is useful in situations where you need to limit the number of instances of a class that can be created.
2. **Factory Method Pattern:** This pattern provides an interface for creating objects, but allows subclasses to decide which class to instantiate. It is useful when you want to defer the creation of an object to subclasses.
3. **Abstract Factory Pattern:** This pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes. It is useful when you need to create objects that have dependencies on other objects.
4. **Builder Pattern:** This pattern separates the construction of a complex object from its representation, allowing you to create different representations of the same object. It is useful when you need to create complex objects that have multiple parts.
5. **Prototype Pattern**: This pattern creates new objects by cloning existing ones. It is useful when the cost of creating a new object is high, and you want to avoid it by cloning an existing one.

Each of these patterns has its own advantages and disadvantages and can be used in different situations. It is important to choose the right pattern based on your specific needs.

# Singleton Design Pattern

The Singleton pattern can be useful in a variety of scenarios where we need to ensure that there is only one instance of a particular class throughout the lifetime of an application and that this instance is globally accessible.

#### Example 1:

```Java
public class Singleton {

   private static Singleton instance;

   private Singleton(){}

   public static Singleton getInstance(){
      if(instance == null){
         instance = new Singleton();
      }
      return instance;
   }

   public void showMessage(){
      System.out.println("Hello World!");
   }
}
```

- In this example, we create a class called "`Singleton`" that has a `private constructor`, so it cannot be `instantiated` from `outside` the class. We also declare a `private static variable` "`instance`"` of the same class, which is used to store the `single instance` of the class.

- The `getInstance()` method is used to access the `single instanc`e of the class. If the instance has not yet been created, the method creates a `new instance and returns i`t. Otherwise, it simply `returns` the `existing instance`.

- The `showMessage()` method is just an example of a method that can be called on the Singleton instance. In a real-world example, this method would perform some useful operations in the context of the system.

To use the Singleton class, you can simply call the getInstance() method to get the single instance of the class, and then call any methods on that instance. Here's an example of how to use the Singleton class:

```Java
public class com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main {
   public static void main(String[] args) {

      Singleton singleton = Singleton.getInstance();

      singleton.showMessage();
   }
}
```

In this example, we create a new Singleton instance by calling the getInstance() method, and then we call the showMessage() method on that instance.

#### Example 2:

Here's an example of implementing a singleton class with double-checked locking in Java:

```java
public class Singleton {

    private volatile static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }
}


/*

1. Singleton Class Definition:
The class Singleton is designed such that only one instance of this class can be created throughout the application's lifecycle.
2. Private Constructor:
private Singleton():
The constructor is declared private, which means that no other class can create an instance of Singleton directly using the new keyword. This enforces the Singleton pattern by preventing external instantiation.
3. Static Volatile Instance:
private volatile static Singleton instance;
The instance of the Singleton class is declared as static, meaning it is shared among all instances of the class and belongs to the class itself, not to any individual object.
volatile: The volatile keyword ensures that multiple threads handle the instance variable correctly. It prevents the compiler from caching the value, so any write to instance is immediately visible to other threads. This is important in multi-threaded environments to ensure visibility across threads.
4. getInstance() Method (Lazy Initialization):
public static Singleton getInstance() {
This is the core method to access the single instance of the Singleton class. It ensures that the instance is created only when needed, which is known as lazy initialization.
5. Double-Checked Locking (DCL):
if (instance == null):
First, the code checks if the instance is null. If null, it means no instance has been created yet.
This check is done outside the synchronized block to avoid unnecessary synchronization, which can degrade performance when multiple threads call this method.
synchronized (Singleton.class) {
If instance is null, we synchronize on the Singleton.class to prevent multiple threads from creating multiple instances simultaneously.
This ensures thread safety. Only one thread can execute the code inside this block at a time.
if (instance == null) { instance = new Singleton(); }
Inside the synchronized block, we again check if instance is still null. This is necessary because multiple threads may have passed the first if check before acquiring the lock.
If it's still null, a new instance of Singleton is created.
This is called Double-Checked Locking because the instance == null check is performed twice: once before entering the synchronized block and once inside it.
6. sayHello() Method:
public void sayHello() { System.out.println("Hello World!"); }
A simple method that prints "Hello World!" to the console. This method is just a placeholder for demonstrating that the Singleton instance can have behavior.
Why Double-Checked Locking?
Without DCL, every call to getInstance() would require acquiring the lock, even after the instance is initialized, which can degrade performance. DCL minimizes synchronization overhead by only locking when necessary (i.e., during the first initialization).
Key Benefits:
Lazy Initialization: The Singleton instance is only created when it's first needed, saving resources.
Thread Safety: The synchronized block ensures that only one thread can create the instance, preventing race conditions.
Performance: By checking instance == null twice and minimizing the synchronization block, it avoids the overhead of locking after the Singleton instance has been created.
 */
```

- In this implementation, we have added the `volatile` keyword to the `instance variable`, which ensures that any changes made to the variable are `immediately` visible to _all threads_. 
- We also use `double-checked locking` to ensure that only one instance of the `Singleton class is created`.
- The `getInstance()` method first checks if the instance variable is `null` without acquiring the lock on the `Singleton class`.
- `getInstance() Method (Lazy Initialization):` It ensures that the instance is created only when needed, which is known as lazy initialization.
- If it is null, the method acquires the lock and then checks again to see if the instance variable is still `null`. 
- If it is, the method creates a new instance of the `Singleton class`.

By using `double-checked locking` and making the instance `variable volatile`, we can ensure that our `Singleton class` is thread-safe and can be safely used in a `multi-threaded` environment.

> Here are some scenarios where using the Singleton pattern can be helpful:
>
> - `Database Connection :` When an application needs to connect to a database, it's often useful to use a Singleton to ensure that there is only one connection to the database throughout the application's lifetime.
> - `Configuration Management :` In many applications, there is a need for a single source of configuration information that can be accessed from various parts of the application. A Singleton can be used to store this configuration data.
> - `Logging :`  This ensures that all log messages are written to the same location and that there is only one instance of the logging system.
> - `Caching :` There is only one instance of the cache and that all parts of the application can access the same cached data.
> - `Thread Pools :` This ensures that there is only one instance of the thread pool and that all tasks are executed on the same pool of threads.
> - `Device Drivers :` In many applications, it's necessary to interact with hardware devices in order to perform tasks. The Singleton pattern can be used to manage a device driver

1. **Database Connection:**
   When an application needs to connect to a database, it's often useful to use a Singleton to ensure that there is only one connection to the database throughout the application's lifetime.

```java
public class DatabaseConnection {
    private static volatile DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        // Initialize database connection
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}

```

# Factory Design Pattern:

The Factory Design Pattern is a creational pattern that provides an interface to create objects in a superclass but allows subclasses to alter the type of objects that will be created. The pattern separates the responsibility of creating an object from the client that requests the object.

There are three subtypes of the Factory Design Pattern:

1. **Simple Factory:** This subtype of the Factory Design Pattern is the most basic one. In this pattern, a factory class is responsible for creating objects based on the input provided. The client provides the necessary input to the factory, which in turn creates the required object.
2. **Factory Method:** In the Factory Method Design Pattern, the creation of objects is delegated to the subclasses. This means that the factory method in the superclass is abstract, and each subclass provides its own implementation of the factory method to create the object.
3. **Abstract Factory:** The Abstract Factory Design Pattern is used to create families of related objects. In this pattern, an abstract factory is defined that provides an interface to create a set of related objects. Each subclass of the abstract factory provides its own implementation of the factory methods to create the objects.
4. **Practical Factory Pattern:** It is same as simple factory pattern just a different name.

In summary, the Factory Design Pattern provides a way to create objects without exposing the creation logic to the client. It promotes loose coupling by decoupling the client from the concrete classes, making the code more flexible and easier to maintain.

> **When to Use the Factory Method Pattern**
> - **Object Creation Complexity:** When the creation of an object involves complex logic that cannot be handled by a simple constructor. The factory method provides a single place to manage that complexity.
> - **Decoupling:** When you want to decouple the client code from the actual classes of the objects it needs to create. This makes the client code more flexible and easier to extend.
> - **Configuration and Flexibility:** When the system needs to be configured with one of multiple products dynamically. The factory method allows you to change the type of the created objects at runtime.
> - **Product Families:** When you work with a family of products that share a common interface but have different implementations. The factory method lets you create a product without specifying the exact class of the object that will be created.



#### Simple Factory Design Pattern:

**Key Concepts**
- **Creator Class**: This class declares the factory method, which returns objects of a Product class.
- **Concrete Creator Class**: Subclasses that override the factory method to change the class of objects that will be created.
- **Product Interface**: An interface or abstract class that defines the type of object the factory method will return.
- **Concrete Product Class**: Concrete implementations of the Product interface.


let's take the example of a pizza ordering system to explain the Simple Factory design pattern.

In a pizza ordering system, we have different types of pizzas such as cheese pizza, pepperoni pizza, and veggie pizza. The Simple Factory pattern can be used to create instances of these pizzas.

```Java
//Example 1:
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

/*
Summary:
Creator Class: PizzaFactory
Concrete Creator Class: PizzaStore
Product Interface: Pizza
Concrete Product Classes: CheesePizza, PepperoniPizza, VeggiePizza



    - Justifying the Factory Design Pattern:
The Factory Design Pattern is defined as:
A design pattern that provides a way to encapsulate the object creation process, allowing a client to request objects without knowing the exact class to instantiate.

In your code, this definition is clearly justified as follows:

1> Encapsulation of Object Creation:
    - The PizzaFactory class is solely responsible for creating different types of Pizza objects. It encapsulates the decision of which specific subclass (CheesePizza, PepperoniPizza, VeggiePizza) to instantiate based on the input type.
    - The client (PizzaStore) does not directly instantiate the Pizza objects. Instead, it delegates this responsibility to the factory.

2> Client Doesn't Know the Concrete Class:
    - The PizzaStore class interacts with the Pizza interface and uses it without knowing the exact concrete class (CheesePizza, PepperoniPizza, or VeggiePizza) that is created. This makes the code flexible and easier to extend if new types of pizzas are added.
    - For example, if a new type of pizza like MargheritaPizza is introduced, the PizzaFactory can be updated to create this new pizza without changing the PizzaStore or how orderPizza is called.
3> Flexibility:
    - The PizzaFactory can decide which concrete class to return based on various factors (in this case, the pizza type string), providing flexibility.
    - The client is decoupled from the specific pizza creation logic, allowing easier maintenance and the potential for more sophisti

 */

```
### Diagram
```mermaid
classDiagram
    class Pizza {
        <<interface>>
        +prepare()
        +bake()
        +cut()
        +box()
    }

    class CheesePizza {
        +prepare()
        +bake()
        +cut()
        +box()
    }

    class PepperoniPizza {
        +prepare()
        +bake()
        +cut()
        +box()
    }

    class VeggiePizza {
        +prepare()
        +bake()
        +cut()
        +box()
    }

    class PizzaFactory {
        +createPizza(String type) Pizza
    }

    class PizzaStore {
        -pizzaFactory: PizzaFactory
        +PizzaStore(PizzaFactory)
        +orderPizza(String type) Pizza
    }

    Pizza <|-- CheesePizza
    Pizza <|-- PepperoniPizza
    Pizza <|-- VeggiePizza

    PizzaStore --> PizzaFactory
    PizzaStore --> Pizza
    PizzaFactory --> Pizza
```


#### Refined Pizza Store and Pizza Factory Analogy
**Step 1: Customer Orders a Pizza**
    
- You walk into a Pizza Store and place an order for a specific type of pizza, such as "cheese," "pepperoni," or "veggie."
- In the code, this is represented by the method call `pizzaStore.orderPizza("cheese");`. The customer specifies the type of pizza they want when they place their order.

**Step 2: Waiter Takes the Order to the Kitchen (Factory)**

- The waiter (who represents the PizzaStore) takes your order and heads to the kitchen (which is the PizzaFactory). The kitchen is where all the pizzas are prepared.
- In the code, this process happens when the `PizzaStore` uses the factory to create the correct pizza type: `pizzaFactory.createPizza(type);`.

**Step 3: Chef Checks the Order and Decides What to Cook**

- The `chef` (the `PizzaFactory`) receives the order and checks what kind of pizza needs to be made. The chef will look at the order slip and decide whether to prepare a cheese pizza, a pepperoni pizza, or a veggie pizza.
- In the code, the factory checks the pizza type with a series of if conditions `(if (type.equals("cheese"))`, etc.) and decides which pizza class to instantiate.

**Step 4: The Chef Prepares the Pizza (Creates the Object)**
- Once the chef knows the type of pizza to prepare, they start making it. For example, if the order is for a cheese pizza, the chef prepares that specific type of pizza.
- In the code, this step is where the `PizzaFactory` creates a new instance of the appropriate pizza type (e.g., `new CheesePizza()`;). Each pizza type (CheesePizza, PepperoniPizza, VeggiePizza) is represented by a different class, and the factory creates the correct object for the order.

**Step 5: The Pizza is Handed Over to the Waiter**
- Once the pizza is fully prepared in the kitchen, the chef hands it over to the waiter, who is now responsible for delivering it to the customer.
- In the code, the factory returns the created pizza object back to the `PizzaStore: return pizza;`.

**Step 6: Waiter Serves the Pizza to the Customer**
- The waiter then brings the pizza to your table, and you can enjoy it. The pizza goes through the final stages of preparation (like cutting and boxing) before being served.
- In the code, the `PizzaStore` calls methods like `pizza.prepare()`, `pizza.bake()`, `pizza.cut()`, and `pizza.box()`, which output the pizza preparation steps. Finally, the pizza is returned to the main method, simulating the pizza being served to the customer.

In this code implementation, we have a Pizza interface that defines the methods that every pizza should have. We also have concrete implementations of Pizza interface such as CheesePizza, PepperoniPizza, and VeggiePizza.

The PizzaFactory class provides a simple factory method createPizza(String type) that takes a type parameter and returns an instance of Pizza based on the input provided by the client.

> One of the disadvantages of the Simple Factory pattern is that it violates the Open-Closed Principle. If we need to add a new type of product, we need to modify the factory code, which means we need to recompile and redeploy the code.

##### Example 2:

Suppose we have an interface called Vehicle:

```java
public interface Vehicle {
    void drive();
}
// We have three classes that implement the Vehicle interface: Car, Truck, and Motorcycle.
public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car.");
    }
}

public class Truck implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a truck.");
    }
}

public class Motorcycle implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a motorcycle.");
    }
}

//Finally, we have a VehicleFactory class that creates the different types of vehicles:

public class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        if (type.equalsIgnoreCase("car")) {
            return new Car();
        } else if (type.equalsIgnoreCase("truck")) {
            return new Truck();
        } else if (type.equalsIgnoreCase("motorcycle")) {
            return new Motorcycle();
        } else {
            throw new IllegalArgumentException("Invalid vehicle type: " + type);
        }
    }
}

//We can use the VehicleFactory to create different types of vehicles:

Vehicle car = VehicleFactory.createVehicle("car");
Vehicle truck = VehicleFactory.createVehicle("truck");
Vehicle motorcycle = VehicleFactory.createVehicle("motorcycle");

car.drive();
truck.drive();
motorcycle.drive();
```
### Diagram
```mermaid
classDiagram
    class Vehicle {
        <<interface>>
        +drive()
    }

    class Car {
        +drive()
    }

    class Truck {
        +drive()
    }

    class Motorcycle {
        +drive()
    }

    class VehicleFactory {
        +createVehicle(String type) Vehicle
    }

    class Main {
        +main(String[] args)
    }

    Vehicle <|-- Car
    Vehicle <|-- Truck
    Vehicle <|-- Motorcycle

    VehicleFactory ..> Vehicle : creates
    Main ..> VehicleFactory : uses
    Main ..> Vehicle : uses
```


#### Example 3:

Suppose you are working on an e-commerce website and you need to generate invoices for different types of orders. You have three types of orders - "PhysicalOrder", "DigitalOrder", and "ServiceOrder". Each of these types of orders has its own invoice format.

To implement this, you can use the Factory pattern. You can define an abstract class called "Order" which will have a method to generate the invoice. Then, you can create three concrete classes, "PhysicalOrder", "DigitalOrder", and "ServiceOrder", which will implement the "Order" interface and provide their own implementation of the generateInvoice() method.

Next, you can create a "OrderFactory" class that will create objects of the "Order" interface based on the type of order. The "OrderFactory" class will have a method called "createOrder" which will take the type of order as an input and return an object of the corresponding type.

```java
// Abstract Order class
public abstract class Order {
   public abstract void generateInvoice();
}

// Concrete PhysicalOrder class
public class PhysicalOrder extends Order {
   public void generateInvoice() {
      // Implementation for generating invoice for physical order
   }
}

// Concrete DigitalOrder class
public class DigitalOrder extends Order {
   public void generateInvoice() {
      // Implementation for generating invoice for digital order
   }
}

// Concrete ServiceOrder class
public class ServiceOrder extends Order {
   public void generateInvoice() {
      // Implementation for generating invoice for service order
   }
}

// OrderFactory class
public class OrderFactory {
   public static Order createOrder(String type) {
      switch(type) {
         case "Physical":
            return new PhysicalOrder();
         case "Digital":
            return new DigitalOrder();
         case "Service":
            return new ServiceOrder();
         default:
            throw new IllegalArgumentException("Invalid order type: " + type);
      }
   }
}

// Client code that uses the factory to create orders and generate invoices
public class Client {
   public static void main(String[] args) {
      Order physicalOrder = OrderFactory.createOrder("Physical");
      physicalOrder.generateInvoice();

      Order digitalOrder = OrderFactory.createOrder("Digital");
      digitalOrder.generateInvoice();

      Order serviceOrder = OrderFactory.createOrder("Service");
      serviceOrder.generateInvoice();
   }
}
```

### Diagram

```mermaid
classDiagram
    class Order {
        <<abstract>>
        +generateInvoice()*
    }

    class PhysicalOrder {
        +generateInvoice()
    }

    class DigitalOrder {
        +generateInvoice()
    }

    class ServiceOrder {
        +generateInvoice()
    }

    class OrderFactory {
        +createOrder(String type) Order
    }

    class Client {
        +main(String[] args)
    }

    Order <|-- PhysicalOrder
    Order <|-- DigitalOrder
    Order <|-- ServiceOrder

    OrderFactory ..> Order : creates
    Client ..> OrderFactory : uses
    Client ..> Order : uses
```

### Sequence Diagram
```mermaid
sequenceDiagram
    participant Client
    participant OrderFactory
    participant PhysicalOrder
    participant DigitalOrder
    participant ServiceOrder

    %% Physical Order Flow
    Client->>+OrderFactory: createOrder("Physical")
    OrderFactory->>+PhysicalOrder: new()
    PhysicalOrder-->>-OrderFactory: instance
    OrderFactory-->>-Client: PhysicalOrder
    Client->>+PhysicalOrder: generateInvoice()
    PhysicalOrder-->>-Client: invoice generated

    %% Digital Order Flow
    Client->>+OrderFactory: createOrder("Digital")
    OrderFactory->>+DigitalOrder: new()
    DigitalOrder-->>-OrderFactory: instance
    OrderFactory-->>-Client: DigitalOrder
    Client->>+DigitalOrder: generateInvoice()
    DigitalOrder-->>-Client: invoice generated

    %% Service Order Flow
    Client->>+OrderFactory: createOrder("Service")
    OrderFactory->>+ServiceOrder: new()
    ServiceOrder-->>-OrderFactory: instance
    OrderFactory-->>-Client: ServiceOrder
    Client->>+ServiceOrder: generateInvoice()
    ServiceOrder-->>-Client: invoice generated
```


---
## Factory Method Design Pattern:

Suppose we have a game where players can choose different types of characters to play with, such as a warrior, a mage, or a rogue. Each character has its own set of attributes and abilities. We want to create these characters dynamically at runtime using a factory method pattern

```java
//First, we define an abstract Character class that has some common methods for all types of characters:

public abstract class Character {
    protected String name;
    protected int health;
    protected int strength;
    protected int agility;
    protected int intelligence;

    public Character(String name, int health, int strength, int agility, int intelligence) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void display();
    public abstract void attack();
}
//We also define some concrete Character subclasses that represent the different types of characters:
public class Warrior extends Character {
    public Warrior(String name, int health, int strength, int agility, int intelligence) {
        super(name, health, strength, agility, intelligence);
    }

    @Override
    public void display() {
        System.out.println("I am a warrior named " + name + ".");
    }

    @Override
    public void attack() {
        System.out.println("I swing my sword!");
    }
}

public class Mage extends Character {
    public Mage(String name, int health, int strength, int agility, int intelligence) {
        super(name, health, strength, agility, intelligence);
    }

    @Override
    public void display() {
        System.out.println("I am a mage named " + name + ".");
    }

    @Override
    public void attack() {
        System.out.println("I cast a spell!");
    }
}

public class Rogue extends Character {
    public Rogue(String name, int health, int strength, int agility, int intelligence) {
        super(name, health, strength, agility, intelligence);
    }

    @Override
    public void display() {
        System.out.println("I am a rogue named " + name + ".");
    }

    @Override
    public void attack() {
        System.out.println("I strike from the shadows!");
    }
}

//Next, we define a CharacterFactory interface that has a createCharacter method that returns a Character object. We can then create concrete factories that implement this interface to create specific types of characters:
public interface CharacterFactory {
    public Character createCharacter(String name);
}

public class WarriorFactory implements CharacterFactory {
    public Character createCharacter(String name) {
        return new Warrior(name, 100, 10, 5, 5);
    }
}

public class MageFactory implements CharacterFactory {
    public Character createCharacter(String name) {
        return new Mage(name, 50, 5, 5, 10);
    }
}

public class RogueFactory implements CharacterFactory {
    public Character createCharacter(String name) {
        return new Rogue(name, 75, 7, 10, 3);
    }
}

//Finally, we can use the factory method pattern to dynamically create characters in our game:
public class Game {
    public static void main(String[] args) {
        CharacterFactory warriorFactory = new WarriorFactory();
        CharacterFactory mageFactory = new MageFactory();
        CharacterFactory rogueFactory = new RogueFactory();

        Character warrior = warriorFactory.createCharacter("Thor");
        Character mage = mageFactory.createCharacter("Gandalf");
        Character rogue = rogueFactory.createCharacter("Legolas");

        warrior.display();
        warrior.attack();

        mage.display();
        mage.attack();

        rogue.display();
        rogue.attack();
    }
}

```
### Diagram
```mermaid
classDiagram
    class Character {
        <<abstract>>
        -String name
        -int health
        -int strength
        -int agility
        -int intelligence
        +Character(name, health, strength, agility, intelligence)
        +display()*
        +attack()*
    }

    class Warrior {
        +Warrior(name, health, strength, agility, intelligence)
        +display()
        +attack()
    }

    class Mage {
        +Mage(name, health, strength, agility, intelligence)
        +display()
        +attack()
    }

    class Rogue {
        +Rogue(name, health, strength, agility, intelligence)
        +display()
        +attack()
    }

    class CharacterFactory {
        <<interface>>
        +createCharacter(name)*
    }

    class WarriorFactory {
        +createCharacter(name)
    }

    class MageFactory {
        +createCharacter(name)
    }

    class RogueFactory {
        +createCharacter(name)
    }

    class Game {
        +main(args)
    }

    Character <|-- Warrior
    Character <|-- Mage
    Character <|-- Rogue

    CharacterFactory <|.. WarriorFactory
    CharacterFactory <|.. MageFactory
    CharacterFactory <|.. RogueFactory

    WarriorFactory --> Warrior : creates
    MageFactory --> Mage : creates
    RogueFactory --> Rogue : creates

    Game ..> CharacterFactory : uses
    Game ..> Character : uses
```


#### Difference between Simple Factory & Factory Method:

Simple Factory pattern encapsulates the object creation logic in a single factory class, which takes in a parameter and creates the desired object based on that parameter. In other words, the client only interacts with the factory class to get the object it needs.

On the other hand, Factory Method pattern delegates the object creation to the subclasses by defining an abstract method in the creator class. Each subclass implements this method to create the specific object it is responsible for. The client interacts with the creator class and each subclass is responsible for creating its own objects.

So, in short, the key difference is in how the objects are created. In Simple Factory, the factory class creates the objects, while in Factory Method, the subclasses are responsible for creating the objects.

#### Here is a simplified example to illustrate the difference between the two:

Suppose we have a Vehicle interface and two concrete classes, Car and Bike, that implement the interface.
In Simple Factory, we would have a VehicleFactory class that takes a parameter and returns the appropriate object:

```java
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
```

The client would use this factory class to create the object it needs, like this:

```java
Vehicle car = VehicleFactory.createVehicle("car");
```

In Factory Method, we would define an abstract VehicleFactory class with an abstract method **createVehicle()**:

```java
public abstract class VehicleFactory {
    public abstract Vehicle createVehicle();
}
```

Then, we would have two concrete subclasses, CarFactory and BikeFactory, that extend the VehicleFactory class and implement the **createVehicle()** method:

```java
public class CarFactory extends VehicleFactory {
    public Vehicle createVehicle() {
        return new Car();
    }
}

public class BikeFactory extends VehicleFactory {
    public Vehicle createVehicle() {
        return new Bike();
    }
}
```

The client would interact with the creator class, like this:

```java
VehicleFactory factory = new CarFactory();
Vehicle car = factory.createVehicle();
```

#### Abstract Factory Design Patterns:

The `Abstract Factory pattern` is used when we want to create families of related objects without specifying their concrete classes. It provides an interface for creating families of related objects, without specifying their concrete classes. The key idea behind the Abstract Factory pattern is to provide an abstract factory interface (or class) that defines a set of factory methods, one for each product type that can be produced. Each concrete factory class that implements the abstract factory interface is responsible for creating a family of related products.

##### Example 1:

Let's take an example of a car manufacturing company. The company produces two types of cars - luxury cars and sports cars. Each car type has its own set of related objects such as engine, wheels, and seats.

To implement the Abstract Factory pattern, we can create an abstract factory interface called CarFactory that defines a set of factory methods for creating these related objects. The CarFactory interface will have two concrete implementations - LuxuryCarFactory and SportsCarFactory - which will create the related objects for luxury and sports cars respectively.

##### Here's the code example:

```java
// Abstract Factory interface
public interface CarFactory {
   public Engine createEngine();
   public Wheels createWheels();
   public Seats createSeats();
}

// Concrete factory for luxury cars
public class LuxuryCarFactory implements CarFactory {
   public Engine createEngine() {
      return new LuxuryEngine();
   }
   public Wheels createWheels() {
      return new LuxuryWheels();
   }
   public Seats createSeats() {
      return new LuxurySeats();
   }
}

// Concrete factory for sports cars
public class SportsCarFactory implements CarFactory {
   public Engine createEngine() {
      return new SportsEngine();
   }
   public Wheels createWheels() {
      return new SportsWheels();
   }
   public Seats createSeats() {
      return new SportsSeats();
   }
}

// Abstract Product interface for Engine
public interface Engine {
   public void design();
}

// Concrete Product for Luxury Engine
public class LuxuryEngine implements Engine {
   public void design() {
      System.out.println("Designing Luxury Engine");
   }
}

// Concrete Product for Sports Engine
public class SportsEngine implements Engine {
   public void design() {
      System.out.println("Designing Sports Engine");
   }
}

// Abstract Product interface for Wheels
public interface Wheels {
   public void design();
}

// Concrete Product for Luxury Wheels
public class LuxuryWheels implements Wheels {
   public void design() {
      System.out.println("Designing Luxury Wheels");
   }
}

// Concrete Product for Sports Wheels
public class SportsWheels implements Wheels {
   public void design() {
      System.out.println("Designing Sports Wheels");
   }
}

// Abstract Product interface for Seats
public interface Seats {
   public void design();
}

// Concrete Product for Luxury Seats
public class LuxurySeats implements Seats {
   public void design() {
      System.out.println("Designing Luxury Seats");
   }
}

// Concrete Product for Sports Seats
public class SportsSeats implements Seats {
   public void design() {
      System.out.println("Designing Sports Seats");
   }
}

// Client code that uses the abstract factory to create related objects
//It holds references to the car components created by the factory, namely Engine, Wheels, and Seats.
public class Car {
   private Engine engine;
   private Wheels wheels;
   private Seats seats;
//The constructor accepts a CarFactory as a parameter. 
// It uses this factory to create the specific components for the car. 
// This allows the Car class to be flexible and work with any type of car factory (luxury or sports) without needing to know the specifics of how these components are created.
   
   public Car(CarFactory factory) {
      engine = factory.createEngine();
      wheels = factory.createWheels();
      seats = factory.createSeats();
   }
   
   //The design() method calls the design() method of each component (engine, wheels, and seats). 
   // This method orchestrates the behavior of the individual components, demonstrating how they work together to create a car.
   public void design() {
      engine.design();
      wheels.design();
      seats.design();
   }
}

// Example usage
public class Main {
   public static void main(String[] args) {
      CarFactory factory = new LuxuryCarFactory();
      Car luxuryCar = new Car(factory);
      luxuryCar.design();

      factory = new SportsCarFactory();
      Car sportsCar = new Car(factory);
      sportsCar.design();
   }
}

/*
In summary, the Car class acts as a composite object that encapsulates the car's components, allowing for a clean and flexible way to create and design different types of cars based on the factory provided. 
It promotes the use of the Abstract Factory design pattern by decoupling the car's creation logic from the specific implementations of its components.        
 */
```

### Diagram
```mermaid
classDiagram
    %% Abstract Factory and Concrete Factories
    class CarFactory {
        <<interface>>
        +createEngine() Engine
        +createWheels() Wheels
        +createSeats() Seats
    }

    class LuxuryCarFactory {
        +createEngine() Engine
        +createWheels() Wheels
        +createSeats() Seats
    }

    class SportsCarFactory {
        +createEngine() Engine
        +createWheels() Wheels
        +createSeats() Seats
    }

    %% Abstract Products and Concrete Products
    class Engine {
        <<interface>>
        +design()*
    }

    class LuxuryEngine {
        +design()
    }

    class SportsEngine {
        +design()
    }

    class Wheels {
        <<interface>>
        +design()*
    }

    class LuxuryWheels {
        +design()
    }

    class SportsWheels {
        +design()
    }

    class Seats {
        <<interface>>
        +design()*
    }

    class LuxurySeats {
        +design()
    }

    class SportsSeats {
        +design()
    }

    %% Client Classes
    class Car {
        -engine: Engine
        -wheels: Wheels
        -seats: Seats
        +Car(factory: CarFactory)
        +design()
    }

    class Main {
        +main(args)
    }

    %% Relationships
    CarFactory <|.. LuxuryCarFactory
    CarFactory <|.. SportsCarFactory

    LuxuryCarFactory --> LuxuryEngine : creates
    LuxuryCarFactory --> LuxuryWheels : creates
    LuxuryCarFactory --> LuxurySeats : creates

    SportsCarFactory --> SportsEngine : creates
    SportsCarFactory --> SportsWheels : creates
    SportsCarFactory --> SportsSeats : creates

    Engine <|-- LuxuryEngine
    Engine <|-- SportsEngine
    Wheels <|-- LuxuryWheels
    Wheels <|-- SportsWheels
    Seats <|-- LuxurySeats
    Seats <|-- SportsSeats

    Car o--> Engine
    Car o--> Wheels
    Car o--> Seats
    Car ..> CarFactory : depends on

    Main ..> CarFactory : uses
    Main ..> Car : uses
```

### Sequence Diagram
```mermaid
sequenceDiagram
    participant Main
    participant CarFactory
    participant LuxuryCarFactory
    participant SportsCarFactory
    participant Car
    participant Engine
    participant Wheels
    participant Seats

    %% Luxury Car Creation
    Main->>+LuxuryCarFactory: new()
    Main->>+Car: new(LuxuryCarFactory)
    Car->>+LuxuryCarFactory: createEngine()
    LuxuryCarFactory-->>-Car: LuxuryEngine
    Car->>+LuxuryCarFactory: createWheels()
    LuxuryCarFactory-->>-Car: LuxuryWheels
    Car->>+LuxuryCarFactory: createSeats()
    LuxuryCarFactory-->>-Car: LuxurySeats
    Main->>+Car: design()
    Car->>+LuxuryEngine: design()
    LuxuryEngine-->>-Car: "Designing Luxury Engine"
    Car->>+LuxuryWheels: design()
    LuxuryWheels-->>-Car: "Designing Luxury Wheels"
    Car->>+LuxurySeats: design()
    LuxurySeats-->>-Car: "Designing Luxury Seats"
    Car-->>-Main: Luxury car designed

    %% Sports Car Creation
    Main->>+SportsCarFactory: new()
    Main->>+Car: new(SportsCarFactory)
    Car->>+SportsCarFactory: createEngine()
    SportsCarFactory-->>-Car: SportsEngine
    Car->>+SportsCarFactory: createWheels()
    SportsCarFactory-->>-Car: SportsWheels
    Car->>+SportsCarFactory: createSeats()
    SportsCarFactory-->>-Car: SportsSeats
    Main->>+Car: design()
    Car->>+SportsEngine: design()
    SportsEngine-->>-Car: "Designing Sports Engine"
    Car->>+SportsWheels: design()
    SportsWheels-->>-Car: "Designing Sports Wheels"
    Car->>+SportsSeats: design()
    SportsSeats-->>-Car: "Designing Sports Seats"
    Car-->>-Main: Sports car designed
```


Here’s a categorized breakdown of the classes in your Abstract Factory pattern implementation for car creation:

**Creator Class**
 - **CarFactory**: Interface defining methods for creating car components (Engine, Wheels, Seats).
**Concrete Creator Classes**
 - **LuxuryCarFactory**: Concrete implementation of CarFactory for creating luxury car components.
- **SportsCarFactory**: Concrete implementation of CarFactory for creating sports car components.

**Product Interfaces**
 - **Engine**: Interface for engine products.
 - **Wheels**: Interface for wheels products.
 - **Seats**: Interface for seats products.

**Concrete Product Classes**
- **LuxuryEngine**: Concrete implementation of Engine for luxury cars.

- **SportsEngine**: Concrete implementation of Engine for sports cars.

- **LuxuryWheels**: Concrete implementation of Wheels for luxury cars.

- **SportsWheels**: Concrete implementation of Wheels for sports cars.

- **LuxurySeats**: Concrete implementation of Seats for luxury cars.

- **SportsSeats**: Concrete implementation of Seats for sports cars.

**Client Class**
- **Car**: Class that uses the CarFactory to create and design car components.
- **Main**: Example client code that creates luxury and sports cars using the corresponding factories.

This categorization clarifies the roles of each class in the Abstract Factory design pattern for car manufacturing.

In this example, we have an abstract factory interface called CarFactory with three factory methods to create related objects - Engine, Wheels, and Seats. We also have two concrete implementations of the CarFactory interface - LuxuryCarFactory and SportsCarFactory, which create related objects for luxury and sports cars respectively.

We also have abstract product interfaces for Engine, Wheels, and Seats, with concrete product implementations for luxury and sports cars.

The client code uses the abstract factory to create a car by passing in a factory instance, which creates the related objects for the specific car type. The Car class then uses these objects to perform operations such as designing the car.

In the main method, we create a luxury car using the LuxuryCarFactory and a sports car using the SportsCarFactory, demonstrating how the abstract factory pattern can be used to create related objects for different car types.

#### Example 2:

Let's say we have a `GUI (Graphical com.manish.LLD.PropertyPlatformLLD.Type1.User Interface)` library that can render GUI components such as `buttons`, `text boxes`, and `labels`. We want to support multiple platforms such as `Windows`, `macOS`, and `Linux`, and we want to ensure that the GUI components are consistent across platforms.

To implement the Abstract Factory pattern, we can create an abstract factory interface called GUIFactory that defines a set of factory methods for creating GUI components. The `GUIFactory` interface will have three concrete implementations - `WindowsGUIFactory`, `MacOSGUIFactory`, and `LinuxGUIFactory` - which will create the GUI components for Windows, macOS, and Linux respectively.

```java
// Abstract Factory interface for creating GUI components
public interface GUIFactory {
    public Button createButton();
    public TextBox createTextBox();
    public Label createLabel();
}

// Concrete factory for creating GUI components for Windows platform
public class WindowsGUIFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
    public TextBox createTextBox() {
        return new WindowsTextBox();
    }
    public Label createLabel() {
        return new WindowsLabel();
    }
}

// Concrete factory for creating GUI components for macOS platform
public class MacOSGUIFactory implements GUIFactory {
    public Button createButton() {
        return new MacOSButton();
    }
    public TextBox createTextBox() {
        return new MacOSTextBox();
    }
    public Label createLabel() {
        return new MacOSLabel();
    }
}

// Concrete factory for creating GUI components for Linux platform
public class LinuxGUIFactory implements GUIFactory {
    public Button createButton() {
        return new LinuxButton();
    }
    public TextBox createTextBox() {
        return new LinuxTextBox();
    }
    public Label createLabel() {
        return new LinuxLabel();
    }
}

// Abstract Product interface for Button
public interface Button {
    public void paint();
}

// Concrete Product for Windows Button
public class WindowsButton implements Button {
    public void paint() {
        System.out.println("Painting a Windows button.");
    }
}

// Concrete Product for macOS Button
public class MacOSButton implements Button {
    public void paint() {
        System.out.println("Painting a macOS button.");
    }
}

// Concrete Product for Linux Button
public class LinuxButton implements Button {
    public void paint() {
        System.out.println("Painting a Linux button.");
    }
}

// Abstract Product interface for TextBox
public interface TextBox {
    public void paint();
}

// Concrete Product for Windows TextBox
public class WindowsTextBox implements TextBox {
    public void paint() {
        System.out.println("Painting a Windows text box.");
    }
}

// Concrete Product for macOS TextBox
public class MacOSTextBox implements TextBox {
    public void paint() {
        System.out.println("Painting a macOS text box.");
    }
}

// Concrete Product for Linux TextBox
public class LinuxTextBox implements TextBox {
    public void paint() {
        System.out.println("Painting a Linux text box.");
    }
}

// Abstract Product interface for Label
public interface Label {
    public void paint();
}

// Concrete Product for Windows Label
public class WindowsLabel implements Label {
    public void paint() {
        System.out.println("Painting a Windows label.");
    }
}

// Concrete Product for macOS Label
public class MacOSLabel implements Label {
    public void paint() {
        System.out.println("Painting a macOS label.");
    }
}

// Concrete Product for Linux Label
public class LinuxLabel implements Label {
    public void paint() {
        System.out.println("Painting a Linux label.");
    }
}

// Client code that uses the abstract factory to create related objects
public class Application {
    private Button button;
    private TextBox textBox;
    private Label label;
    public Application(GUIFactory factory) {
        button = factory.createButton();
        textBox = factory.createTextBox();
        label = factory.createLabel();
    }

    public void paint() {
        button.paint();
        textBox.paint();
        label.paint();
    }
}

// Sample client code that creates an Application for Windows
public class WindowsClient {
    public static void main(String[] args) {
        GUIFactory factory = new WindowsGUIFactory();
        Application app = new Application(factory);
        app.paint();
    }
}

// Sample client code that creates an Application for macOS
public class MacOSClient {
    public static void main(String[] args) {
        GUIFactory factory = new MacOSGUIFactory();
        Application app = new Application(factory);
        app.paint();
    }
}

// Sample client code that creates an Application for Linux
public class LinuxClient {
    public static void main(String[] args) {
        GUIFactory factory = new LinuxGUIFactory();
        Application app = new Application(factory);
        app.paint();
    }
}
```
### Diagram

```mermaid
classDiagram
    %% Abstract Factory and Concrete Factories
    class GUIFactory {
        <<interface>>
        +createButton() Button
        +createTextBox() TextBox
        +createLabel() Label
    }

    class WindowsGUIFactory {
        +createButton() Button
        +createTextBox() TextBox
        +createLabel() Label
    }

    class MacOSGUIFactory {
        +createButton() Button
        +createTextBox() TextBox
        +createLabel() Label
    }

    class LinuxGUIFactory {
        +createButton() Button
        +createTextBox() TextBox
        +createLabel() Label
    }

    %% Abstract Products and Concrete Products
    class Button {
        <<interface>>
        +paint()*
    }

    class WindowsButton {
        +paint()
    }

    class MacOSButton {
        +paint()
    }

    class LinuxButton {
        +paint()
    }

    class TextBox {
        <<interface>>
        +paint()*
    }

    class WindowsTextBox {
        +paint()
    }

    class MacOSTextBox {
        +paint()
    }

    class LinuxTextBox {
        +paint()
    }

    class Label {
        <<interface>>
        +paint()*
    }

    class WindowsLabel {
        +paint()
    }

    class MacOSLabel {
        +paint()
    }

    class LinuxLabel {
        +paint()
    }

    %% Client Classes
    class Application {
        -button: Button
        -textBox: TextBox
        -label: Label
        +Application(factory: GUIFactory)
        +paint()
    }

    class WindowsClient {
        +main(args)
    }

    class MacOSClient {
        +main(args)
    }

    class LinuxClient {
        +main(args)
    }

    %% Relationships
    GUIFactory <|.. WindowsGUIFactory
    GUIFactory <|.. MacOSGUIFactory
    GUIFactory <|.. LinuxGUIFactory

    WindowsGUIFactory --> WindowsButton : creates
    WindowsGUIFactory --> WindowsTextBox : creates
    WindowsGUIFactory --> WindowsLabel : creates

    MacOSGUIFactory --> MacOSButton : creates
    MacOSGUIFactory --> MacOSTextBox : creates
    MacOSGUIFactory --> MacOSLabel : creates

    LinuxGUIFactory --> LinuxButton : creates
    LinuxGUIFactory --> LinuxTextBox : creates
    LinuxGUIFactory --> LinuxLabel : creates

    Button <|-- WindowsButton
    Button <|-- MacOSButton
    Button <|-- LinuxButton

    TextBox <|-- WindowsTextBox
    TextBox <|-- MacOSTextBox
    TextBox <|-- LinuxTextBox

    Label <|-- WindowsLabel
    Label <|-- MacOSLabel
    Label <|-- LinuxLabel

    Application o--> Button
    Application o--> TextBox
    Application o--> Label
    Application ..> GUIFactory : depends on

    WindowsClient ..> WindowsGUIFactory : uses
    WindowsClient ..> Application : uses

    MacOSClient ..> MacOSGUIFactory : uses
    MacOSClient ..> Application : uses

    LinuxClient ..> LinuxGUIFactory : uses
    LinuxClient ..> Application : uses
```

### Sequence Diagram

```mermaid
sequenceDiagram
    participant Main
    participant GUIFactory
    participant WindowsGUIFactory
    participant MacOSGUIFactory
    participant LinuxGUIFactory
    participant Application
    participant Button
    participant TextBox
    participant Label

    %% Windows GUI Flow
    Main->>+WindowsGUIFactory: new()
    Main->>+Application: new(WindowsGUIFactory)
    Application->>+WindowsGUIFactory: createButton()
    WindowsGUIFactory-->>-Application: WindowsButton
    Application->>+WindowsGUIFactory: createTextBox()
    WindowsGUIFactory-->>-Application: WindowsTextBox
    Application->>+WindowsGUIFactory: createLabel()
    WindowsGUIFactory-->>-Application: WindowsLabel
    Main->>+Application: paint()
    Application->>+WindowsButton: paint()
    WindowsButton-->>-Application: "Painting Windows button"
    Application->>+WindowsTextBox: paint()
    WindowsTextBox-->>-Application: "Painting Windows text box"
    Application->>+WindowsLabel: paint()
    WindowsLabel-->>-Application: "Painting Windows label"
    Application-->>-Main: Windows GUI rendered

    %% macOS GUI Flow
    Main->>+MacOSGUIFactory: new()
    Main->>+Application: new(MacOSGUIFactory)
    Application->>+MacOSGUIFactory: createButton()
    MacOSGUIFactory-->>-Application: MacOSButton
    Application->>+MacOSGUIFactory: createTextBox()
    MacOSGUIFactory-->>-Application: MacOSTextBox
    Application->>+MacOSGUIFactory: createLabel()
    MacOSGUIFactory-->>-Application: MacOSLabel
    Main->>+Application: paint()
    Application->>+MacOSButton: paint()
    MacOSButton-->>-Application: "Painting macOS button"
    Application->>+MacOSTextBox: paint()
    MacOSTextBox-->>-Application: "Painting macOS text box"
    Application->>+MacOSLabel: paint()
    MacOSLabel-->>-Application: "Painting macOS label"
    Application-->>-Main: macOS GUI rendered

    %% Linux GUI Flow
    Main->>+LinuxGUIFactory: new()
    Main->>+Application: new(LinuxGUIFactory)
    Application->>+LinuxGUIFactory: createButton()
    LinuxGUIFactory-->>-Application: LinuxButton
    Application->>+LinuxGUIFactory: createTextBox()
    LinuxGUIFactory-->>-Application: LinuxTextBox
    Application->>+LinuxGUIFactory: createLabel()
    LinuxGUIFactory-->>-Application: LinuxLabel
    Main->>+Application: paint()
    Application->>+LinuxButton: paint()
    LinuxButton-->>-Application: "Painting Linux button"
    Application->>+LinuxTextBox: paint()
    LinuxTextBox-->>-Application: "Painting Linux text box"
    Application->>+LinuxLabel: paint()
    LinuxLabel-->>-Application: "Painting Linux label"
    Application-->>-Main: Linux GUI rendered
```

Here’s a categorized breakdown of the classes in your Abstract Factory pattern implementation:

**Creator Class**
 - **GUIFactory**: Interface defining methods for creating GUI components.

**Concrete Creator Classes**
- **WindowsGUIFactory**: Concrete implementation of GUIFactory for creating Windows components.
- **MacOSGUIFactory**: Concrete implementation of GUIFactory for creating macOS components.
- **LinuxGUIFactory**: Concrete implementation of GUIFactory for creating Linux components.

**Product Interfaces**
- **Button**: Interface for button products.
- **TextBox**: Interface for text box products.
- **Label**: Interface for label products.

**Concrete Product Classes**
**Windows**
- **WindowsButton**: Concrete implementation of Button for Windows.
- **WindowsTextBox**: Concrete implementation of TextBox for Windows.
- **WindowsLabel**: Concrete implementation of Label for Windows.

**Linux**
- **LinuxButton**: Concrete implementation of Button for Linux.
- **LinuxTextBox**: Concrete implementation of TextBox for Linux.
- **LinuxLabel**: Concrete implementation of Label for Linux.

**MacOS**
- **MacOSButton**: Concrete implementation of Button for macOS.
- **MacOSTextBox**: Concrete implementation of TextBox for macOS.
- **MacOSLabel**: Concrete implementation of Label for macOS.

**Client Classes**
- **Application**: Class that uses the GUIFactory to create and paint GUI components.
- **WindowsClient**: Sample client code for creating a Windows application.
- **MacOSClient**: Sample client code for creating a macOS application.
- **LinuxClient**: Sample client code for creating a Linux application.
This categorization helps clarify the roles of each class in the Abstract Factory design pattern implementation.


In this code, we define an abstract factory interface `GUIFactory` that declares methods for creating different types of GUI components such as buttons, text boxes, and labels. Then we define three concrete factories `WindowsGUIFactory`, `MacOSGUIFactory`, and `LinuxGUIFactory` that implement the GUIFactory interface to create GUI components specific to the Windows, macOS, and Linux platforms respectively.

We also define three concrete product classes for each of the GUI components: `WindowsButton`, `WindowsTextBox`, `WindowsLabel` for Windows; `MacOSButton`, `MacOSTextBox`, `MacOSLabel` for macOS; and `LinuxButton`, `LinuxTextBox`, LinuxLabel for Linux. Each of these classes implements the corresponding abstract product interface.

Finally, we define an Application class that takes a concrete factory as a parameter and uses it to create GUI components for the application. We also define three client classes `WindowsClient`, `MacOSClient`, and `LinuxClient` that create an Application object with the appropriate concrete factory based on the platform they are running on. When the `paint()` method is called on the Application object, it calls the `paint()` method on each of the GUI components, which in turn prints out a message indicating which type of component is being painted.

# Builder Design Pattern:

- The Builder pattern is a design pattern that allows you to create complex objects step by step. It provides a way to create different variations of an object while using the same construction code.
- In simpler words, imagine that you want to build a house. You can use different builders for different parts of the house, such as a plumber to handle the pipes and a carpenter to build the doors. However, you need someone to coordinate all of the builders to create the final house. The Builder pattern provides this coordination.
- In software development, you might want to create an object that has many different attributes. Instead of having one constructor that takes all the attributes as arguments, the Builder pattern allows you to create a separate builder class that sets each attribute separately. This makes the object creation more flexible and easier to understand.

## Key Components
- **Builder**: This is an interface or an abstract class that defines the steps required to construct a product.
- **Concrete Builders**: These are classes that implement the Builder interface and provide specific implementations for constructing the product.
- **Product**: This is the complex object that is being constructed.
- **Director (optional)**: This is an optional class that oversees the construction process and coordinates the builders to construct the final product.


#### Example 1:
```java
public class Car {
    private String make;
    private String model;
    private int year;
    private String color;

    private Car(String make, String model, int year, String color) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                '}';
    }

    public static class CarBuilder {
        private String make;
        private String model;
        private int year;
        private String color;

        public CarBuilder() {
        }

        public CarBuilder setMake(String make) {
            this.make = make;
            return this;
        }

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(make, model, year, color);
        }
    }
}
```

In this example, the Car class represents the object that we want to create. We have a separate `Car.CarBuilder class`, which sets each attribute of the Car object separately, and then constructs the final Car object using the Car.CarBuilder.build() method.

Here's an example of how we can use the Builder pattern to create a Car object:

```java
Car car = new Car.CarBuilder()
                .setMake("Toyota")
                .setModel("Camry")
                .setYear(2021)
                .setColor("Red")
                .build();
System.out.println(car);
```

In this example, we use the Car. `CarBuilder` class to create a Car object with a make of Toyota, model of Camry, the year of 2021, and color of Red. The `Car.CarBuilder.build()` method constructs the final Car object, which we then print to the console.

### Example 2:

Suppose you are developing an e-commerce application that allows users to place orders for products. You want to create an Order object that contains information about the products that were ordered, the billing and shipping addresses, and other optional details such as discounts and taxes.
Using the Builder pattern, you can create a `OrderBuilder` class that allows you to set each of these parameters separately, and then construct the final Order object using the build() method. Here's an example of how this might look in Java:

```java

import java.util.ArrayList;
import java.util.List;

// Product Class: This is the complex object that is being constructed.
// It contains various fields, such as products, billing address, shipping address, discount, and tax.
public class Order {
    private List<Product> products;         // List of products in the order
    private Address billingAddress;         // Billing address for the order
    private Address shippingAddress;        // Shipping address for the order
    private double discount;                // Discount applied to the order
    private double tax;                     // Tax applied to the order

    // Private constructor for creating an Order object using the Builder.
    // This enforces the use of the Builder to create an Order.
    private Order(List<Product> products, Address billingAddress, Address shippingAddress,
                  double discount, double tax) {
        this.products = products;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.discount = discount;
        this.tax = tax;
    }

    // Getters for accessing the private fields of the order.
    public List<Product> getProducts() {
        return products;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTax() {
        return tax;
    }

    // Builder Class: This nested static class helps to construct an Order object step by step.
    // It has methods for setting each property of the Order.
    public static class OrderBuilder {
        private List<Product> products;
        private Address billingAddress;
        private Address shippingAddress;
        private double discount;
        private double tax;

        // Constructor initializes default values for the order fields.
        public OrderBuilder() {
            products = new ArrayList<>();
            discount = 0.0;
            tax = 0.0;
        }

        // Method to add a product to the order.
        public OrderBuilder addProduct(Product product) {
            products.add(product);
            return this;
        }

        // Method to set the billing address for the order.
        public OrderBuilder setBillingAddress(Address billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }

        // Method to set the shipping address for the order.
        public OrderBuilder setShippingAddress(Address shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        // Method to apply a discount to the order.
        public OrderBuilder setDiscount(double discount) {
            this.discount = discount;
            return this;
        }

        // Method to apply tax to the order.
        public OrderBuilder setTax(double tax) {
            this.tax = tax;
            return this;
        }

        // Method to build the final Order object after all steps have been performed.
        public Order build() {
            return new Order(products, billingAddress, shippingAddress, discount, tax);
        }
    }
}

// Product Class: Represents the items being added to the order.
// Each product has a name and price.
public class Product {
    private String name;
    private double price;

    // Constructor to initialize a product with its name and price.
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters and setters for accessing and modifying product properties.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

// Address Class: Represents the address details such as street, city, state, and zip code.
// This is used for both billing and shipping addresses in the order.
public class Address {

    private String street;
    private String city;
    private String state;
    private String zipCode;

    // Constructor to initialize an address with its details.
    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // Getters and setters for accessing and modifying the address properties.
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // Create some products for the order.
        Product product1 = new Product("Laptop", 1500.0);
        Product product2 = new Product("Phone", 800.0);

        // Create billing and shipping addresses for the order.
        Address billingAddress = new Address("123 Main St", "New York", "NY", "10001");
        Address shippingAddress = new Address("456 Elm St", "Los Angeles", "CA", "90001");

        // Use the OrderBuilder to create an order by adding products and setting other details.
        Order order = new Order.OrderBuilder()
                .addProduct(product1)                          // Add first product
                .addProduct(product2)                          // Add second product
                .setBillingAddress(billingAddress)             // Set billing address
                .setShippingAddress(shippingAddress)           // Set shipping address
                .setDiscount(10.0)                             // Set discount
                .setTax(5.0)                                   // Set tax
                .build();                                      // Build the final order

        // Print the order details to the console.
        System.out.println("Order created with products: " + order.getProducts());
        System.out.println("Billing Address: " + order.getBillingAddress());
        System.out.println("Shipping Address: " + order.getShippingAddress());
        System.out.println("Discount: " + order.getDiscount());
        System.out.println("Tax: " + order.getTax());
    }
}

```

### Diagram
```mermaid
classDiagram
    class Order {
        -products: List~Product~
        -billingAddress: Address
        -shippingAddress: Address
        -discount: double
        -tax: double
        +getProducts() List~Product~
        +getBillingAddress() Address
        +getShippingAddress() Address
        +getDiscount() double
        +getTax() double
        +OrderBuilder: Builder
    }

    class OrderBuilder {
        -products: List~Product~
        -billingAddress: Address
        -shippingAddress: Address
        -discount: double
        -tax: double
        +OrderBuilder()
        +addProduct(Product) OrderBuilder
        +setBillingAddress(Address) OrderBuilder
        +setShippingAddress(Address) OrderBuilder
        +setDiscount(double) OrderBuilder
        +setTax(double) OrderBuilder
        +build() Order
    }

    class Product {
        -name: String
        -price: double
        +Product(String, double)
        +getName() String
        +setName(String)
        +getPrice() double
        +setPrice(double)
        +toString() String
    }

    class Address {
        -street: String
        -city: String
        -state: String
        -zipCode: String
        +Address(String, String, String, String)
        +getStreet() String
        +setStreet(String)
        +getCity() String
        +setCity(String)
        +getState() String
        +setState(String)
        +getZipCode() String
        +setZipCode(String)
        +toString() String
    }

    class Main {
        +main(String[])
    }

    Order ..> OrderBuilder : creates
    OrderBuilder --> Order : builds
    Order "1" *-- "*" Product : contains
    Order "1" --> "1" Address : billing
    Order "1" --> "1" Address : shipping
    Main ..> Product : uses
    Main ..> Address : uses
    Main ..> OrderBuilder : uses
```
### Sequence Diagram

```mermaid
sequenceDiagram
    participant Main
    participant OrderBuilder
    participant Order
    participant Product
    participant Address

    %% Product Creation
    Main->>+Product: new("Laptop", 1500.0)
    Main->>+Product: new("Phone", 800.0)
    
    %% Address Creation
    Main->>+Address: new("123 Main St", "NY", "NY", "10001")
    Main->>+Address: new("456 Elm St", "LA", "CA", "90001")
    
    %% Order Construction
    Main->>+OrderBuilder: new()
    OrderBuilder-->>-Main: builder instance
    
    %% Building Steps
    Main->>+OrderBuilder: addProduct(product1)
    OrderBuilder-->>-Main: return self
    Main->>+OrderBuilder: addProduct(product2)
    OrderBuilder-->>-Main: return self
    Main->>+OrderBuilder: setBillingAddress(billingAddress)
    OrderBuilder-->>-Main: return self
    Main->>+OrderBuilder: setShippingAddress(shippingAddress)
    OrderBuilder-->>-Main: return self
    Main->>+OrderBuilder: setDiscount(10.0)
    OrderBuilder-->>-Main: return self
    Main->>+OrderBuilder: setTax(5.0)
    OrderBuilder-->>-Main: return self
    
    %% Final Build
    Main->>+OrderBuilder: build()
    OrderBuilder->>+Order: new(products, addresses, discount, tax)
    Order-->>-OrderBuilder: order instance
    OrderBuilder-->>-Main: order instance
    
    %% Output Results
    Main->>+Order: getProducts()
    Order-->>-Main: products list
    Main->>+Order: getBillingAddress()
    Order-->>-Main: billing address
    Main->>+Order: getShippingAddress()
    Order-->>-Main: shipping address
    Main->>+Order: getDiscount()
    Order-->>-Main: discount value
    Main->>+Order: getTax()
    Order-->>-Main: tax value
```


### Key Components:

**1. Product Class:**
- Represents individual products with a name and price that are added to an order.

**2. Address Class:**
- Represents a customer's billing or shipping address with attributes like street, city, state, and zip code.

**3. Order Class (Product):**
- The complex object being constructed with fields for products, addresses, discount, and tax. It is immutable after construction since the constructor is private and only accessible via the `OrderBuilder`.

**4. OrderBuilder Class (Builder):**
- This class provides methods to add products, set addresses, and apply discounts/taxes. The `build()` method returns the final `Order` object.

**5. Main Class (Driver):**
- Demonstrates how to use the `OrderBuilder` to create an order by adding products, setting addresses, and applying discounts. Finally, it prints the order details.

**6. Director (Optional):**
- In this example, the director class is not explicitly used, but you could introduce a `SalesDirector` or similar class to manage the building of different types of orders.


In this example, the Order class represents the object that we want to create. We have a separate Order.OrderBuilder class that sets each attribute of the Order object separately, and then constructs the final Order object using the Order.OrderBuilder.build() method.
Here's an example of how we can use the Builder pattern to create an Order object:

```java
Order order = new Order.OrderBuilder()
    .addProduct(new Product("iPhone", 999.99))
    .addProduct(new Product("MacBook", 1999.99))
    .setBillingAddress(new Address("John Doe", "123 com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main St", "Anytown", "CA", "12345"))
    .setShippingAddress(new Address("Jane Doe", "456 Elm St", "Anytown", "CA", "12345"))
    .setDiscount(100.0)
    .setTax(89.0)
    .build();
```

In this example, we create an `OrderBuilder` object and use the `addProduct()`, `setBillingAddress()`, `setShippingAddress()`, `setDiscount()` and `setTax()` methods to set each attribute of the `Order` object separately. Finally, we call the `build()` method to create the final `Order` object.
Using the Builder pattern in this way makes it easy to create complex objects with many optional parameters. It also makes the code more readable and easier to understand, because each parameter is set separately using a descriptive method name.

### Example 3:

```java
import java.util.ArrayList;
import java.util.List;

// Product Class
public class Pizza {
    private String dough;
    private String sauce;
    private List<String> toppings;

    public Pizza() {
        this.toppings = new ArrayList<>();
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void addTopping(String topping) {
        this.toppings.add(topping);
    }

    // Getters for outputting pizza details
    public String getDough() {
        return dough;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getToppings() {
        return toppings;
    }
}

// Builder Interface
interface PizzaBuilder {
    void buildDough();
    void buildSauce();
    void buildToppings();
    Pizza getPizza();
}

// Concrete Builder for Hawaiian Pizza
class HawaiianPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public HawaiianPizzaBuilder() {
        this.pizza = new Pizza();
    }

    @Override
    public void buildDough() {
        pizza.setDough("Pan crust");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("Tomato sauce");
    }

    @Override
    public void buildToppings() {
        pizza.addTopping("Ham");
        pizza.addTopping("Pineapple");
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}

// Concrete Builder for Spicy Pizza (Example of another pizza type)
class SpicyPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public SpicyPizzaBuilder() {
        this.pizza = new Pizza();
    }

    @Override
    public void buildDough() {
        pizza.setDough("Thin crust");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("Hot sauce");
    }

    @Override
    public void buildToppings() {
        pizza.addTopping("Pepperoni");
        pizza.addTopping("Chili peppers");
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}

// Director (Optional, manages the building process)
class Chef {
    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }

    public void constructPizza() {
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildToppings();
    }
}

// Driver Class
public class Main {
    public static void main(String[] args) {
        // Create a director
        Chef chef = new Chef();

        // Create a specific builder (e.g., Hawaiian Pizza)
        PizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();

        // Set the builder for the director
        chef.setPizzaBuilder(hawaiianPizzaBuilder);

        // Construct the pizza
        chef.constructPizza();

        // Get the constructed pizza
        Pizza hawaiianPizza = chef.getPizza();

        // Output details of the Hawaiian pizza
        System.out.println("Hawaiian Pizza Details:");
        System.out.println("Dough: " + hawaiianPizza.getDough()); // Dough: Pan crust
        System.out.println("Sauce: " + hawaiianPizza.getSauce()); // Sauce: Tomato sauce
        System.out.println("Toppings: " + hawaiianPizza.getToppings()); // Toppings: [Ham, Pineapple]

        // Example of building another pizza (Spicy Pizza)
        PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();
        chef.setPizzaBuilder(spicyPizzaBuilder);
        chef.constructPizza();
        Pizza spicyPizza = chef.getPizza();

        // Output details of the Spicy pizza
        System.out.println("\nSpicy Pizza Details:");
        System.out.println("Dough: " + spicyPizza.getDough()); // Dough: Thin crust
        System.out.println("Sauce: " + spicyPizza.getSauce()); // Sauce: Hot sauce
        System.out.println("Toppings: " + spicyPizza.getToppings()); // Toppings: [Pepperoni, Chili peppers]
    }
}

```
### Diagram

```mermaid
classDiagram
    %% Pizza Product Class
    class Pizza {
        -dough: String
        -sauce: String
        -toppings: List~String~
        +Pizza()
        +setDough(String)
        +setSauce(String)
        +addTopping(String)
        +getDough() String
        +getSauce() String
        +getToppings() List~String~
    }

    %% Builder Interface
    class PizzaBuilder {
        <<interface>>
        +buildDough()*
        +buildSauce()*
        +buildToppings()*
        +getPizza() Pizza*
    }

    %% Concrete Builders
    class HawaiianPizzaBuilder {
        -pizza: Pizza
        +HawaiianPizzaBuilder()
        +buildDough()
        +buildSauce()
        +buildToppings()
        +getPizza() Pizza
    }

    class SpicyPizzaBuilder {
        -pizza: Pizza
        +SpicyPizzaBuilder()
        +buildDough()
        +buildSauce()
        +buildToppings()
        +getPizza() Pizza
    }

    %% Director Class
    class Chef {
        -pizzaBuilder: PizzaBuilder
        +setPizzaBuilder(PizzaBuilder)
        +getPizza() Pizza
        +constructPizza()
    }

    %% Client Class
    class Main {
        +main(String[])
    }

    %% Relationships
    PizzaBuilder <|.. HawaiianPizzaBuilder
    PizzaBuilder <|.. SpicyPizzaBuilder

    HawaiianPizzaBuilder --> Pizza : builds
    SpicyPizzaBuilder --> Pizza : builds

    Chef o--> PizzaBuilder : uses
    Chef ..> Pizza : returns

    Main ..> Chef : uses
    Main ..> HawaiianPizzaBuilder : uses
    Main ..> SpicyPizzaBuilder : uses
```



### Key Points:
**1. Pizza Class:**
- A simple product class representing a pizza. It has fields for dough, sauce, and toppings with setters and getters for manipulating and accessing its state.

**2. PizzaBuilder Interface:**
- Defines the steps for building a pizza (i.e., `buildDough`, `buildSauce`, `buildToppings` and `getPizza`).

**3. Concrete Builders:**
- `HawaiianPizzaBuilder`: Implements the `PizzaBuilder` interface to create a Hawaiian pizza with specific dough, sauce, and toppings.
- `SpicyPizzaBuilder`: Another example of a concrete builder for building a spicy pizza.

**4. Chef Class (Director):**
- The `Chef` class acts as a director that guides the building process. It uses a `PizzaBuilder` to construct pizzas by following the steps defined in the builder.

**5. Main Class:**
- Demonstrates how to use the builder pattern to construct different types of pizzas by setting specific builders (e.g., Hawaiian or Spicy), using the director to assemble them, and then retrieving and printing the pizza details.

This approach ensures flexibility, as you can easily create different types of pizzas by implementing new concrete builders without modifying the core logic.

#### Commonly used in scenarios:

The Builder design pattern is commonly used in scenarios where the creation of an object involves a large number of optional parameters, or when you want to create objects in a step-by-step fashion. Here are some scenarios where you might want to use the Builder pattern:

1. ##### Creating immutable objects:

   In some cases, it's desirable to create objects that can't be modified once they're created. The Builder pattern is well-suited to this, because it allows you to construct an object piece by piece, and then create an immutable version of that object.

```java
   public class Employee {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String department;

    public static class Builder {
        private final String firstName;
        private final String lastName;
        private int age;
        private String department;

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

    private Employee(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        age = builder.age;
        department = builder.department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }
   }
```

In this example, we define an Employee class with four final fields: firstName, lastName, age, and department. We also define a Builder class with the same four fields. The Builder class has methods for setting the age and department fields, and a build() method that creates a new Employee object.
Here's how you can create a new Employee object using the Builder:

```java
Employee employee = new Employee.Builder("John", "Doe").age(30).department("IT").build();
```

This creates a new Employee object with the firstName "John", lastName "Doe", age 30, and department "IT". Once the Employee object is created, it can't be modified, because all of the fields are final.

2. ##### Creating complex objects:
   If an object has many attributes, creating it using a constructor with many parameters can be confusing and error-prone. The Builder pattern can simplify this process by providing a fluent interface that guides the developer through the creation process. **Refer to examples 1 & 2**.
3. ##### Providing default values:

   If an object has many optional attributes, the Builder pattern can be used to provide default values for those attributes. This can simplify the creation process and make it less error-prone.

   Suppose we have a Person class with multiple optional attributes like age, height, weight, and address. We can use the Builder pattern to provide default values for these optional attributes:

```java
public class Person {
    private final String name;
    private final int age;
    private final double height;
    private final double weight;
    private final String address;

    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.height = builder.height != null ? builder.height : 0;
        this.weight = builder.weight != null ? builder.weight : 0;
        this.address = builder.address != null ? builder.address : "";
    }

    // getters and builder class
    // ...
}

public static void main(String[] args) {
    Person person1 = new Person.Builder("John")
                        .age(30)
                        .address("123 com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main St")
                        .build();
    Person person2 = new Person.Builder("Mary")
                        .weight(60)
                        .build();
}
```

In the above example, we have provided default values of 0 for height and weight and an empty string for address. When we create an object using the builder, we only need to provide the required attributes, and the builder will use the default values for the optional attributes that are not specified.

The default values could be set in the builder class itself.

```java
public class Person {
private final String name;
private final int age;
private final int height;
private final int weight;
private final String address;

    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.height = builder.height;
        this.weight = builder.weight;
        this.address = builder.address;
    }

    public static class Builder {
        // Required parameters
        private final String name;

        // Optional parameters - initialized to default values
        private int age = 0;
        private int height = 0;
        private int weight = 0;
        private String address = "Not available";

        public Builder(String name) {
            this.name = name;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public Builder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    public static void main(String[] args) {
        Person person = new Person.Builder("John")
                        .age(25)
                        .height(180)
                        .build();
    }

}
```

4.  ##### Supporting different object representations:

    Sometimes, you need to create objects that can be represented in different ways. For example, you might need to create an object that can be serialized to JSON or XML. The Builder pattern can be used to create a single object that can be represented in different ways, depending on the needs of the application.

    Suppose you have a class Person that represents a person with some attributes like name, age, and email. Now you want to support creating Person objects that can be represented in different formats such as JSON and XML.

```java
    public class Person {
    private String name;
    private int age;
    private String email;

        public static class Builder {
            private String name;
            private int age;
            private String email;

            public Builder name(String name) {
                this.name = name;
                return this;
            }

            public Builder age(int age) {
                this.age = age;
                return this;
            }

            public Builder email(String email) {
                this.email = email;
                return this;
            }

            public Person build() {
                return new Person(this);
            }

            public String toJson() {
                // return the JSON representation of the Person object
            }

            public String toXml() {
                // return the XML representation of the Person object
            }
        }

        private Person(Builder builder) {
            name = builder.name;
            age = builder.age;
            email = builder.email;
        }

        // getters for name, age, and email

}
```

In this example, the Person class has a Builder class nested inside it. The Builder has methods for setting the attributes of the Person object and a build() method for creating a new Person object.
Additionally, the Builder class has two methods for representing the Person object in different formats: toJson() and toXml(). These methods use the data in the Builder instance to create a JSON or XML string representation of the Person object.
Here's an example of how you could use the Builder to create a Person object and represent it as JSON:

```java
Person person = new Person.Builder()
.name("John Doe")
.age(30)
.email("john.doe@example.com")
.build();
String json = person.toJson();
```

And here's an example of how you could use the Builder to create the same Person object and represent it as XML:

```java
Person person = new Person.Builder()
.name("John Doe")
.age(30)
.email("john.doe@example.com")
.build();
String xml = person.toXml();
```

In this way, the Builder pattern allows you to create objects that can be represented in different ways, depending on the needs of your application.
When creating objects with circular dependencies:
Circular dependencies occur when two or more objects depend on each other in a way that creates a loop. The Builder pattern can be used to break these circular dependencies and make it easier to create the objects.

Suppose we have two classes Person and Address, where a person has an address, and an address has a reference to the person it belongs to. This creates a circular dependency between the two classes, making it difficult to instantiate them. We can use the builder pattern to create instances of these classes without the circular dependency.

```java
// Person.java
public class Person {
   private String name;
   private int age;
   private Address address;

   public Person(String name, int age, Address address) {
       this.name = name;
       this.age = age;
       this.address = address;
   }

   public void setAddress(Address address) {
       this.address = address;
   }

   public String getName() {
       return name;
   }

   public int getAge() {
       return age;
   }

   public Address getAddress() {
       return address;
   }
}

// Address.java
public class Address {
   private String street;
   private String city;
   private Person person;

   public Address(String street, String city) {
       this.street = street;
       this.city = city;
   }

   public void setPerson(Person person) {
       this.person = person;
   }

   public String getStreet() {
       return street;
   }

   public String getCity() {
       return city;
   }

   public Person getPerson() {
       return person;
   }
}

// PersonBuilder.java
public class PersonBuilder {
   private String name;
   private int age;
   private Address address;

   public PersonBuilder setName(String name) {
       this.name = name;
       return this;
   }

   public PersonBuilder setAge(int age) {
       this.age = age;
       return this;
   }

   public PersonBuilder setAddress(Address address) {
       this.address = address;
       return this;
   }

   public Person build() {
       Person person = new Person(name, age, address);
       address.setPerson(person);
       return person;
   }
}

// AddressBuilder.java
public class AddressBuilder {
   private String street;
   private String city;

   public AddressBuilder setStreet(String street) {
       this.street = street;
       return this;
   }

   public AddressBuilder setCity(String city) {
       this.city = city;
       return this;
   }

   public Address build() {
       return new Address(street, city);
   }
}

// com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main.java
public class com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main {
   public static void main(String[] args) {
       Address address = new AddressBuilder()
                           .setStreet("123 com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main St")
                           .setCity("Anytown")
                           .build();

       Person person = new PersonBuilder()
                           .setName("John Doe")
                           .setAge(30)
                           .setAddress(address)
                           .build();

       System.out.println(person.getName() + " is " + person.getAge()
                           + " years old and lives at " + person.getAddress().getStreet()
                           + " in " + person.getAddress().getCity() + ".");
   }
}
```

In this example, we have created separate builders for Person and Address. The PersonBuilder takes an Address as a parameter, and the AddressBuilder doesn't take any parameters. When a Person object is created using the PersonBuilder, it sets the Address object on the Person, and then sets the Person object on the Address. This way, both the Person and Address objects are created without any circular dependencies.

6. **Validate an object of a class before creation**:

The builder pattern allows you to create objects that are validated before they are created, ensuring that they are in a valid state from the start.

Suppose you have a Person class with some attributes like name, age, and email. You want to ensure that the Person object is valid, which means that it has a non-empty name, a valid age, and a valid email address. You can use the Builder pattern to validate the Person object before creating it.

```java
    public class Person {
    private String name;
    private int age;
    private String email;

        public static class Builder {
            private String name;
            private int age;
            private String email;

            public Builder name(String name) {
                this.name = name;
                return this;
            }

            public Builder age(int age) {
                if (age < 0 || age > 120) {
                    throw new IllegalArgumentException("Invalid age: " + age);
                }
                this.age = age;
                return this;
            }

            public Builder email(String email) {
                if (!isValidEmail(email)) {
                    throw new IllegalArgumentException("Invalid email: " + email);
                }
                this.email = email;
                return this;
            }

            private boolean isValidEmail(String email) {
                // implement email validation logic here
                return true;
            }

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

        private Person(Builder builder) {
            name = builder.name;
            age = builder.age;
            email = builder.email;
        }

        // getters for name, age, and email

    }

```

In this example, the Builder class has validation logic in the age() and email() methods. If the age is less than 0 or greater than 120, or if the email is not valid, an IllegalArgumentException is thrown.
Additionally, the Builder has a private isValidEmail() method that implements email validation logic. This method can be reused across different methods that need to validate email addresses.
The build() method of the Builder class checks that the required fields (name, age, and email) are not null or empty, and throws an IllegalStateException if any of them are missing.
Here's an example of how you could use the Builder to create a Person object with validation:

```java
Person person = new Person.Builder()
                          .name("John Doe")
                          .age(30)
                          .email("john.doe@example.com")
                          .build();
```

7. **Creating test data:**

If you need to create test data for your application, the Builder pattern can be used to generate objects with specific attribute values for testing purposes.

8.  **Decoupling the object creation process:**

    If the creation of an object is complex and involves multiple steps, the Builder pattern can be used to decouple the creation process from the rest of the application. This can make the code more modular and easier to maintain.

    Suppose we have a Car class that requires a complex object creation process with multiple steps like building the engine, chassis, and wheels. We can use the Builder pattern to decouple the creation process from the rest of the application:

```java
    public class Car {
    private final Engine engine;
    private final Chassis chassis;
    private final List<Wheel> wheels;

        private Car(Builder builder) {
            this.engine = builder.engine;
            this.chassis = builder.chassis;
            this.wheels = builder.wheels;
        }

        public Engine getEngine() {
            return engine;
        }

        public Chassis getChassis() {
            return chassis;
        }

        public List<Wheel> getWheels() {
            return wheels;
        }

        public static class Builder {
            private Engine engine;
            private Chassis chassis;
            private List<Wheel> wheels;

            public Builder withEngine(Engine engine) {
                this.engine = engine;
                return this;
            }

            public Builder withChassis(Chassis chassis) {
                this.chassis = chassis;
                return this;
            }

            public Builder withWheels(Wheel wheel) {
                if (this.wheels == null) {
                    this.wheels = new ArrayList<>();
                }
                this.wheels.add(wheel);
                return this;
            }

            public Car build() {
                return new Car(this);
            }
        }

}

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

public class Chassis {
private final String color;

    private Chassis(Builder builder) {
        this.color = builder.color;
    }

    public String getColor() {
        return color;
    }

    public static class Builder {
        private String color;

        public Builder withColor(String color) {
            this.color = color;
            return this;
        }

        public Chassis build() {
            return new Chassis(this);
        }
    }

}

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

public static void main(String[] args) {
Car car = new Car.Builder()
.withEngine(new Engine.Builder().withType("V8").build())
.withChassis(new Chassis.Builder().withColor("red").build())
.withWheels(new Wheel.Builder().withSize(20).build())
.withWheels(new Wheel.Builder().withSize(20).build())
.withWheels(new Wheel.Builder().withSize(20).build())
.withWheels(new Wheel.Builder().withSize(20).build())
.build();

    System.out.println("Engine type: " + car.getEngine().getType());
    System.out.println("Chassis color: " + car.getChassis().getColor());
    System.out.println("Number of wheels: " + car.getWheels().size());

}
```

### Diagram
```mermaid
classDiagram
    class Car {
        -engine: Engine
        -chassis: Chassis
        -wheels: List~Wheel~
        +getEngine() Engine
        +getChassis() Chassis
        +getWheels() List~Wheel~
        +Builder: Builder
    }

    class Car.Builder {
        -engine: Engine
        -chassis: Chassis
        -wheels: List~Wheel~
        +withEngine(Engine) Builder
        +withChassis(Chassis) Builder
        +withWheels(Wheel) Builder
        +build() Car
    }

    class Engine {
        -type: String
        +getType() String
        +Builder: Builder
    }

    class Engine.Builder {
        -type: String
        +withType(String) Builder
        +build() Engine
    }

    class Chassis {
        -color: String
        +getColor() String
        +Builder: Builder
    }

    class Chassis.Builder {
        -color: String
        +withColor(String) Builder
        +build() Chassis
    }

    class Wheel {
        -size: int
        +getSize() int
        +Builder: Builder
    }

    class Wheel.Builder {
        -size: int
        +withSize(int) Builder
        +build() Wheel
    }

    %% Relationships
    Car --> Engine : has
    Car --> Chassis : has
    Car --> Wheel : has *

    Car ..> Car.Builder : creates
    Car.Builder --> Car : builds

    Engine ..> Engine.Builder : creates
    Engine.Builder --> Engine : builds

    Chassis ..> Chassis.Builder : creates
    Chassis.Builder --> Chassis : builds

    Wheel ..> Wheel.Builder : creates
    Wheel.Builder --> Wheel : builds

    %% Usage in main()
    class Main {
        +main()
    }

    Main ..> Car.Builder : uses
    Main ..> Engine.Builder : uses
    Main ..> Chassis.Builder : uses
    Main ..> Wheel.Builder : uses
```

### Sequence Diagram
```mermaid
sequenceDiagram
    participant Main
    participant Chef
    participant HawaiianPizzaBuilder
    participant Pizza

    Main->>HawaiianPizzaBuilder: new()
    Main->>Chef: setPizzaBuilder(HawaiianPizzaBuilder)
    Chef->>HawaiianPizzaBuilder: buildDough()
    Chef->>HawaiianPizzaBuilder: buildSauce()
    Chef->>HawaiianPizzaBuilder: buildToppings()
    Main->>Chef: getPizza()
    Chef->>HawaiianPizzaBuilder: getPizza()
    HawaiianPizzaBuilder-->>Chef: Pizza
    Chef-->>Main: Pizza
```

In this example, we have a Car class with a builder and three component classes (Engine, Chassis, and Wheel) with their respective builders. The Car builder allows us to build a car by specifying its components using their respective builders.

# Prototype Design Pattern:

`Prototype` design pattern is a creational design pattern that allows creating new objects by cloning existing ones. Instead of creating new objects by invoking their constructors, the prototype pattern involves cloning an existing object and modifying it as required. This pattern is useful when creating new objects is time-consuming or complex, or when the constructor cannot be called directly.

The prototype pattern involves creating a prototype interface or class that declares the clone method, which returns a copy of the current object. The concrete prototype classes implement this interface or extend the prototype class and override the clone method to create a copy of the current object.

##### Example 1:

An example of the prototype pattern is creating an online quiz platform where there are different types of quizzes with different question sets, and each quiz type can have multiple instances with different sets of questions. In this scenario, instead of creating each quiz instance from scratch, we can create a prototype object for each quiz type with the default set of questions. When a new instance of a quiz is required, we can clone the prototype object and modify it with the required set of questions.

```java
public interface Quiz extends Cloneable {
    public Quiz clone() throws CloneNotSupportedException;
    public void setQuestions(String[] questions);
    public void startQuiz();
}

public class ScienceQuiz implements Quiz {
    private String[] questions;

    public ScienceQuiz() {
        // default set of questions for Science quiz
        this.questions = new String[] {"What is the largest planet in our solar system?",
                                       "What is the smallest planet in our solar system?",
                                       "What is the most abundant gas in Earth's atmosphere?"};
    }

    public Quiz clone() throws CloneNotSupportedException {
        ScienceQuiz cloned = new ScienceQuiz();
        cloned.setQuestions(this.questions.clone());
        return cloned;
    }

    public void setQuestions(String[] questions) {
        this.questions = questions;
    }

    public void startQuiz() {
        System.out.println("Starting Science Quiz with questions:");
        for (String question : this.questions) {
            System.out.println(question);
        }
    }
}

public class QuizApp {
    public static void main(String[] args) throws CloneNotSupportedException {
        // create a prototype Science quiz object
        Quiz scienceQuizPrototype = new ScienceQuiz();

        // create a new Science quiz instance by cloning the prototype object
        Quiz scienceQuizInstance1 = scienceQuizPrototype.clone();
        scienceQuizInstance1.setQuestions(new String[] {"What is the speed of light?",
                                                        "What is the smallest particle in an element?",
                                                        "What is the equation for gravitational force?"});
        scienceQuizInstance1.startQuiz();

        // create another Science quiz instance by cloning the prototype object
        Quiz scienceQuizInstance2 = scienceQuizPrototype.clone();
        scienceQuizInstance2.setQuestions(new String[] {"What is the unit of electric charge?",
                                                        "What is the boiling point of water?",
                                                        "What is the process of converting solid directly to gas?"});
        scienceQuizInstance2.startQuiz();
    }
}
````

In this example, the Quiz interface defines the clone, setQuestions, and startQuiz methods that are implemented by the ScienceQuiz class. The ScienceQuiz class implements the clone method to create a new instance of the ScienceQuiz object and set the questions based on the current object's questions. The startQuiz method displays the questions on the console.

The QuizApp class creates a prototype object of the ScienceQuiz class and then creates two new instances of the Science quiz by cloning the prototype object and setting the questions. The output of the program shows the questions for each quiz instance.

#### Example 2:

Suppose there is a document creation application that allows users to create different types of documents such as letters, reports, and memos. Instead of creating a new document from scratch each time, the application could use the Prototype pattern to clone an existing document object and modify it as needed.

```java
public abstract class Document implements Cloneable {
   private String text;

   public String getText() {
      return text;
   }

   public void setText(String text) {
      this.text = text;
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }
}

public class Letter extends Document {
   private String recipient;

   public String getRecipient() {
      return recipient;
   }

   public void setRecipient(String recipient) {
      this.recipient = recipient;
   }
}

public class Report extends Document {
   private String author;

   public String getAuthor() {
      return author;
   }

   public void setAuthor(String author) {
      this.author = author;
   }
}

public class DocumentManager {
   private Map<String, Document> prototypes = new HashMap<>();

   public DocumentManager() {
      Letter letter = new Letter();
      letter.setText("Dear [recipient],\n\nSincerely,\n[author]");
      prototypes.put("letter", letter);

      Report report = new Report();
      report.setText("This is a report written by [author]");
      prototypes.put("report", report);
   }

   public void addPrototype(String key, Document prototype) {
      prototypes.put(key, prototype);
   }

   public void removePrototype(String key) {
      prototypes.remove(key);
   }

   public Document clone(String key) throws CloneNotSupportedException {
      return (Document) prototypes.get(key).clone();
   }
}

public class Main {
   public static void main(String[] args) throws CloneNotSupportedException {
      DocumentManager documentManager = new DocumentManager();
      documentManager.addPrototype("memo", new Document());

      Document letter = documentManager.clone("letter");
      ((Letter) letter).setRecipient("John Doe");
      ((Letter) letter).setAuthor("Jane Smith");

      Document report = documentManager.clone("report");
      ((Report) report).setAuthor("Bob Johnson");

      System.out.println(letter.getText());
      System.out.println(report.getText());
   }
}
```

### Class Diagram

```mermaid
classDiagram
    %% Abstract Base Class
    class Document {
        <<abstract>>
        -text: String
        +getText() String
        +setText(String)
        +clone() Object
    }

    %% Concrete Document Types
    class Letter {
        -recipient: String
        +getRecipient() String
        +setRecipient(String)
    }

    class Report {
        -author: String
        +getAuthor() String
        +setAuthor(String)
    }

    %% Document Manager
    class DocumentManager {
        -prototypes: Map~String, Document~
        +DocumentManager()
        +addPrototype(String, Document)
        +removePrototype(String)
        +clone(String) Document
    }

    %% Main Class
    class Main {
        +main(String[])
    }

    %% Relationships
    Document <|-- Letter
    Document <|-- Report

    DocumentManager "1" *-- "*" Document : manages prototypes
    DocumentManager ..> Document : clones

    Main ..> DocumentManager : uses
    Main ..> Letter : casts
    Main ..> Report : casts
```

In this example, the Document class is the abstract prototype that defines the interface for creating new documents. The Letter and Report classes are concrete prototypes that extend the Document class and provide their own implementation of the getText() method. The DocumentManager class is responsible for managing the prototypes and creating new documents based on existing prototypes. The com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main class demonstrates how the application can create new Letter and Report objects by cloning the corresponding prototypes and modifying the recipient and author fields as needed.

### Registry Design Pattern:

The Registry design pattern is a creational pattern that provides a centralized point of access for objects of a certain type, allowing them to be shared and reused across the system. The registry maintains a registry of objects and provides a way to retrieve and store them.

#### Example 1:

```java
public class Employee {
private String name;
private int age;
private String department;

    public Employee(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + ", department=" + department + "]";
    }

}

public class EmployeeRegistry {
private static Map<String, Employee> registry = new HashMap<>();

    public static void addEmployee(String id, Employee employee) {
        registry.put(id, employee);
    }

    public static Employee getEmployee(String id) {
        return registry.get(id);
    }

    public static void removeEmployee(String id) {
        registry.remove(id);
    }

}

public class Main {
public static void main(String[] args) {
Employee employee1 = new Employee("John Doe", 30, "Sales");
Employee employee2 = new Employee("Jane Smith", 25, "Marketing");

        EmployeeRegistry.addEmployee("001", employee1);
        EmployeeRegistry.addEmployee("002", employee2);

        Employee retrievedEmployee1 = EmployeeRegistry.getEmployee("001");
        Employee retrievedEmployee2 = EmployeeRegistry.getEmployee("002");

        System.out.println(retrievedEmployee1);
        System.out.println(retrievedEmployee2);

        EmployeeRegistry.removeEmployee("002");

        Employee retrievedEmployee3 = EmployeeRegistry.getEmployee("002");

        System.out.println(retrievedEmployee3);
    }

}
```

In this example, we have an Employee class that represents an employee with a name, age, and department. We also have an EmployeeRegistry class that acts as a registry of employees. It maintains a Map of employee IDs to Employee objects, and provides methods to add, retrieve, and remove employees from the registry.

In the Pizza.Main class, we create two Employee objects and add them to the registry using their IDs. We then retrieve the employees from the registry using their IDs and print out their details. We also remove one of the employees from the registry and attempt to retrieve it again to demonstrate that it has been removed.

This example demonstrates how the Registry pattern can be used to maintain a central registry of objects that can be shared and reused across the system.

#### Example 2:

Suppose you are developing a software system for a hospital. The system needs to keep track of all the patients who are currently admitted to the hospital. Each patient has a unique patient ID and associated information such as name, age, gender, and medical history.

You could use the Registry pattern to manage a central registry of all patient objects in the system. This registry would allow you to quickly look up patient objects by their ID and perform operations on them, such as updating their medical records or discharging them from the hospital.

```java
public class Patient {
private int id;
private String name;
private int age;
private String gender;
private String medicalHistory;

    // constructors, getters, and setters omitted for brevity

}

public class PatientRegistry {
private static final Map<Integer, Patient> registry = new HashMap<>();

    public static void addPatient(Patient patient) {
        registry.put(patient.getId(), patient);
    }

    public static Patient getPatientById(int id) {
        return registry.get(id);
    }

    public static void updatePatientMedicalHistory(int id, String medicalHistory) {
        Patient patient = registry.get(id);
        patient.setMedicalHistory(medicalHistory);
    }

    // other operations on patients omitted for brevity

}
```

In this example, the PatientRegistry class acts as a centralized registry for all Patient objects in the system. The registry is implemented as a Map that maps patient IDs to patient objects. The registry provides several methods for adding, retrieving, and updating patient objects in the registry. Other classes in the system can use the registry to perform operations on patient objects without having to manage the objects themselves.


## Prototype pattern
- The Prototype pattern is a creational design pattern that allows you to create new objects `based on an existing instance` (prototype) through `cloning`. 
- `Instead of creating new instances` using constructors, the Prototype pattern involves creating new objects by `copying an existing object`, known as the prototype.

### Key Concepts
- **Prototype Interface**: This interface declares a method for cloning itself. It can be an abstract class or interface.
- **Concrete Prototype**: This is the class that implements the Prototype interface and provides the cloning functionality.
- **Client**: The client is responsible for creating new objects by cloning the prototype.

#### Example 1: 
```java
// Prototype Interface
public interface Shape extends Cloneable {
    Shape clone();
    void draw();
}

// Concrete Prototype
public class Circle implements Shape {
    @Override
    public Shape clone() {
        return new Circle();
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

public class Rectangle implements Shape {
    @Override
    public Shape clone() {
        return new Rectangle();
    }

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}


// Client Code
public class Client {
    public static void main(String[] args) {
        Shape circlePrototype = new Circle();
        Shape rectanglePrototype = new Rectangle();

        // Create new shapes by cloning the prototypes
        Shape clonedCircle = circlePrototype.clone();
        Shape clonedRectangle = rectanglePrototype.clone();

        // Draw the cloned shapes
        clonedCircle.draw(); // Drawing a Circle
        clonedRectangle.draw(); // Drawing a Rectangle
    }
}
```

### Advantages of the Prototype Pattern
- **Reduced Subclassing**: The Prototype pattern allows you to create new objects by cloning an existing prototype, reducing the need for subclassing.
- **Flexibility**: It provides a way to create new objects with varying configurations or states without compromising their common interface.
- **Performance**: Cloning objects can be more efficient than creating new instances using constructors, especially for complex objects.
- **Encapsulation**: Clients can create new objects without needing to know their concrete classes, promoting encapsulation.

### Drawbacks
- **Deep Copy Complexity**: If the prototype contains references to other objects, you need to implement deep copy logic to clone those objects recursively.
- **Cloning Restrictions**: Not all objects in Java are cloneable. If a class does not implement the Cloneable interface, cloning will result in a CloneNotSupportedException.

#### Example 2: 
An example of the prototype pattern is creating an online quiz platform where there are different types of quizzes with different question sets, and each quiz type can have multiple instances with different sets of questions. In this scenario, instead of creating each quiz instance from scratch, we can create a prototype object for each quiz type with the default set of questions. When a new instance of a quiz is required, we can clone the prototype object and modify it with the required set of questions.


```java
public interface Quiz extends Cloneable {
    public Quiz clone() throws CloneNotSupportedException;
    public void setQuestions(String[] questions);
    public void startQuiz();
}

public class ScienceQuiz implements Quiz {
    private String[] questions;

    public ScienceQuiz() {
        // default set of questions for Science quiz
        this.questions = new String[] {"What is the largest planet in our solar system?",
                "What is the smallest planet in our solar system?",
                "What is the most abundant gas in Earth's atmosphere?"};
    }

    public Quiz clone() throws CloneNotSupportedException {
        ScienceQuiz cloned = new ScienceQuiz();
        cloned.setQuestions(this.questions.clone());
        return cloned;
    }

    public void setQuestions(String[] questions) {
        this.questions = questions;
    }

    public void startQuiz() {
        System.out.println("Starting Science Quiz with questions:");
        for (String question : this.questions) {
            System.out.println(question);
        }
    }
}

public class QuizApp {
    public static void main(String[] args) throws CloneNotSupportedException {
        // create a prototype Science quiz object
        Quiz scienceQuizPrototype = new ScienceQuiz();

        // create a new Science quiz instance by cloning the prototype object
        Quiz scienceQuizInstance1 = scienceQuizPrototype.clone();
        scienceQuizInstance1.setQuestions(new String[] {"What is the speed of light?",
                "What is the smallest particle in an element?",
                "What is the equation for gravitational force?"});
        scienceQuizInstance1.startQuiz();

        // create another Science quiz instance by cloning the prototype object
        Quiz scienceQuizInstance2 = scienceQuizPrototype.clone();
        scienceQuizInstance2.setQuestions(new String[] {"What is the unit of electric charge?",
                "What is the boiling point of water?",
                "What is the process of converting solid directly to gas?"});
        scienceQuizInstance2.startQuiz();
    }
}
```

- In this example, the Quiz interface defines the clone, setQuestions, and startQuiz methods that are implemented by the ScienceQuiz class. The ScienceQuiz class implements the clone method to create a new instance of the ScienceQuiz object and set the questions based on the current object's questions. The startQuiz method displays the questions on the console.

- The QuizApp class creates a prototype object of the ScienceQuiz class and then creates two new instances of the Science quiz by cloning the prototype object and setting the questions. The output of the program shows the questions for each quiz instance.



#### Example 3: 
```java
// Prototype Interface: This abstract class declares the method for cloning itself.
public abstract class Document implements Cloneable {  
   private String text;

   public String getText() {
      return text;
   }

   public void setText(String text) {
      this.text = text;
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }
}

// Concrete Prototype: This is a concrete class extending Document, which can be cloned.
public class Letter extends Document {  
   private String recipient;

   public String getRecipient() {
      return recipient;
   }

   public void setRecipient(String recipient) {
      this.recipient = recipient;
   }

   // Adding an author field to use in the clone process.
   public void setAuthor(String author) {
      // Implement author handling logic for letter
   }
}

// Concrete Prototype: Another concrete class that implements cloning.
public class Report extends Document {  
   private String author;

   public String getAuthor() {
      return author;
   }

   public void setAuthor(String author) {
      this.author = author;
   }
}

// Client: Manages prototypes and uses the clone method to create copies of them.
public class DocumentManager {  
   private Map<String, Document> prototypes = new HashMap<>();

   public DocumentManager() {
      // Preloading prototype objects
      Letter letter = new Letter();
      letter.setText("Dear [recipient],\n\nSincerely,\n[author]");
      prototypes.put("letter", letter);

      Report report = new Report();
      report.setText("This is a report written by [author]");
      prototypes.put("report", report);
   }

   // Adding a prototype
   public void addPrototype(String key, Document prototype) {
      prototypes.put(key, prototype);
   }

   // Removing a prototype
   public void removePrototype(String key) {
      prototypes.remove(key);
   }

   // Cloning the prototype object
   public Document clone(String key) throws CloneNotSupportedException {
      return (Document) prototypes.get(key).clone();
   }
}

// Client: Demonstrates cloning the prototypes and using the cloned objects.
public class Main {  
   public static void main(String[] args) throws CloneNotSupportedException {
      DocumentManager documentManager = new DocumentManager();
      documentManager.addPrototype("memo", new Document());  // Adding an abstract prototype (not useful in this case)

      // Cloning a letter prototype and setting specific details
      Document letter = documentManager.clone("letter");
      ((Letter) letter).setRecipient("John Doe");
      ((Letter) letter).setAuthor("Jane Smith");

      // Cloning a report prototype and setting specific details
      Document report = documentManager.clone("report");
      ((Report) report).setAuthor("Bob Johnson");

      // Displaying the cloned documents' texts
      System.out.println(letter.getText());
      System.out.println(report.getText());
   }
}

```

### Breakdown of Tagged Roles:
**1. Prototype Interface:**
- Document (abstract class) — Defines the clone() method for cloning itself.

**2. Concrete Prototype:**
- Letter — A concrete implementation of Document that supports cloning.
- Report — Another concrete implementation of Document that supports cloning.

**3. Client:**
- DocumentManager — Manages prototypes and handles cloning requests.
- Main — Demonstrates the creation of new objects by cloning the prototypes.