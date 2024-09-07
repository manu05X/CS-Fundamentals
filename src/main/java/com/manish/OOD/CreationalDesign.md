## Creational Design Pattern:

In software engineering, Creational Design Patterns are a category of design patterns that focus on object creation mechanisms, trying to create objects in a manner suitable to the situation. The main goal of these patterns is to provide more flexibility and reusability to the code.

There are five types of Creational Design Patterns:

1. **Singleton Pattern:** This pattern ensures that a class has only one instance, and provides a global point of access to it. It is useful in situations where you need to limit the number of instances of a class that can be created.
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

In this example, we create a class called "Singleton" that has a private constructor, so it cannot be instantiated from outside the class. We also declare a private static variable "instance" of the same class, which is used to store the single instance of the class.

The getInstance() method is used to access the single instance of the class. If the instance has not yet been created, the method creates a new instance and returns it. Otherwise, it simply returns the existing instance.

The showMessage() method is just an example of a method that can be called on the Singleton instance. In a real-world example, this method would perform some useful operations in the context of the system.

To use the Singleton class, you can simply call the getInstance() method to get the single instance of the class, and then call any methods on that instance. Here's an example of how to use the Singleton class:

```Java
public class Main {
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
```

In this implementation, we have added the volatile keyword to the instance variable, which ensures that any changes made to the variable are immediately visible to all threads. We also use double-checked locking to ensure that only one instance of the Singleton class is created.
The getInstance() method first checks if the instance variable is null without acquiring the lock on the Singleton class. If it is null, the method acquires the lock and then checks again to see if the instance variable is still null. If it is, the method creates a new instance of the Singleton class.
By using double-checked locking and making the instance variable volatile, we can ensure that our Singleton class is thread-safe and can be safely used in a multi-threaded environment.

> Here are some scenarios where using the Singleton pattern can be helpful:
>
> - Database Connection
> - Configuration Management
> - Logging
> - Caching
> - Thread Pools
> - Device Drivers

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
