package com.manish.Collections.Arraylist.E_Comparable_Comparator.Example2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//In the below example, the Employee class implements the Comparable interface.
//The code will run successfully and will sort the Employee objects in ascending order of their age.

public class ArrayListDemo {

	public static void main(String args[]) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("Jane", 29));
		list.add(new Employee("Alex", 54));
		list.add(new Employee("Jone", 24));
		list.add(new Employee("Kate", 36));

		System.out.println("Before Sorting List: ");
		for(Employee emp : list) {
			System.out.println("Employee Name: " + emp.name + ", Employee Age: " + emp.age);
		}

		Collections.sort(list);

		System.out.println("After Sorting List: ");

		for(Employee emp : list) {
			System.out.println("Employee Name: " + emp.name + ", Employee Age: " + emp.age);
		}
	}
}