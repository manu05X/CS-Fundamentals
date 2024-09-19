package com.manish.Collections.HashMap.D_Java8.Example4;

import java.util.HashMap;
import java.util.Map;

/*
The merge() method
The merge function can be used to merge two Maps. This method takes three arguments:

1>key — The key that needs to be merged.
2>value — The value that needs to be inserted in case the key is not present.
3>remappingFunction — This is a BiFunction that is used to update the value if the key is present.

We will begin to understand the working of this method using an example. Let’s say we have two Maps in which the key is the name of a person and the value is the amount of money that person has borrowed from us. It is possible that a person is present in both the Maps. So, we need to merge these Maps to find the total amount that each person has borrowed from us.

The syntax of this method is:
merge(K key, V value,BiFunction remappingFunction)

 */


public class HashMapDemo {

	public static void main(String args[]) {

		Map<String, Integer> map1 = new HashMap<>();
		map1.put("Jay", 5000);
		map1.put("Rahul", 3000);
		map1.put("Nidhi", 4500);
		map1.put("Amol", 60000);
		
		Map<String, Integer> map2 = new HashMap<>();
		map2.put("Jay", 7000);
		map2.put("Rahul", 4500);
		map2.put("Nidhi", 1200);
		map2.put("Saurav", 25000);
		
		map1.forEach((key,value) -> map2.merge(key, value, (v1, v2) -> v1 + v2));
		
		System.out.println(map2);

	}
}