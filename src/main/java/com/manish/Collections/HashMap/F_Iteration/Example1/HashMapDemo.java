package com.manish.Collections.HashMap.F_Iteration.Example1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
Iterating a HashMap is a bit challenging compared to a List or a Set as it contains pairs of elements. In a map, each key-value pair is called Entry. The entrySet() method returns the Set view of the mapped elements. We can iterate over this Set using any of the below approaches.

Iterating using a for loop
We can easily iterate the EntrySet returned by the entrySet() method using an enhanced for loop. The Entry class contains two methods: getKey() and getValue(), which can be used to get the key and value respectively.
 */
public class HashMapDemo {

	public static void main(String args[]) {

		Map<String, Integer> stockPrice = new HashMap<>();

		stockPrice.put("Oracle", 56);
		stockPrice.put("Fiserv", 117);
		stockPrice.put("BMW", 73);
		stockPrice.put("Microsoft", 213);

		Set<Entry<String, Integer>> entrySet = stockPrice.entrySet(); // Returns a Set of Entries

		for (Entry<String, Integer> entry : entrySet) {
			System.out.println("Company Name: " + entry.getKey() + " Stock Price: " + entry.getValue());
		}
	}
}