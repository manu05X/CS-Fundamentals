package com.manish.Collections.HashMap.E_DesignGoodKey.Example3;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

	public static void main(String args[]) {

		Employee emp1 = new Employee(123, "Jane");

		Map<Employee, Integer> employeeMap = new HashMap<>();

		employeeMap.put(emp1, 56000);

		emp1.empName = "Alex";

		System.out.println(employeeMap.get(emp1));

	}
}
/*
Why immutable objects make a good key
It is not mandatory for a HashMap key to be immutable, but it is suggested that key objects are immutable. Immutability allows us to get the same hash code every time for a key object.

All the wrapper classes such as String, Integer, etc., are immutable, so they are considered good key candidates.

Let’s look at an example to understand what happens when a key object is not immutable. In the below example, we are using an Employee object as a key. After inserting the employee object into the HashMap, we will make a change in the Employee object. After that, we will try to get the value for this key from the HashMap.
 */