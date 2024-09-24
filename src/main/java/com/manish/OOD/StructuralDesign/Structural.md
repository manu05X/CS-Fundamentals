
# Structural Design Patterns - Interview Notes

- Structural design patterns are design patterns that deal with the `composition of classes` and `objects` to form **larger structure**s. 
- They help to **simplify the relationships** between classes and objects, and make the code more `flexible and reusable`.

Here are some commonly used structural design patterns:
- **Adapter Pattern**: This pattern allows two incompatible interfaces to work together by creating a bridge between them. It acts as a translator between two different interfaces and allows them to communicate with each other.
- **Bridge Pattern**: This pattern **separates an abstraction** from its implementation, allowing them to **evolve independently**. It involves creating two separate class hierarchies - one for the abstraction and one for the implementation - and then `using a bridge to connect` them.
- **Composite Pattern**: This pattern allows you to **treat a group of objects** as a `single object`. It involves creating a `tree-like structure` of objects, where each object can have one or `more child objects`. The composite object can then be treated as a single object, while still allowing access to the individual objects within it.
- **Decorator Pattern**: This pattern allows you to `add behavior to an object dynamically`, without affecting the behavior of other objects in the same class. It involves creating a wrapper around an object, which can then be used to add new functionality to the original object.
- **Facade Pattern**: This pattern provides a `simplified interface` to a complex system, making it easier to use. It involves creating a `single interface` that hides the complexity of a system, and provides a simple way to access its functionality.
- **Flyweight Pattern**: This pattern is used to `minimize memory` usage by **sharing data between similar objects**. It involves creating a pool of objects that can be reused, rather than creating new objects each time they are needed.
- **Proxy Pattern**: This pattern **provides a surrogate or placeholder** for another object, allowing you to control access to it. It involves creating an object that acts as a stand-in for another object, and can be used to provide additional functionality or control access to the original object.


## 1. **Adapter Pattern**
- **Purpose**: Bridges the gap between **two incompatible interfaces**, allowing them to `work together`.
- **Use Cases**:
    - Integrating legacy systems with modern applications.
    - Using third-party libraries with different interfaces.
- **Examples**:
    - Payment gateways (PayPal, Stripe, Square) with different APIs.
    - Calendar apps supporting Google, Apple, and Outlook calendars.
    - Adapting legacy database interfaces to a new application's interface.

**Key Points**:
- **Target**: This is the interface that the client `expects or requires`. The client `interacts with objects` through this **interface**. 
- **Adapter**: This is the class that **implements** the Target interface and `wraps an instance` of the Adaptee, making it `compatible with the client`. 
- **Adaptee**: This is the existing class or interface that needs to be adapted to work with the client. It's the class that the Adapter adapts.


```java
// Target Interface
public interface Square {
    void draw();
}
// Adaptee Class
public class Rectangle {
  public void drawRectangle() {
    System.out.println("Drawing a rectangle");
  }
}
// Adapter Class
public class RectangleAdapter implements Square {
  private Rectangle rectangle;

  public RectangleAdapter(Rectangle rectangle) {
    this.rectangle = rectangle;
  }

  @Override
  public void draw() {
    rectangle.drawRectangle();
  }
}
// Client Code
public class Client {
  public static void main(String[] args) {
    // Create an instance of Rectangle (Adaptee)
    Rectangle rectangle = new Rectangle();

    // Create an adapter to adapt Rectangle to Square interface
    Square squareAdapter = new RectangleAdapter(rectangle);

    // Call draw method on the Square interface
    squareAdapter.draw();
  }
}
```

### Use Case: Legacy System Integration
A common use case for the Adapter pattern is when integrating new code with existing legacy systems or third-party libraries that have incompatible interfaces. For example:
- **Database Adapter**: You have an application that interacts with a specific database using a proprietary interface. If you want to switch to a new database system with a different interface, you can use the Adapter pattern to create an adapter that translates the new database interface to the existing one used by your application.
- **API Integration**: You're working with an external API that has a different interface than what your application expects. Instead of modifying your application's code to directly interact with the API, you can create an adapter that translates between the API's interface and the interface expected by your application.

### Here's an example scenario when the adapter pattern can be useful:
- **Database Adapter**: Suppose you have a legacy database that has an incompatible interface with your new application. You can create an adapter that translates the interface of the legacy database to a common interface that your application can use. This allows you to reuse the existing data in your legacy database without having to modify your application.
- **File Format Adapter**: Suppose you have an application that can read and write data in a specific file format, but you need to add support for a new file format. You can create an adapter that translates the new file format to the common interface used by your application. This allows you to add support for the new file format without having to modify your existing code.
- **Networking Adapter**: Suppose you have an application that needs to communicate with a web service that has an incompatible interface. You can create an adapter that translates the web service interface to a common interface used by your application. This allows your application to communicate with the web service without having to modify your existing code.
- **GUI Widget Adapter**: Suppose you have a GUI library that has a specific set of widgets, but you need to use a widget from another library that has an incompatible interface. You can create an adapter that translates the widget interface to a common interface used by your GUI library. This allows you to use the widget from the other library without having to modify your existing code.
- **Legacy Adapter**: Suppose you have a client application that needs to communicate with a legacy system, but the legacy system uses a different interface than the client application. Instead of modifying the client application to work with the legacy system's interface, you can use the adapter pattern to create an adapter that translates the requests and responses between the two interfaces.



---

## 2. **Bridge Pattern**
- **Purpose**: Separates abstraction from implementation, allowing them to evolve independently.
- **Use Cases**:
    - When you need to decouple a class so that both the class and what it does can vary independently.
    - Complex UI components with multiple rendering options.

**Key Points**:
- Two hierarchies: one for the abstraction and one for implementation.
- Useful when systems require future extensions without disturbing current code.

---

## 3. **Composite Pattern**
- The Composite pattern is a structural design pattern that `allows you to compose objects into tree structures` to represent part-whole hierarchies. This pattern treats individual objects and compositions of objects uniformly. 
- By implementing the Composite pattern, you can manipulate individual objects and compositions through a `common interface`, simplifying client code.

**Purpose**: Treats individual objects and compositions of objects uniformly.

**Use Cases:**
- Hierarchical data structures like trees (e.g., file systems).
- GUI components where a composite element (like a panel) contains other components.

**Key Points**:
- Components can be either individual objects or composites (groups).
- Simplifies client code as it interacts with components uniformly.
- Component: This is the base interface or abstract class for all objects in the composition. It defines the common operations that can be performed on both simple and complex objects.
- Leaf: A Leaf is a basic, indivisible object in the composition. It implements the Component interface and provides its own behavior.
- Composite: A Composite is an object that has children. It implements the Component interface and defines behavior for the components it contains, typically by delegating operations to its child components.

**Structure**
- **Component**: Declares the interface for objects in the composition and can include methods for managing child components.
- **Leaf**: Represents the end objects of a composition. A leaf has no children.
- **Composite**: Defines behavior for components that **have children** and implements methods to manage these children (e.g., adding, removing, and accessing children).

**When to Use the Composite Pattern?**
- **Hierarchical Structures**: When you have a part-whole hierarchy of objects and want to be able to treat individual objects and composites uniformly. This is common in scenarios like graphics (where shapes can be simple or composed of other shapes), file systems (where files and directories are treated uniformly), and organizational charts.
- **Recursive Structures**: When your application has recursive structures that can be processed in a similar manner. For example, a tree structure where nodes can contain other nodes, or a menu system with sub-menus.
- **Simplify Client Code**: When you want to simplify client code by allowing it to treat both individual objects and composites through a common interface without worrying about their differences.

```java
// Component
interface FileSystemComponent {
    void showDetails();
}

// Leaf
class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}

// Composite
class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
            component.showDetails();
        }
    }
}

// Client code
public class CompositePatternDemo {
    public static void main(String[] args) {
        FileSystemComponent file1 = new File("file1.txt");
        FileSystemComponent file2 = new File("file2.txt");

        Directory dir1 = new Directory("dir1");
        Directory dir2 = new Directory("dir2");

        dir1.addComponent(file1);
        dir2.addComponent(file2);
        dir1.addComponent(dir2);

        dir1.showDetails();
      
        // Directory: dir1
    	// File: file1.txt
        // Directory: dir2
        // File: file2.txt
    }
}
```
**Benefits**
- **Simplifies client code**: Clients can treat individual objects and compositions **uniformly**.
- **Flexible hierarchy**: You can easily **add new kinds of components**.
- **Easier to manage**: Centralized management of composite structures makes it **easier to manage complex hierarchies**.

**Drawbacks**
- **Overhead**: May introduce complexity by forcing you to manage a tree structure.
- **Inappropriate for flat structures**: If the hierarchy isn't deep, using a composite might add unnecessary complexity.



---

## 4. **Decorator Pattern**
The Decorator pattern is a structural design pattern that **allows behavior to be added to individual objects**, dynamically, without affecting the behavior of other objects from the same class. It involves creating a set of decorator classes that are used to wrap concrete components, adding new functionality to them without altering their structure.
- **Purpose**: Adds new responsibilities to objects dynamically without altering their structure. Composition-based design where each decorator wraps the original object.

- **Use Cases**:
    - Adding functionalities like logging, security, caching.
    - Dynamic formatting of text (e.g., bold, italic in a text editor).


**Key Points**:
- **Purpose**: The Decorator pattern is used to **add or modify** behavior of `individual objects at runtime`, without modifying their structure.
- **Flexibility**: It provides more flexibility than static inheritance because decorators can be added or removed dynamically.
- **Composition**: It promotes composition over inheritance, allowing you to compose objects with different behaviors at runtime.
- **Single Responsibility Principle**: Each decorator class is responsible for adding a specific behavior, promoting the single responsibility principle.
- Unlike inheritance, this pattern is dynamic and flexible.
- Helps avoid feature-heavy base classes.


### Here are some common scenarios where the decorator pattern can be used:
- **Text formatting**: As explained earlier, the decorator pattern can be used to add different font styles to a text editor dynamically at runtime.
- **Input/output stream processing**: The decorator pattern can be used to add functionality to an input or output stream, such as encryption, compression, or buffering.
- **GUI components**: The decorator pattern can be used to add new features or behavior to GUI components, such as buttons or text fields, without modifying their original implementation.
- **Logging**: The decorator pattern can be used to add logging functionality to an object, without changing its original behavior.
- **Caching**: The decorator pattern can be used to add caching functionality to an object, without modifying its original implementation.
- **Security**: The decorator pattern can be used to add security features to an object, such as authentication or authorization, without changing its original behavior.



####  How does the Decorator pattern differ from inheritance?
The Decorator pattern and inheritance are two different mechanisms used in object-oriented programming for extending the behavior of classes, but they serve different purposes and have different implications.

**Inheritance**
- Inheritance is a mechanism in object-oriented programming that allows a class (subclass) to inherit properties and behavior from another class (superclass). Subclasses can extend the functionality of their superclass by adding new methods or overriding existing methods.

**Key Points:**
- **Purpose**: Inheritance is used to create a hierarchy of classes with shared behavior and attributes, promoting code reuse.
- **Static**: Inheritance is static and determined at compile-time. Once a class hierarchy is defined, it cannot be changed at runtime.
- **Coupling**: Inheritance creates a strong coupling between the superclass and its subclasses. Changes in the superclass can affect all subclasses.
- **Single Inheritance**: Most object-oriented languages support single inheritance, meaning a subclass can inherit from only one superclass.

**Differences**
 - **Flexibility**: The Decorator pattern provides more flexibility than inheritance because decorators can be added or removed dynamically at runtime, whereas inheritance is static and determined at compile-time.
 - **Single Responsibility Principle**: The Decorator pattern promotes the single responsibility principle by allowing individual decorators to add specific behavior, whereas inheritance can lead to classes with multiple responsibilities if subclasses override multiple methods from their superclass.
 - **Coupling**: Inheritance creates a strong coupling between the superclass and its subclasses, while the Decorator pattern promotes loose coupling between components, as decorators are independent of the concrete components they decorate.
 - **Composition vs. Inheritance**: The Decorator pattern promotes composition over inheritance. Instead of creating a complex class hierarchy through inheritance, you can compose objects with different behaviors dynamically using decorators.



---

## 5. **Facade Pattern**
- **Purpose**: Simplifies the interface to a complex system by providing a unified interface.
- **Use Cases**:
    - Simplifying interactions with a library or framework.
    - API gateways that hide the complexity of backend services.

**Key Points**:
- Provides a **single point of access** to a system.
- Does not hide subsystem classes but simplifies access for clients.
- **Complexity Management**: Facade simplifies interactions with a complex system by providing a single entry point and hiding the complexities of the underlying subsystems. 
- **Abstraction Layer**: It provides an abstraction layer that decouples the client code from the detailed implementation of the subsystems, allowing for easier maintenance and changes. 
- **Encapsulation**: Facade encapsulates the subsystems, preventing clients from directly interacting with them, which promotes loose coupling and reduces dependency between the client and the subsystems. 
- **Consistency**: It ensures consistency in how clients interact with the subsystems by providing a uniform interface, regardless of the complexity of the underlying subsystems.


```java
// Complex Home Theater System
public class DVDPlayer {
    public void on() { /* Turn on DVD player */ }
    public void play(String movie) { /* Play movie */ }
    // Other methods...
}

public class Amplifier {
    public void on() { /* Turn on amplifier */ }
    public void setSurroundSound() { /* Set surround sound */ }
    // Other methods...
}

public class Projector {
    public void on() { /* Turn on projector */ }
    public void setInput(String input) { /* Set input source */ }
    // Other methods...
}

// Other subsystem classes...

// Facade for Home Theater System
public class HomeTheaterFacade {
  private DVDPlayer dvdPlayer;
  private Amplifier amplifier;
  private Projector projector;

  public HomeTheaterFacade(DVDPlayer dvdPlayer, Amplifier amplifier, Projector projector) {
    this.dvdPlayer = dvdPlayer;
    this.amplifier = amplifier;
    this.projector = projector;
  }

  public void watchMovie(String movie) {
    dvdPlayer.on();
    amplifier.on();
    amplifier.setSurroundSound();
    projector.on();
    projector.setInput("DVD");
    dvdPlayer.play(movie);
  }

  // Other simplified methods...
}

// Client Code
public class Client {
  public static void main(String[] args) {
    // Create subsystem objects
    DVDPlayer dvdPlayer = new DVDPlayer();
    Amplifier amplifier = new Amplifier();
    Projector projector = new Projector();

    // Create facade for home theater system
    HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, amplifier, projector);

    // Use the facade to watch a movie
    homeTheater.watchMovie("Inception");
  }
}
```

In this example, the Facade pattern provides a simplified interface (HomeTheaterFacade) for controlling the entire home theater system, hiding the complexities of individual subsystems (DVDPlayer, Amplifier, Projector). Clients can interact with the facade to perform common tasks, such as watching a movie, without needing to know the details of how each subsystem works. This simplifies client code and promotes encapsulation and abstraction.

#### Example 2 :
For example, imagine you are building a music player application that can play music from different sources such as a CD, MP3 player, and streaming services. Each source has its own set of classes and interfaces, and the client code would need to interact with each of them differently. By using the Facade Design Pattern, you could create a new MusicPlayerFacade class that acts as a simplified interface to the different music sources, shielding the client from the complexity of interacting with each source separately.


```java
// Complex subsystem interface
interface MusicSource {
    void play();   // Method to play music
    void pause();  // Method to pause music
    void stop();   // Method to stop music
}

// Concrete subsystems
class CdPlayer implements MusicSource {
    // Plays the CD
    public void play() {
        System.out.println("Playing CD...");
    }

    // Pauses the CD
    public void pause() {
        System.out.println("Pausing CD...");
    }

    // Stops the CD
    public void stop() {
        System.out.println("Stopping CD...");
    }
}

class Mp3Player implements MusicSource {
    // Plays MP3
    public void play() {
        System.out.println("Playing MP3...");
    }

    // Pauses MP3
    public void pause() {
        System.out.println("Pausing MP3...");
    }

    // Stops MP3
    public void stop() {
        System.out.println("Stopping MP3...");
    }
}

class StreamingService implements MusicSource {
    // Plays streaming music
    public void play() {
        System.out.println("Playing streaming music...");
    }

    // Pauses streaming music
    public void pause() {
        System.out.println("Pausing streaming music...");
    }

    // Stops streaming music
    public void stop() {
        System.out.println("Stopping streaming music...");
    }
}

// Facade class
class MusicPlayerFacade {
    private MusicSource cdPlayer;
    private MusicSource mp3Player;
    private MusicSource streamingService;

    // Constructor initializing the subsystems
    public MusicPlayerFacade() {
        this.cdPlayer = new CdPlayer();
        this.mp3Player = new Mp3Player();
        this.streamingService = new StreamingService();
    }

    // Simplified method to play CD using the facade
    public void playCd() {
        cdPlayer.play();
    }

    // Simplified method to pause CD using the facade
    public void pauseCd() {
        cdPlayer.pause();
    }

    // Simplified method to stop CD using the facade
    public void stopCd() {
        cdPlayer.stop();
    }

    // Simplified method to play MP3 using the facade
    public void playMp3() {
        mp3Player.play();
    }

    // Simplified method to pause MP3 using the facade
    public void pauseMp3() {
        mp3Player.pause();
    }

    // Simplified method to stop MP3 using the facade
    public void stopMp3() {
        mp3Player.stop();
    }

    // Simplified method to play streaming music using the facade
    public void playStreamingMusic() {
        streamingService.play();
    }

    // Simplified method to pause streaming music using the facade
    public void pauseStreamingMusic() {
        streamingService.pause();
    }

    // Simplified method to stop streaming music using the facade
    public void stopStreamingMusic() {
        streamingService.stop();
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        // Creating facade for music player system
        MusicPlayerFacade musicPlayer = new MusicPlayerFacade();

        // Using the facade to play CD
        musicPlayer.playCd();

        // Using the facade to play MP3
        musicPlayer.playMp3();

        // Using the facade to play streaming music
        musicPlayer.playStreamingMusic();
    }
}

```


---

## 6. **Flyweight Pattern**
- **Purpose**: Minimizes memory usage by sharing data between similar objects.
- **Use Cases**:
    - Systems with a large number of similar objects, like text editors storing character data.
    - Game development (e.g., reusing objects for enemy NPCs).

**Key Points**:
- Focuses on sharing and reducing redundancy, especially with immutable data.
- Externalizes the state to distinguish between flyweight objects.

---

## 7. **Proxy Pattern**
- **Purpose**: Provides a placeholder or surrogate for another object, often used for access control, lazy loading, or logging.
- **Use Cases**:
    - Remote proxies in distributed systems (e.g., RMI).
    - Virtual proxies for expensive-to-create objects.
    - Security proxies to control access to sensitive objects.

**Key Points**:
- Proxies control access to objects by interposing between client and target object.
- Can be used for resource management, security, and lazy initialization.


#### What are the types of Proxies in the Proxy pattern?
The Proxy pattern is a structural design pattern that provides a surrogate or placeholder for another object to control access to it. There are several types of proxies, each serving a different purpose. Here are the main types of proxies:

1. **Virtual Proxy:**
- **Purpose**: `Controls access` to a resource that is `expensive to create`.
- **Usage**: When you want to `delay the creation` and initialization of an `expensive object until it's actually needed`.
- **Example**: A virtual proxy might represent a `large image file` and `only load` the image from disk when it's `actually displayed on the screen.`

2. **Remote Proxy:**
- **Purpose**: Represents an object that exists in a different address space (typically on a different machine).
- **Usage**: Used in distributed systems to hide the fact that an object resides in a different location, and to handle the complexities of communication between the client and the remote object.
- **Example**: In a client-server application, a remote proxy could represent a service running on a remote server.

3. **Protection (or Access) Proxy:**
- Purpose: Controls access to the real object by checking permissions or other access criteria.
- Usage: When you need to add an additional level of security, ensuring that only authorized clients can access the sensitive operations of an object.
- Example: A protection proxy might be used to manage access to methods in a banking system, ensuring that only authenticated users can perform transactions.

4. **Caching Proxy:**
- Purpose: Provides temporary storage of results to avoid redundant operations and improve performance.
- Usage: When you have operations that produce the same results for the same inputs, and you want to cache these results to reduce computation time or resource usage.
- Example: A caching proxy might be used to store the results of a complex database query.

5. **Smart Proxy:**
- Purpose: Adds additional behavior when an object is accessed, such as reference counting or lazy initialization.
- Usage: When you want to perform extra actions whenever an object is accessed.
- Example: A smart proxy could manage the lifecycle of an object, ensuring that it is properly initialized and cleaned up, or it might track the number of active references to an object to implement automatic resource management.


#### Example of a Virtual Proxy : 
Here's a simple example in Java to illustrate a virtual proxy:
```java
// Subject
interface Image {
    void display();
}

// RealSubject
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}

// Proxy
class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Client code
public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_image.jpg");
        // Image will be loaded from disk
        image.display();
        // Image will not be loaded from disk, as it is already cached
        image.display();
      
      // Output:
      // Loading test_image.jpg
      // Displaying test_image.jpg
      // Displaying test_image.jpg
    }
}
```

**Summary**
- **Virtual Proxy**: Delays object creation and initialization.
- **Remote Proxy**: Interfaces with objects in different address spaces.
- **Protection Proxy**: Manages access permissions to an object.
- **Caching Proxy**: Stores results of expensive operations for reuse.
- **Smart Proxy**: Adds extra functionality when accessing an object.


---

## Example-Driven Understanding (Adapter and Decorator)
- **Adapter Pattern (Real-World Example)**:
    - **Payment Gateway Integration**: Adapter allows different payment APIs (PayPal, Stripe) to work through a common interface without modifying the core application.

- **Decorator Pattern (Real-World Example)**:
    - **Text Formatting**: Allows dynamic addition of behavior (bold, italic) to a base text object at runtime without modifying the text class itself.

---

# Facade Design Pattern

The **Facade Design Pattern** is a structural design pattern that simplifies the interaction between a client and a complex system of classes, interfaces, and objects by providing a unified and simplified interface.

**Purpose:**
- It hides the complexity of subsystems by providing a single point of interaction.
- Clients don’t need to be aware of the underlying implementation and interactions among the subsystems.

**Key Characteristics:**
- **Simplified Interface:** The pattern introduces a facade class, which serves as a front-facing interface to the client while managing the interactions with the complex system in the background.
- **Client Independence:** The client interacts with the facade and is decoupled from the subsystem's intricate details, making the system easier to use and maintain.
- **Subsystem Flexibility:** Changes to the underlying system are hidden from the client, making the system easier to evolve without impacting the client code.

**When to Use:**
- When a system is complex and consists of multiple subsystems or APIs.
- To provide a simple interface for the client to interact with complex subsystems.
- When you want to decouple a client from the complex internal components of a system.
- To improve code readability and reduce dependencies.

### Example Scenarios:

1. **Music Player Application:**
    - A facade `MusicPlayerFacade` can provide a unified interface for interacting with different music sources like CDs, MP3 players, and streaming services. The client only interacts with the facade to play, pause, or stop music, without needing to know the details of each music source.

2. **Computer Startup:**
    - A `Computer` facade can provide a simplified `startComputer()` method, which internally manages the operations of the CPU, Memory, and HardDrive subsystems. This makes it easier for the client to start the computer without dealing with subsystem complexities.

---

# Flyweight Design Pattern

The **Flyweight Design Pattern** is a structural design pattern that optimizes memory usage by sharing objects that are expensive to create. It helps in minimizing resource usage when dealing with a large number of similar objects.

**Purpose:**
- To reduce memory consumption by reusing shared objects, especially when a large number of similar objects need to be created.
- The Flyweight pattern separates the object's intrinsic state (which is shared) from its extrinsic state (which varies and is unique).

**Key Characteristics:**
- **Intrinsic State:** This is the shared part of the object that remains constant across different instances. Flyweight objects contain this intrinsic state.
- **Extrinsic State:** This is the part of the object that varies and is passed to the object externally when needed.
- **Object Pooling:** The Flyweight pattern often uses a factory or object pool to manage and reuse shared objects, preventing the unnecessary creation of duplicate objects.

**When to Use:**
- When you have a large number of objects that share common properties.
- When the cost of creating and managing individual objects is high in terms of memory or performance.
- In scenarios where a system has many similar objects, and reducing memory overhead is important.

### Example Scenarios:

1. **Text Rendering:**
    - In a text editor, each character in a document can be represented as a Flyweight object. The intrinsic state (such as the character shape) is shared, while the extrinsic state (such as the position or formatting) is unique for each character instance.

2. **Forest in a Game:**
    - In a video game rendering a forest, you can use the Flyweight pattern to reuse tree objects with the same texture or type (e.g., oak tree). The position, size, and other attributes specific to each tree are extrinsic, while the shared texture and tree type form the intrinsic state.

By applying the Flyweight pattern, the game can reduce memory usage by reusing objects for trees that share similar properties, improving performance especially when dealing with thousands of trees.

---

## Summary

- **Facade Pattern**: Simplifies complex systems by providing a unified interface that hides the intricacies of interacting with multiple subsystems. It enhances usability and maintainability.

- **Flyweight Pattern**: Optimizes memory usage by sharing common object data (intrinsic state) across many instances and only storing unique details (extrinsic state) separately. It is highly useful when dealing with a large number of similar objects, as it reduces memory consumption and improves performance.
  """

