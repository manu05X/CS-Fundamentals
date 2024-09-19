package com.manish.Collections.Arraylist.E_Comparable.Example1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//The below example will not compile as the Employee class does not implement the Comparable interface.

public class ArrayListDemo {

	public static void main(String args[]) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("Jane", 29));
		list.add(new Employee("Alex", 54));
		list.add(new Employee("Bob", 30));
		list.add(new Employee("John", 21));

		//Collections.sort(list);

		for(Employee emp : list) {
			System.out.println("Employee Name: " + emp.name + ", Employee Age: " + emp.age);
		}
	}
}