package com.manish.Collections.HashMap.D_Java8.Example3;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

	public static void main(String args[]) {

		Map<String, Integer> map = new HashMap<>();
		map.put("India", 5);
		map.put("USA", 3);
		map.put("China", 5);
		map.put("Russia", 6);
		
		// This will increment the value of India by 1 as it is present in the Map
		map.computeIfPresent("India", (k, v) -> v == null ? 10 : v + 1);

		// This will not insert Vietnam in the Map. 
		map.computeIfPresent("Vietnam", (k, v) -> v == null ? 10 : v + 1);

		System.out.println(map);

	}
}
/*
The computeIfPresent() method
The computeIfPresent(Key, BiFunction) method of the HashMap class allows you to compute the value of mapping for a specified key if the key is already associated with a value or is mapped to null.

1.If the mapping function of this method returns null, the mapping is removed.
2.If the remapping function throws an exception, the exception is rethrown, and the mapping is left unchanged.

The syntax of this method is:
public Object computeIfPresent(Object key,BiFunction remappingFunction)

Let’s say we have a HashMap in which the key is a String and the value is some Integer. Then we can use computeIfPresent() method to update the value in the Map. We will pass a lambda function that will calculate a value if the key is already present in the Map.
 */