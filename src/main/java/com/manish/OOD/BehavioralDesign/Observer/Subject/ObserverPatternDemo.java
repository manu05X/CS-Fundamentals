package com.manish.OOD.BehavioralDesign.Observer.Subject;// Step 1: Define the Subject Interface

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

/*
Explanation

1. Subject Interface: Subject interface declares methods for attaching, detaching, and notifying observers.

2. ConcreteSubject Class: This class implements Subject and maintains a list of observers. It updates the observers whenever its state changes.

3. Observer Interface: Observer interface declares the update method that observers must implement.

4. ConcreteObserver Class: This class implements Observer and defines the update method to perform actions when notified by the subject.

5. Client Code: Demonstrates creating a subject and multiple observers, changing the subject's state, and observing the notification process.
 */