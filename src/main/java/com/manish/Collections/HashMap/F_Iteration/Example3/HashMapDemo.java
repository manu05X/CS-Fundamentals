package com.manish.Collections.HashMap.F_Iteration.Example3;

import java.util.HashMap;
import java.util.Map;

/*
Iterating using an iterator
Instead of using a for loop, we can get the iterator on the EntrySet and then use it to iterate the HashMap. If we remove an element from the EntrySet, then it is also removed from the original Map.
 */

public class HashMapDemo {

	public static void main(String args[]) {

		Map<String, Integer> stockPrice = new HashMap<>();

		stockPrice.put("Oracle", 56);
		stockPrice.put("Fiserv", 117);
		stockPrice.put("BMW", 73);
		stockPrice.put("Microsoft", 213);

		stockPrice.forEach((key, value) -> System.out
				.println("Company Name: " + key + " Stock Price: " + value));

	}
}