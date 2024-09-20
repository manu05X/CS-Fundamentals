package com.manish.Collections.Arraylist.E_Comparable_Comparator.Example5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
		//The lambda expression (o1, o2) -> o1.brand.compareTo(o2.brand) acts as the Comparator<? super Vehicle> that defines how to compare two Vehicle objects based on their brand.

		System.out.println("");

		System.out.println("Sorting by brand make year");
		Collections.sort(list, (o1, o2) -> o1.makeYear.compareTo(o2.makeYear));

		for (Vehicle vehicle : list) {
			System.out.println("Vehicle Brand: " + vehicle.brand + ", Vehicle Make: " + vehicle.makeYear);
		}
	}
}