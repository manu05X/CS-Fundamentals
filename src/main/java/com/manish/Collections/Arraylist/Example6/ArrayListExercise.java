package com.manish.Collections.Arraylist.Example6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListExercise {
	
	public static void main(String args[]) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("Alex", 23, "USA"));
		list.add(new Employee("Dave", 34, "India"));
		list.add(new Employee("Carl", 21, "USA"));
		list.add(new Employee("Joe", 56, "Russia"));
		list.add(new Employee("Amit", 64, "China"));
		list.add(new Employee("Ryan", 19, "Brazil"));

		//Problem 1: Find employees aged over 50
		System.out.println("Name of employees with age more than 50");
		for(Employee emp : list) {
			if(emp.age > 50) {
				System.out.println(emp.name);
			}
		}

		//Solution using streams.
		System.out.println("Solution using streams");
		list.stream().filter(emp -> emp.age > 50).map(emp -> emp.name).forEach(System.out::println);

		System.out.println("");
		//Problem 2: Find employees from the USA
		System.out.println("Removing the employees residing in USA from the List");
		Iterator<Employee> itr = list.iterator();
		while(itr.hasNext()) {
			if(itr.next().country.equals("USA")) {
				itr.remove();
			}
		}
		for (Employee emp : list) {
			System.out.println("Employee Name: " + emp.name + ", Employee Country: " + emp.country);
		}

		System.out.println("");
		//Problem 3: Sort employees by country
		System.out.println("Sorting all the employees by country name");
		Collections.sort(list, (e1, e2) -> e1.country.compareTo(e2.country));

		for (Employee emp : list) {
			System.out.println("Employee Name: " + emp.name + ", Employee Country: " + emp.country);
		}
	}

}