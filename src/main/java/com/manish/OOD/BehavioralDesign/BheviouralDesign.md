# Behavioral Design Patterns

#### Overview:

- Behavioral design patterns are a set of solutions to common problems related to how objects in a software system communicate and work together to accomplish a task or goal.

- It address common issues related to object interaction and communication in a system. They provide flexible and efficient solutions to manage complex interactions between objects, ensuring that different parts of a system work together seamlessly.

### Key Behavioral Design Patterns:

There are several behavioral design patterns, including:
- **Observer Pattern**: This pattern defines a one-to-many relationship between objects, so that when one object changes state, all its dependents are notified and updated automatically. This pattern is useful when you have objects that need to be notified when something changes, but you don't want to tightly couple them together.
- **Strategy Pattern**: This pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. This allows you to select an algorithm at runtime, based on the situation. This pattern is useful when you have a set of algorithms that can be used interchangeably, depending on the context.
- **Command Pattern**: This pattern encapsulates a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations. This pattern is useful when you need to separate the object that invokes a command from the object that knows how to execute it.
- **Template Method Pattern**: This pattern defines the skeleton of an algorithm in a base class, but lets subclasses override specific steps of the algorithm without changing its structure. This pattern is useful when you have a set of similar algorithms with slight variations.
- **Iterator Pattern**: This pattern provides a way to access the elements of an aggregate object sequentially, without exposing its underlying representation. This pattern is useful when you have a collection of objects that you want to iterate over without exposing the internal implementation of the collection.



### 1. Observer Pattern

- Defines a `one-to-many` dependency **between objects**.
- When one object (subject) **changes its state**, all dependents (observers) are **notified and updated automatically**.
- **Use case:** UI frameworks where multiple elements need to react to changes in one part of the system (e.g., event listeners in GUIs).

**Key Concepts**
1. **Subject**: The object that holds the state and is monitored by observers. It provides methods to attach, detach, and notify observers.
2. **Observer**: The objects that are notified when the subject's state changes. They implement an update method to handle updates from the subject.


**Implementation Steps in Java**

1. **Define the Subject Interface**: This interface includes methods for attaching, detaching, and notifying observers.
2. **Implement the Subject**: Create a concrete class that maintains a list of observers and implements the subject interface.
3. **Define the Observer Interface**: This interface declares the update method that will be called when the subject's state changes.
4. **Implement the Observers**: Create concrete observer classes that implement the observer interface and define the update method.


Example

Here is a simple example demonstrating the Observer pattern in Java:

Step 1: Define the Subject Interface

```java
// Step 1: Define the Subject Interface
import java.util.ArrayList;
import java.util.List;

interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers();
}

// Step 2: Implement the Subject
class ConcreteSubject implements Subject {
  private List<Observer> observers = new ArrayList<>();
  private String state;

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
    notifyObservers();
  }

  @Override
  public void attach(Observer o) {
    observers.add(o);
  }

  @Override
  public void detach(Observer o) {
    observers.remove(o);
  }

  @Override
  public void notifyObservers() {
    for (Observer o : observers) {
      o.update();
    }
  }
}
// Step 3: Define the Observer Interface
interface Observer {
  void update();
}
// Step 4: Implement the Observers
class ConcreteObserver implements Observer {
  private String name;
  private ConcreteSubject subject;

  public ConcreteObserver(String name, ConcreteSubject subject) {
    this.name = name;
    this.subject = subject;
    this.subject.attach(this);
  }

  @Override
  public void update() {
    System.out.println("Observer " + name + " notified. New state is: " + subject.getState());
  }
}
// Step 5: Client Code to Demonstrate the Observer Pattern
public class ObserverPatternDemo {
  public static void main(String[] args) {
    ConcreteSubject subject = new ConcreteSubject();

    ConcreteObserver observer1 = new ConcreteObserver("Observer 1", subject);
    ConcreteObserver observer2 = new ConcreteObserver("Observer 2", subject);

    subject.setState("State 1");
    subject.setState("State 2");

    subject.detach(observer1);

    subject.setState("State 3");

    // Output:
    // Observer Observer 1 notified. New state is: State 1
    // Observer Observer 2 notified. New state is: State 1
    // Observer Observer 1 notified. New state is: State 2
    // Observer Observer 2 notified. New state is: State 2
    // Observer Observer 2 notified. New state is: State 3
  }
}
```

**Explanation**

1. **Subject Interface**: Subject interface declares methods for attaching, detaching, and notifying observers.

2. **ConcreteSubject Class**: This class implements Subject and maintains a list of observers. It updates the observers whenever its state changes.

3. **Observer Interface**: Observer interface declares the update method that observers must implement.

4. **ConcreteObserver Class**: This class implements Observer and defines the update method to perform actions when notified by the subject.

5. **Client Code**: Demonstrates creating a subject and multiple observers, changing the subject's state, and observing the notification process.

---

### 2. Strategy Pattern

- The Strategy pattern is a behavioral design pattern that enables selecting an algorithm's behavior at runtime. 
- Instead of implementing a single algorithm directly, code receives run-time instructions as to which in a family of algorithms to use. 
- This pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. 
- The Strategy pattern allows the algorithm to vary independently from the clients that use it.


- Encapsulates a family of algorithms and makes them interchangeable.
- Context: When you need to switch algorithms at runtime without modifying the objects that use them.
- Use case: Payment gateways, shipping cost calculators, and route finding in maps.


#### Key Concepts
- **Strategy Interfac**e: Defines a common interface for all supported algorithms.
- **Concrete Strategies**: Implementations of the strategy interface for different algorithms.
- **Context**: The class that uses a Strategy. It maintains a reference to a Strategy object and can change the strategy at runtime.

#### Implementation Steps

- **Define the Strategy Interface**: Create an interface that declares the method(s) that each concrete strategy must implement.
- **Implement Concrete Strategies**: Create classes that implement the strategy interface.
- **Define the Context Class**: Create a class that has a reference to a Strategy object and uses this object to execute the algorithm.

```java
// Step 1: Define the Strategy Interface
interface Strategy {
    int execute(int a, int b);
}

// Step 2: Implement Concrete Strategies
class AdditionStrategy implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a + b;
    }
}

class SubtractionStrategy implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a - b;
    }
}

class MultiplicationStrategy implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a * b;
    }
}

// Step 3: Define the Context Class
class Context {
    private Strategy strategy;

    // Method to set the strategy at runtime
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    // Method to execute the strategy
    public int executeStrategy(int a, int b) {
        return strategy.execute(a, b);
    }
}

// Step 4: Client Code to Demonstrate the Strategy Pattern
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context();

        // Use Addition Strategy
        context.setStrategy(new AdditionStrategy());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        // Use Subtraction Strategy
        context.setStrategy(new SubtractionStrategy());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        // Use Multiplication Strategy
        context.setStrategy(new MultiplicationStrategy());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}

// Output:
// 10 + 5 = 15
// 10 - 5 = 5
// 10 * 5 = 50

```
___

### 3. Command Pattern

- The Command pattern is a behavioral design pattern that encapsulates a request as an object, thereby allowing for parameterization of clients with queues, requests, and operations. 
- This pattern enables the separation of responsibilities, decoupling the sender of a request from its receiver.


**Key Components**
- **Command**: Encapsulates a request as an object, including all necessary information for its execution.
- **Invoker**: Asks the command to carry out the request.
- **Receiver**: Knows how to perform the operation associated with the command.
- **Client**: Creates and configures commands before passing them to the invoker to execute.


### How It Works
- **1. Client creates a Command**: It creates a command object and sets its receiver (the object that will perform the action) and any parameters.
- **2. Client passes the Command to the Invoker**: The client then passes the command object to the invoker (an object that knows how to execute commands).
- **3. Invoker executes the Command**: Upon receiving the command, the invoker calls the command's execute method.
- **4. Command calls Receiver's action**: The command, upon execution, calls the appropriate method on the receiver to perform the requested action.

**Example**

Let's consider a simple example of turning a light on and off using the Command pattern:

1. **Command Interface**: Define a common interface for all commands.
2. **Concrete Commands**: Implement the command interface for different actions.
3. **Receiver**: Implement the receiver, which knows how to perform the action.
4. **Invoker**: Execute commands.
5. **Client**: Creates and configures commands.

```java
// Command interface
interface Command {
    void execute();
}

// Concrete Command for turning the light on
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Concrete Command for turning the light off
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Receiver
class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

// Invoker
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Client code
public class CommandPatternDemo {
    public static void main(String[] args) {
        // Create the receiver
        Light light = new Light();

        // Create the concrete commands
        Command turnOnCommand = new LightOnCommand(light);
        Command turnOffCommand = new LightOffCommand(light);

        // Create the invoker
        RemoteControl remoteControl = new RemoteControl();

        // Set the commands
        remoteControl.setCommand(turnOnCommand);
        remoteControl.pressButton(); // Light is ON

        remoteControl.setCommand(turnOffCommand);
        remoteControl.pressButton(); // Light is OFF
    }
}
// Output:
// Light is ON
// Light is OFF

```

- Encapsulates a request as an object, allowing different requests to be handled similarly.
- Enables support for undo/redo operations, request queues, and logging.
- Use case: Transaction systems, UI button clicks, macros in text editors.
___

### 4.  State pattern

The State pattern addresses the problem of an object changing its behavior when its internal state changes. This is particularly useful in situations where an object must exhibit different behavior depending on its state, and the state-dependent behavior can change at runtime.

Here are some specific issues the State pattern helps to solve:

1. **Complex State Management:**

When an object has many states and transitions between states, managing this logic directly within the object can lead to complex and difficult-to-maintain code. The State pattern encapsulates state-specific behavior into separate state classes, making the main object simpler and more focused.

2. **State Transitions:**

Directly managing state transitions within an object can result in a proliferation of conditional statements (if-else or switch-case) to handle different states. This makes the code hard to read and maintain. The State pattern eliminates these conditionals by delegating state-specific behavior to state objects.

3. **Scalability:**

As new states are added, maintaining a monolithic class with extensive conditional logic becomes increasingly difficult. The State pattern allows new states to be added without modifying the existing code, adhering to the Open/Closed Principle.

4. **Behavioral Variation:**

An object may need to behave differently not just based on its state, but also based on the state transitions that occur. The State pattern encapsulates these variations, allowing each state class to handle its own behavior and transitions.

5. **State-Specific Behavior:**

Each state can have different methods and behavior. With the State pattern, state-specific methods can be defined in the state classes, providing clear separation of concerns.

In summary, the State pattern provides a structured way to manage state-specific behavior and state transitions, making the code more maintainable, scalable, and easier to understand. It helps to avoid complex conditional logic and promotes the single responsibility principle by delegating behavior to individual state classes.

**Example without state pattern:**
```java
class TrafficLight {
    enum State { RED, GREEN, YELLOW }
    private State state;

    public void change() {
        switch (state) {
            case RED:
                // Change from red to green
                state = State.GREEN;
                break;
            case GREEN:
                // Change from green to yellow
                state = State.YELLOW;
                break;
            case YELLOW:
                // Change from yellow to red
                state = State.RED;
                break;
        }
    }
}
```

**Example with state pattern:**
```java
interface TrafficLightState {
    void change(TrafficLight light);
}

class RedLight implements TrafficLightState {
    public void change(TrafficLight light) {
        light.setState(new GreenLight());
    }
}

class GreenLight implements TrafficLightState {
    public void change(TrafficLight light) {
        light.setState(new YellowLight());
    }
}

class YellowLight implements TrafficLightState {
    public void change(TrafficLight light) {
        light.setState(new RedLight());
    }
}

class TrafficLight {
    private TrafficLightState state;

    public TrafficLight(TrafficLightState initialState) {
        this.state = initialState;
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void change() {
        state.change(this);
    }
}
```


___

### 5. Template Method Pattern

- Defines the skeleton of an algorithm in a base class but allows subclasses to override specific steps.
- Use case: Sorting algorithms or game logic where certain behaviors are shared but others are specific.

___

### 6. Iterator Pattern

- Provides a way to sequentially access elements of a collection without exposing its underlying structure.
- Use case: Traversing data structures like lists, trees, or arrays in libraries.
___

## Deep Dive into Strategy Pattern:

- Definition: A behavioral pattern that defines a set of interchangeable algorithms encapsulated as individual classes. It allows the client to select and change the algorithm at runtime.

#### Key Concepts:

- **Context Class:** Holds a reference to a strategy and allows dynamic algorithm changes.
- **Strategy Interface:** Common interface for all algorithms, ensuring interchangeability.
- **Concrete Strategies:** Implement different algorithms based on the strategy interface.

- **Interview Tip:**
  The Strategy Pattern is often discussed because it promotes the Open/Closed Principle (open for extension, closed for modification). Be prepared to explain how this pattern decouples the algorithm from the client, making it flexible.
___

#### What is the Chain of Responsibility pattern, and when would you use it?
The Chain of Responsibility pattern is a behavioral design pattern that allows an object to pass a request along a chain of potential handlers until one of them handles the request. This pattern decouples senders and receivers of requests, giving multiple objects the opportunity to handle a request without having explicit knowledge of the request's origin or final destination.


**Key Concepts:**

- **Handler**: An interface or an abstract class that defines the method for handling requests and optionally a reference to the next handler in the chain.
- **Concrete Handler**: Implementations of the handler interface or class. Each concrete handler decides whether to handle the request and, optionally, passes the request to the next handler in the chain.


#### When to Use the Chain of Responsibility Pattern:

1. **Multiple Objects Should Have the Opportunity to Handle a Request**: If there are multiple objects that can potentially handle a request, and the client is unaware of which object will handle the request, the Chain of Responsibility pattern is appropriate.
2. **The Set of Objects That Can Handle a Request Should Be Specified Dynamically**: Instead of having fixed handling logic in the client code, the Chain of Responsibility allows for dynamic assignment of handlers at runtime.
3. **The Request Should Be Processed by One of Several Recipients, but the Client Doesn't Have to Know Which One**: Clients can simply send a request without having to know the specific handler that will process it. This promotes loose coupling between clients and handlers.
4. **The Handler Order Is Not Predetermined or Can Be Configured Dynamically**: The order of handlers in the chain can be determined dynamically at runtime, allowing for flexibility in handling requests.


**Example Scenario:**

Consider a customer support ticket system where customer issues need to be resolved by different levels of support staff: Level 1, Level 2, and Level 3. The request should be handled by the appropriate level of support staff, depending on the complexity of the issue.


**Without Chain of Responsibility Pattern:**

In a non-chain implementation, the client would need to know the specific support level to which the ticket should be routed, leading to tight coupling between the client and the support staff classes.


**With Chain of Responsibility Pattern:**

Using the Chain of Responsibility pattern, each level of support staff can be a handler in the chain. When a ticket is submitted, it traverses the chain until a support level capable of handling the issue is found.

```java
// Handler interface
interface Handler {
    void handleRequest(String request);
    void setSuccessor(Handler successor);
}

// Base handler class
abstract class AbstractHandler implements Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}

// Concrete handlers
class ConcreteHandler1 extends AbstractHandler {
    public void handleRequest(String request) {
        if (request.equals("request1")) {
            System.out.println("ConcreteHandler1 is handling the request");
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

class ConcreteHandler2 extends AbstractHandler {
    public void handleRequest(String request) {
        if (request.equals("request2")) {
            System.out.println("ConcreteHandler2 is handling the request");
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

class ConcreteHandler3 extends AbstractHandler {
    public void handleRequest(String request) {
        if (request.equals("request3")) {
            System.out.println("ConcreteHandler3 is handling the request");
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

// Client
public class Client {
    public static void main(String[] args) {
        Handler handler3 = new ConcreteHandler3();
        Handler handler2 = new ConcreteHandler2();
        Handler handler1 = new ConcreteHandler1();

        // Building the chain
        handler1.setSuccessor(handler2);
        handler2.setSuccessor(handler3);

        // Starting the request chain
        handler1.handleRequest("request1");
        handler1.handleRequest("request2");
        handler1.handleRequest("request3");
   }
// Output:
// ConcreteHandler1 is handling the request
// ConcreteHandler2 is handling the request
// ConcreteHandler3 is handling the request
}
```

___


**Common Interview Questions:**

#### Q1. Explain the Strategy Pattern and how it works.

- A: The Strategy Pattern defines a family of algorithms, encapsulates each one, and allows them to be interchangeable. This pattern helps in selecting algorithms at runtime, promoting flexibility without altering the client code.

#### Q2. What are the advantages of using the Strategy Pattern?

- A:
- **Open/Closed Principle:** You can add new algorithms without modifying the existing context or client code.
- **Decoupling:** The client code does not need to know the details of the algorithm.
- **Flexibility:** Different strategies can be swapped at runtime.

#### Q3. How does the Strategy Pattern differ from the State Pattern?

- A: While the Strategy Pattern encapsulates interchangeable algorithms that are chosen based on the context, the State Pattern focuses on managing an object’s behavior when its internal state changes.

#### Q4. Provide a real-world example of the Strategy Pattern.

- A: In an online shopping system, different products may have varying shipping cost algorithms (free, fixed, percentage-based). The Strategy Pattern allows switching between these algorithms dynamically.

**Example Code for the Strategy Pattern:**

- **Scenario 1: Shipping Cost Calculator**
  - **Interface:** `ShippingCostCalculator` defines the common method `calculateShippingCost`().
  - **Concrete Strategies:**
    - `FreeShippingCostCalculator` for free shipping.
    - `FixedShippingCostCalculator` for a fixed cost.
    - `PercentageShippingCostCalculator` for percentage-based costs.
- Context: The ShippingCostContext uses a specific calculator strategy to calculate the total shipping cost dynamically.

```java
public interface ShippingCostCalculator {
    double calculateShippingCost(double totalPrice);
}
public class FreeShippingCostCalculator implements ShippingCostCalculator {
    @Override
    public double calculateShippingCost(double totalPrice) {
        return 0.0; // Free shipping for all products
    }
}

public class FixedShippingCostCalculator implements ShippingCostCalculator {
    private double fixedCost;

    public FixedShippingCostCalculator(double fixedCost) {
        this.fixedCost = fixedCost;
    }

    @Override
    public double calculateShippingCost(double totalPrice) {
        return fixedCost; // Fixed cost for all products
    }
}

public class PercentageShippingCostCalculator implements ShippingCostCalculator {
    private double percentage;

    public PercentageShippingCostCalculator(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double calculateShippingCost(double totalPrice) {
        return totalPrice * percentage; // Percentage of the total price
    }
}
public class ShippingCostContext {
    private ShippingCostCalculator calculator;

    public ShippingCostContext(ShippingCostCalculator calculator) {
        this.calculator = calculator;
    }

    public double calculateShippingCost(double totalPrice) {
        return calculator.calculateShippingCost(totalPrice);
    }
}
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List < Product > products = new ArrayList < > ();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Product product: products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public double getShippingCost(ShippingCostCalculator calculator) {
        double totalPrice = getTotalPrice();
        ShippingCostContext context = new ShippingCostContext(calculator);
        return context.calculateShippingCost(totalPrice);
    }
}
public class com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main {
    public static void main(String[] args) {
        // Create some products
        Product product1 = new Product("Product 1", 10.0);
        Product product2 = new Product("Product 2", 20.0);
        Product product3 = new Product("Product 3", 30.0);

        // Add products to the cart
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);

        // Calculate the total price and shipping cost
        double totalPrice = cart.getTotalPrice();
        double shippingCost = cart.getShippingCost(new PercentageShippingCostCalculator(0.1)); // 10% of the total price
        double totalCost = totalPrice + shippingCost;

        // Display the results
        System.out.println("Total Price: $" + totalPrice);
        System.out.println("Shipping Cost: $" + shippingCost);
        System.out.println("Total Cost: $" + totalCost);
    }
}
```

#### Example 2:

How to use the Strategy Pattern to calculate the best route on Google Maps using different settings:

First, let's create the interface `RouteCalculator` that defines the common method `calculateRoute`():

```java
public interface RouteCalculator {
    String calculateRoute(Location start, Location end);
}

//Next, let's create the concrete classes that implement this interface for each type of route calculation:
public class FastestRouteCalculator implements RouteCalculator {
    @Override
    public String calculateRoute(Location start, Location end) {
        // Calculate the fastest route using Google Maps API
        return "Fastest route from " + start + " to " + end;
    }
}

public class ShortestRouteCalculator implements RouteCalculator {
    @Override
    public String calculateRoute(Location start, Location end) {
        // Calculate the shortest route using Google Maps API
        return "Shortest route from " + start + " to " + end;
    }
}

public class ScenicRouteCalculator implements RouteCalculator {
    @Override
    public String calculateRoute(Location start, Location end) {
        // Calculate the scenic route using Google Maps API
        return "Scenic route from " + start + " to " + end;
    }
}

//Now, let's create the RouteCalculatorContext class that accepts a specific RouteCalculator and uses it to calculate the best route:
public class RouteCalculatorContext {
    private RouteCalculator calculator;

    public RouteCalculatorContext(RouteCalculator calculator) {
        this.calculator = calculator;
    }

    public String calculateRoute(Location start, Location end) {
        return calculator.calculateRoute(start, end);
    }
}

//Finally, let's create the GoogleMaps class that uses the RouteCalculatorContext to calculate the best route using different settings:
public class GoogleMaps {
    private RouteCalculatorContext context;

    public GoogleMaps(RouteCalculator calculator) {
        this.context = new RouteCalculatorContext(calculator);
    }

    public void setRouteCalculator(RouteCalculator calculator) {
        this.context = new RouteCalculatorContext(calculator);
    }

    public String calculateRoute(Location start, Location end) {
        return context.calculateRoute(start, end);
    }
}

//Here's how you can use these classes to calculate the best route on Google Maps using different settings:
public class com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main {
    public static void main(String[] args) {
        // Create a Google Maps instance with the default calculator (fastest route)
        GoogleMaps maps = new GoogleMaps(new FastestRouteCalculator());

        // Calculate the best route from New York to Boston using the default calculator
        Location start = new Location("New York");
        Location end = new Location("Boston");
        String route = maps.calculateRoute(start, end);
        System.out.println(route);

        // Change the calculator to the shortest route
        maps.setRouteCalculator(new ShortestRouteCalculator());

        // Calculate the best route from New York to Boston using the shortest route calculator
        route = maps.calculateRoute(start, end);
        System.out.println(route);

        // Change the calculator to the scenic route
        maps.setRouteCalculator(new ScenicRouteCalculator());

        // Calculate the best route from New York to Boston using the scenic route calculator
        route = maps.calculateRoute(start, end);
        System.out.println(route);
    }
}
```

#### Example 3:

Let's say we have a mobile application that needs to send push notifications to its users. The application needs to support multiple platforms such as iOS, Android, and Windows. Each platform has its own way of sending push notifications. We can use the Strategy Pattern to implement this functionality.

```java

// First, let's create the interface PushNotificationStrategy that defines the common method sendPushNotification():
public interface PushNotificationStrategy {
    void sendPushNotification(String message);
}

// Next, let's create the concrete classes that implement this interface for each platform:
public class IOSPushNotificationStrategy implements PushNotificationStrategy {
    @Override
    public void sendPushNotification(String message) {
        // Send push notification using iOS push notification service
        System.out.println("Sending push notification to iOS devices: " + message);
    }
}

public class AndroidPushNotificationStrategy implements PushNotificationStrategy {
    @Override
    public void sendPushNotification(String message) {
        // Send push notification using Android push notification service
        System.out.println("Sending push notification to Android devices: " + message);
    }
}

public class WindowsPushNotificationStrategy implements PushNotificationStrategy {
    @Override
    public void sendPushNotification(String message) {
        // Send push notification using Windows push notification service
        System.out.println("Sending push notification to Windows devices: " + message);
    }
}

// Now, let's create the PushNotificationContext class that accepts a specific
PushNotificationStrategy and uses it to send push notifications:
public class PushNotificationContext {
    private PushNotificationStrategy strategy;

    public PushNotificationContext(PushNotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PushNotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void sendPushNotification(String message) {
        strategy.sendPushNotification(message);
    }
}

// Finally, let's create the MobileApp class that uses the PushNotificationContext to send push notifications to its users on different platforms:
public class MobileApp {
    private PushNotificationContext context;

    public MobileApp(PushNotificationStrategy strategy) {
        this.context = new PushNotificationContext(strategy);
    }

    public void setPushNotificationStrategy(PushNotificationStrategy strategy) {
        this.context.setStrategy(strategy);
    }

    public void sendPushNotification(String message) {
        context.sendPushNotification(message);
    }
}

// Here's how you can use these classes to send push notifications to users on different platforms:
public class com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main {
    public static void main(String[] args) {
        // Create a mobile app instance with the default push notification strategy (iOS)
        MobileApp app = new MobileApp(new IOSPushNotificationStrategy());

        // Send push notification to all users using the default strategy (iOS)
        app.sendPushNotification("New update available!");

        // Change the push notification strategy to Android
        app.setPushNotificationStrategy(new AndroidPushNotificationStrategy());

        // Send push notification to all users using the Android strategy
        app.sendPushNotification("New update available!");

        // Change the push notification strategy to Windows
        app.setPushNotificationStrategy(new WindowsPushNotificationStrategy());

        // Send push notification to all users using the Windows strategy
        app.sendPushNotification("New update available!");
    }
}
```

#### Key Interview Takeaways:

1. **When to Use Strategy Pattern:**

- When you need to swap between multiple algorithms dynamically.
- When different algorithms share the same input-output structure but differ in implementation.

2. **Difference Between Strategy and Factory Patterns:**

- **Strategy** deals with interchangeable algorithms, while Factory patterns focus on object creation.

3. **How Strategy Enhances Flexibility:**

- Allows the introduction of new algorithms without altering existing system code.
- Supports runtime selection of the best suited algorithm for the current context.

#### Additional Practical Scenarios:

1. **Google Maps Route Calculation:**
   Strategies for the fastest, shortest, and scenic routes can be switched depending on user preferences.
2. **Push Notifications in Mobile Apps:**
   Different strategies for sending push notifications on iOS, Android, and Windows platforms.

## Observer Design Pattern

#### Overview:

- The **Observer Design Pattern defines a one-to-many relationship** between objects so that when the state of one object (subject) changes, all its dependent objects (observers) are notified and updated automatically.

- **Key Features:**

  - **Decoupling:** The pattern promotes loose coupling between the subject and observers.
  - **Event-driven:** Useful in event-driven systems where multiple components need to react to a state change or event.
  - **Scalability:** New observers can be added or removed without modifying the subject.

**Common Use Cases:**

> - **Event handling:** When an event occurs (e.g., button click), all registered observers are notified to take appropriate action.
> - **com.manish.LLD.PropertyPlatformLLD.Type1.User interface components:** Changes in UI components (e.g., checkbox state) can trigger actions in multiple observers.
> - **Stock market data:** Notifies observers (like graphs or alerts) whenever stock prices change.
> - **Weather monitoring:** Observers are notified of changes in weather data like temperature, humidity, or pressure, and can update displays accordingly.
> - **Database management systems:** When the state of a database changes (e.g., a record is updated), the registered observers can take actions like updating caches or notifying users.

### Key Benefits:

- `Decouples` subject and observers.
- **Highly flexible:** New observers can be added without changing the subject.
- **Scalable:** Useful in scenarios where multiple components need to react to state changes.
