# Java 8
___
What you will learn in this module?
After completing this module, you will be well versed in all the new features introduced in Java 8. Additionally, you will be able to use lambda expressions in your code and use the power of Stream API to make your code more readable, faster, and more concise.

We will be covering the following topics in this module.

1.Functional interfaces

2.Default and static methods in interfaces

3.Lambda expressions

4.Streams API

5.The new Date and Time API

6.Concurrency enhancements

7.Collections API improvements


## What is Syntax and Characteristics of a Lambda Expression?
### Syntax of a Lambda Expression
A lambda expression in Java is composed of three parts:
- 1. `Parameter List`: A comma-separated list of parameters enclosed in parentheses.
- 2. `Arrow Token`: The arrow token -> separates the parameter list from the body of the lambda expression.
- 3. `Body`: The body can be either a single expression or a block of code enclosed in braces {}.

```java
// No parameters
() -> System.out.println("Hello, World!");

// Single parameter (no parentheses required):
x -> x * x

// Multiple parameters:
(x, y) -> x + y

// Parameter types explicitly declared:
(int x, int y) -> x + y

// Multiple statements:
(int x, int y) -> {
    int sum = x + y;
    return sum;
}
```

