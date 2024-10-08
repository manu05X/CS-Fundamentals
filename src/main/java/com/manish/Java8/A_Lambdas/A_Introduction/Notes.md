## What is a lambda expression?
- In object-oriented programming, objects and classes are the main entities. If we create a function then it should exist within a class. A function has no meaning outside the scope of the class object.

- In functional programming, functions can exist outside the scope of an object. We can assign them to a reference variable and we can also pass them to other methods as a parameter.

- A lambda expression is just an anonymous function, i.e., a function with no name and that is not bound to an identifier. We can pass it to other methods as parameters, therefore, using the power of functional programming in Java.

## How to write a lambda expression
It might be difficult to understand what lambda is and how to write a lambda without looking at an example. So, let’s look at an example first, and then we will revisit what we just read.

In the below example, we have a functional interface called Greeting. There are two classes HindiGreeting and EnglishGreeting that implement this interface.

```java
@FunctionalInterface
public interface Greeting {
    void greet();
}

public class HindiGreeting implements Greeting {

    // Overriding the greet() method from Greeting interface.
    @Override
    public void greet() {
        System.out.println("Namaste");
    }
}

public class EnglishGreeting implements Greeting {

    // Overriding the greet() method from Greeting interface.
    @Override
    public void greet() {
        System.out.println("Good Morning");
    }
}
```
Here, we have another class called WellWisher. This class has a method called wish(Greeting greeting) which takes Greeting as a parameter and based on the type of object passed, prints the greeting.
> SEE EXAMPLE1 CODE 

When we run the WellWisher class, we get the below output:
```java
Namaste
Good Morning
```

This is a classic object-oriented programming example. Now, what if we want our WellWisher class to greet in all the languages available?

Do we need to create a class for each language, e.g., SpanishGreeting, FrenchGreeting, etc?

Isn’t it possible that we don’t create any class and just send a function to the wish(Greeting greeting) method?

Our wish(Greeting greeting) method will directly execute the function that is provided to it and print the greeting.

This is possible through anonymous classes. We will quickly see how this can be done through an anonymous class, and then jump straight back into lambdas.

In the below example, we will change the WellWisher class to use an anonymous class.

```java
public class WellWisher {

    public static void wish(Greeting greeting) {
        greeting.greet();
    }

    public static void main(String args[]) {
        // We are passing an anonymous class object to the wish method.
        wish(new Greeting() {
            @Override
            public void greet() {
                System.out.println("Namaste");
            }
        });
    }
}

@FunctionalInterface
public interface Greeting {
    void greet();
}
```

In the above example, we don’t need to create a class for each language. We can use an anonymous class, and that does the trick for us in the example above. However, don’t you think that this code is still cumbersome? Although the class is anonymous, we are still creating a class.

To make our code less cumbersome, let’s remove all the unnecessary code step-by-step and create our first lambda expression.

**Step 1 ->** The compiler knows that the wish(Greeting greeting) method takes in a parameter of type Greeting. So, we don’t need to specifically create an anonymous class of type greeting.
```java
public class WellWisher {

    public static void wish(Greeting greeting) {
        greeting.greet();
    }

    public static void main(String args[]) {
        wish(
            public void greet() {
                System.out.println("Namaste");
            }
            );
    }
}
```
**Step 2 ->** We know that the Greeting interface has only one method. So, we don’t need to provide the method name. We are only concerned with the method body.
```java
public class WellWisher {

    public static void wish(Greeting greeting) {
        greeting.greet();
    }

    public static void main(String args[]) {
        wish(

            public void () {
                System.out.println("Namaste");
            }
            );
    }
}
```
**Step 3 ->** The compiler can understand that the body does not return anything. So, mentioning the return type is redundant. We can also remove the public declaration.
```java
public class WellWisher {

    public static void wish(Greeting greeting) {
        greeting.greet();
    }

    public static void main(String args[]) {
        wish(
                () -> {
                    System.out.println("Namaste");
                }
        );
    }
}
```
>Please note that we add a -> between the empty brackets and the method body. This is how a lambda expression is declared.

There still is one more improvement we can make. Since the method body contains only a single line, the curly braces are also unnecessary.
```java
public class WellWisher {

    public static void wish(Greeting greeting) {
        greeting.greet();
    }

    // Passing a lambda expression to wish method.
    public static void main(String args[]) {
        wish( () -> System.out.println("Namaste") );
    }
}

@FunctionalInterface
public interface Greeting {
    void greet();
}
```

## Java Comparator Using Lambda
If you’ve been working with Java for some time, then you’ve probably encountered a scenario where you need to sort the elements in a collection.

If your collection contains a wrapper class object then the sorting is very easy. Since all the wrapper classes implement the Comparable interface, you can directly use Collections.sort() to sort your collection.

However, if your collection contains a custom class object then you need to provide the logic to sort your object. In this lesson, we will look at an example in which we will sort a list of Person class objects using a comparator. Then, we will write a program to do the same task using lambdas.

Comparator example using anonymous class
First, we will create a Person class.
```java
public class Person {

    private String name;
    private int age;
    private String country;

    public Person(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }
}
```
Now, we have a PersonService class. It has a getPersons(List<Person> persons) method. It takes a list of person objects as input and returns a list of person object in sorted order.

In this method, we are creating an anonymous comparator, which sorts the Person objects on the basis of name.
```java
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonService {

    public static List<Person> getPersons(List<Person> persons){
        // Created an anonymous Comparator, which sorts the Person object on the basis of Person name.
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });
        return persons;
    }
}
```
Finally, we have a PersonMain class that runs our logic.
```java
import java.util.ArrayList;
import java.util.List;

public class PersonMain {

    public static void main(String args[]){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John" , 23 , "USA"));
        persons.add(new Person("Carl" , 23 , "Australia"));
        persons.add(new Person("Amit" , 23 , "India"));
        persons.add(new Person("Vikram" , 23 , "Bhutan"));
        persons.add(new Person("Kane" , 23 , "Brazil"));
        // Calling getPerson() method which will return the List of Person in sorted order.
        List<Person> sortedPersons = PersonService.getPersons(persons);

        System.out.println("Persons after sorting");
        // Printing the name of each person.
        for(Person person : sortedPersons){
            System.out.println("Person Name : " + person.getName());
        }
    }
}
```
If you look at the Comparator interface, you notice that it is a functional interface. It has only one abstract method called compare(). This makes it a perfect candidate to be used in lambdas.

## Comparator example using a lambda expression
Now, let’s see how we can write the same logic using a lambda expression. As discussed in the previous lesson, when writing lambdas, we only need to consider the input parameters and the method body.

Below is the signature of the `compare()` method.
> int compare(T o1, T o2)

It takes two parameters as input and returns an int.

Let’s start constructing the lambda expression:

The structure of lambda will be like:

>(p1, p2) -> {};

Here, p1 and p2 are the two input parameters. We can name them anything.

Now, we will add the body.

>(p1, p2) -> p1.getName().compareTo(p2.getName());

So, this is the lambda expression for sorting the Person objects based on name.

You can see how easy and concise it is to write code with lambdas instead of using anonymous classes.

```java
public class Person {

    private String name;
    private int age;
    private String country;

    public Person(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }
}

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonService {

    public static List<Person> getPersons(List<Person> persons) {
        // Instead of creating an anonymous class, we have provided a lambda expression.
        Collections.sort(persons, (p1, p2) -> p1.getName().compareTo(p2.getName()));
        return persons;
    }
}

import java.util.ArrayList;
import java.util.List;

public class PersonMain {

    public static void main(String args[]){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John" , 23 , "USA"));
        persons.add(new Person("Carl" , 23 , "Australia"));
        persons.add(new Person("Amit" , 23 , "India"));
        persons.add(new Person("Vikram" , 23 , "Bhutan"));
        persons.add(new Person("Kane" , 23 , "Brazil"));
        // Calling getPerson() method which will return the List of Person in sorted order.
        List<Person> sortedPersons = PersonService.getPersons(persons);

        System.out.println("Persons after sorting");
        for(Person person : sortedPersons){
            System.out.println("Person Name : " + person.getName());
        }
    }
}
```