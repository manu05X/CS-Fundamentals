Important Features of ArrayList in Java
---
Link : https://www.geeksforgeeks.org/arraylist-in-java/?ref=ml_lbp

- ArrayList inherits AbstractList class and implements the List interface.
- ArrayList is initialized by size. However, the size is increased automatically if the collection grows or shrinks if the objects are removed from the collection.
- Java ArrayList allows us to randomly access the list.
- ArrayList can not be used for primitive types, like int, char, etc. We need a wrapper class for such cases.
- ArrayList in Java can be seen as a vector in C++.
- ArrayList is not Synchronized. Its equivalent synchronized class in Java is Vector.


## Using Iterator
The iterator() method in ArrayList returns an Iterator type object. The Iterator interface declares the below methods that help with iterating an ArrayList.

- hasNext() — This method returns true if there are more elements in the list; otherwise, it returns false.

- next() — This method returns the next element in the list. Before calling next(), we should always call hasNext() to verify that there is an element; otherwise, NoSuchElementException will be thrown.

- remove() — This method removes the last element returned by the iterator. It can be called only once per call to the next().

- forEachRemaining(Consumer<? super E> action) — This method was introduced in Java 8. It performs the given action for each remaining element until all elements have been processed or the action throws an exception. This method’s benefit is that we do not need to check if there is a next element every time.

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {

	public static void main(String args[]) {
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(10);

		Iterator<Integer> itr = list.iterator();

		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

		// Iterating using forEachRemaining() method
		System.out.println("Iterating using forEachRemaining() method");
		Iterator<Integer> newItr = list.iterator();
		newItr.forEachRemaining(element -> System.out.println(element));
	}
}
```

>If an element is added to the ArrayList after the iterator is created then also ConcurrentModificationException will be thrown.

 ```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ArrayListDemo {

	public static void main(String args[]) {
		List<Integer> list = new ArrayList<>();
		list.add(34);
		list.add(45);

		Iterator<Integer> itr = list.iterator();
		list.add(54);

		while(itr.hasNext()) {
			System.out.println(itr.next());	
		}
	}
}
```


## How to write implementation of the `compareTo()` method
Let’s say you have a custom class, and you need to write the implementation of the `compareTo()` method.

The first step will be to select the fields within that class where you need to sort the objects. For example, if you have a `Vehicle` class then you would like to sort it on the basis of the year it was sold.

Once you have decided the field where the sorting will be done, then the second step will be to write the implementation of the `compareTo(T o)` method. The `compareTo(T o)` method takes only one object as an input. The comparison is made with the calling object. Let’s say we have two `Vehicle` class objects:

>- Vehicle v1 = new Vehicle();
>- Vehicle v2 = new Vehicle();


Then `v1.compareTo(v2)` should return:

- -1 if the production year of v1 is less than the production year of v2
- 1 if the production year of v1 is greater than the production year of v2
- 0 if the production year of v1 is equal to the production year of v2

If we need to sort the Vehicle class on the basis of the year it was made, the logic will look as below:

```java
	public class Vehicle implements Comparable<Vehicle> {

	String brand;
	Integer makeYear;
	
	public Vehicle(String brand, Integer makeYear) {
		super();
		this.brand = brand;
		this.makeYear = makeYear;
	}

	@Override
	public int compareTo(Vehicle o) {
		return this.makeYear - o.makeYear;
		// We can also use the compareTo() method of the Integer class.
		//return this.makeYear.compareTo(o.makeYear);
	}
}


public class ArrayListDemo {

    public static void main(String args[]) {
        List<Vehicle> list = new ArrayList<>();
        list.add(new Vehicle("Volkswagen", 2010));
        list.add(new Vehicle("Audi", 2009));
        list.add(new Vehicle("Ford", 2001));
        list.add(new Vehicle("BMW", 2015));

        Collections.sort(list);
        for (Vehicle vehicle : list) {
            System.out.println("Vehicle Brand: " + vehicle.brand + ", Vehicle Make: " + vehicle.makeYear);
        }
    }
}

```
If we need to sort the Vehicle class on the basis of the brand name, the logic will be as below:
```java
public class Vehicle implements Comparable<Vehicle> {

	String brand;
	Integer makeYear;
	
	public Vehicle(String brand, Integer makeYear) {
		super();
		this.brand = brand;
		this.makeYear = makeYear;
	}

	@Override
	public int compareTo(Vehicle o) {
		//Using the compareTo() method of String class.
		return this.brand.compareTo(o.brand);
	}
}
```
## Understanding Comparator Interface
Let's discuss the working of Comparator Interface.

One of the major drawbacks of using a Comparable interface is that the `comparing logic gets fixed`. For instance, if we have a `Vehicle` class, then it can be sorted either on the basis of the `brand` or the `production year` depending on the implementation of the `compareTo()` method.

If we need some flexibility in sorting, we should use the Comparator interface instead of the Comparable interface. The Comparator interface has a method, `compare(T o1, T o2)`, which takes two objects, o1 and o2 as parameters. 
It returns :
> - -1 if o1 < o2 
> - 1 if o1 > o2  
> - 0 if o1 is equal to o2

If we need to use the Comparator interface, then we can’t use the `Collections.sort(List<T> t)` method as T should implement the Comparable interface. There is another overloaded method, `sort(List<T> list, Comparator<? super T> c)`, that takes the list as well as a Comparator object as input. It then sorts the List on the basis of logic, which is provided in the Comparator implementation.

The below code shows how to create a custom Comparator. We will create two custom comparators: one for sorting by brand and one for sorting by year.
```java
import java.util.Comparator;

public class BrandComparator implements Comparator<Vehicle> {

	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		return o1.brand.compareTo(o2.brand);
	}
}



public class MakeYearComparator implements Comparator<Vehicle>{

    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return o1.makeYear.compareTo(o2.makeYear);
    }
}
```

The above code can be further simplified if we use lambda expressions instead of anonymous classes. Lambda expressions were introduced in Java 8.

> Collections.sort(list, (o1, o2) -> o1.brand.compareTo(o2.brand));


```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Vehicle {

    String brand;
    Integer makeYear;

    public Vehicle(String brand, Integer makeYear) {
        super();
        this.brand = brand;
        this.makeYear = makeYear;
    }
}

public class ArrayListDemo {

    public static void main(String args[]) {
        List<Vehicle> list = new ArrayList<>();
        list.add(new Vehicle("Volkswagen", 2010));
        list.add(new Vehicle("Audi", 2009));
        list.add(new Vehicle("Ford", 2001));
        list.add(new Vehicle("BMW", 2015));
        list.add(new Vehicle("Tesla", 2020));
        list.add(new Vehicle("Tata", 2021));

        System.out.println("Sorting by brand name");
        Collections.sort(list, (o1, o2) -> o1.brand.compareTo(o2.brand));

        for (Vehicle vehicle : list) {
            System.out.println("Vehicle Brand: " + vehicle.brand + ", Vehicle Make: " + vehicle.makeYear);
        }

        System.out.println("");

        System.out.println("Sorting by brand make year");
        Collections.sort(list, (o1, o2) -> o1.makeYear.compareTo(o2.makeYear));

        for (Vehicle vehicle : list) {
            System.out.println("Vehicle Brand: " + vehicle.brand + ", Vehicle Make: " + vehicle.makeYear);
        }
    }
}
```