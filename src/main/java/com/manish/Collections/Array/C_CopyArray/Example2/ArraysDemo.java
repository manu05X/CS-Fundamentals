package com.manish.Collections.Array.C_CopyArray.Example2;

import java.util.Arrays;

public class ArraysDemo {

	public static void main(String args[]) {

		// Creating an Array of Employee objects.
		Employee[] employees = { new Employee(123, "Jay"), new Employee(124, "Ryan") };

		// Creating the copy of Array.
		Employee[] copiedArray = Arrays.copyOf(employees, 2);

		// Changing the name of first employee in original array.
		employees[0] = new Employee(123, "Changed Name");

		// Printing the name of first employee in original array.
		System.out.println(employees[0].empName);

		// Printing the name of first employee in copied array.
		System.out.println(copiedArray[0].empName);
	}
}

/*
Have you ever wondered what would happen if we create a copy of an array that contains objects of a custom class?

If we change the object in the original array, will it be changed in the copied array?

Let’s try to answer these questions using an example. In the below example, we have created an array of two Employee objects. Then we created a copy of this array. We will see what happens when one of the Employee objects is changed in the original array.

As we can see from the above program’s output, the name did not change in the copied array. This means that the copyOf() method creates a deep copy of objects instead of just changing the references.

 */