package com.manish.Collections.HashMap.C_Operation.Example2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String args[]) {

		Map<String, Integer> stockPrice = new HashMap<>();

		stockPrice.put("Oracle", 56);
		stockPrice.put("Fiserv", 117);
		stockPrice.put("BMW", 73);
		stockPrice.put("Microsoft", 213);
		
		System.out.println("HashMap Keys");
		Set<String> keys = stockPrice.keySet();
		for(String key : keys) {
			System.out.println(key);
		}
		
		System.out.println("HashMap Values");
		Collection<Integer> values = stockPrice.values();
		for(Integer value : values) {
			System.out.println(value);
		}
		
	}
}

/*
Fetching all the keys from HashMap#
If we need to fetch all the keys that are stored in a HashMap, then we can use the keySet() method. This method returns a Set containing all the keys present in the Map.

Fetching all the values from HashMap
If we need to fetch all the values stored in a HashMap, we can use the values() method. This method returns a Collection containing all the values present in the Map.
 */