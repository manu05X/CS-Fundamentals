
# Structural Design Patterns - Interview Notes

## 1. **Adapter Pattern**
- **Purpose**: Bridges the gap between two incompatible interfaces, allowing them to work together.
- **Use Cases**:
    - Integrating legacy systems with modern applications.
    - Using third-party libraries with different interfaces.
- **Examples**:
    - Payment gateways (PayPal, Stripe, Square) with different APIs.
    - Calendar apps supporting Google, Apple, and Outlook calendars.
    - Adapting legacy database interfaces to a new application's interface.

**Key Points**:
- Involves an adapter class implementing the target interface and using the adaptee's methods.
- Flexible and reusable across different systems.

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
- **Purpose**: Treats individual objects and compositions of objects uniformly.
- **Use Cases**:
    - Hierarchical data structures like trees (e.g., file systems).
    - GUI components where a composite element (like a panel) contains other components.

**Key Points**:
- Components can be either individual objects or composites (groups).
- Simplifies client code as it interacts with components uniformly.

---

## 4. **Decorator Pattern**
- **Purpose**: Adds new responsibilities to objects dynamically without altering their structure.
- **Use Cases**:
    - Adding functionalities like logging, security, caching.
    - Dynamic formatting of text (e.g., bold, italic in a text editor).

**Key Points**:
- Composition-based design where each decorator wraps the original object.
- Unlike inheritance, this pattern is dynamic and flexible.
- Helps avoid feature-heavy base classes.

---

## 5. **Facade Pattern**
- **Purpose**: Simplifies the interface to a complex system by providing a unified interface.
- **Use Cases**:
    - Simplifying interactions with a library or framework.
    - API gateways that hide the complexity of backend services.

**Key Points**:
- Provides a single point of access to a system.
- Does not hide subsystem classes but simplifies access for clients.

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

