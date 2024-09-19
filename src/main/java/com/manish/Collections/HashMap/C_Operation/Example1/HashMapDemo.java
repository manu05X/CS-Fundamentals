package com.manish.Collections.HashMap.C_Operation.Example1;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

	public static void main(String args[]) {

		Map<String, Integer> stockPrice = new HashMap<>();

		stockPrice.put("Oracle", 56);
		stockPrice.put("Fiserv", 117);
		stockPrice.put("BMW", 73);
		stockPrice.put("Microsoft", 213);
		
		System.out.println(stockPrice.containsKey("Oracle"));
		
		System.out.println(stockPrice.containsValue(73));
	}
}
/*
Operations on HashMap
Checking if a key is present in the HashMap
We can use the containsKey(Object key) method to check if a given key is present in the HashMap. This method returns true if the key is present and returns false if the key is not present. Similarly, we have a containsValue(Object value) method that returns true if one or more keys are mapped to this value.
 */