package com.manish.Collections.HashMap.D_Java8.Example1;

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
		map.compute("India", (k, v) -> v == null ? 10 : v + 1);

		// This will insert Vietnam in the Map with default value of 10.
		map.compute("Vietnam", (k, v) -> v == null ? 10 : v + 1);

		System.out.println(map);

	}
}

/*
The compute() method
The compute(Key, BiFunction) method allows us to update a value in HashMap. This method tries to compute a mapping for the specified key and its current mapped value (or null if no current mapping is found). This method is used to atomically update a value for a given key in HashMap.

1.If the remapping function passed in compute returns null, the mapping is removed from the Map (or remains absent if initially absent).
2.If the remapping function throws an exception, the exception is rethrown, and the current mapping is left unchanged.

The syntax of this method is:
compute(K key,BiFunction<? super K, ? super V, ? extends V> remappingFunction)

Let’s say we have a HashMap in which the key is a String, and the value is an Integer. We need to increment the value for a given key by one, and if the key is not present, we need to insert the key with the default value of 10. We can create a lambda expression and pass it to the compute() method.
 */