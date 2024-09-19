package com.manish.Collections.Array.A_Search.Example3;

import java.util.Arrays;

public class ArraysDemo {

	public static void main(String args[]) {
		Employee[] employees = { new Employee(123, "Jay"), new Employee(124, "Roy"), new Employee(125, "Nikki"),
				new Employee(126, "Tom") };

		int index = Arrays.binarySearch(employees, new Employee(124, "Roy"), (emp1, emp2) -> emp1.empId - emp2.empId);

		System.out.println("The index of employee object in the array is " + index);

	}

}
/*
Searching a custom class object in an array
Let’s say we have created an Employee class and we have an array of Employee objects. We want to check if a particular Employee object is present in the array or not.

We will pass the employee array and the object that we need to search to the binarySearch() method as shown in the below example.

The below example will not compile because our Employee class does not implement the Comparable interface. For the search to be successful it is necessary that the objects we have stored in the array should be comparable.
 */