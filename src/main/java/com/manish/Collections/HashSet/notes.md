# HashSet: Creation and Insertion
___
HashSet is a class in the `java.utils` package which implements the Set interface. Some of the features of HashSet are:

- HashSet does not allow duplicate elements.
- HashSet allows only one null element.
- The elements are inserted in random order in a HashSet.
- A HashSet is internally backed by a HashMap.

## Creating a HashSet
There are four different constructors available to create a HashSet in Java:

### Using the no-arg constructor
The simplest way to create a HashSet is by using the no-arg constructor. This constructor creates a HashSet with an initial capacity of 16 and a load factor of 0.75.

Below is the code syntax to create a HashSet.

>Set<Integer> set= new HashSet<>();

>Load factor is a number that defines when a Set should be resized. If the load factor is 0.75, then the Set should be resized when it is 75% full.