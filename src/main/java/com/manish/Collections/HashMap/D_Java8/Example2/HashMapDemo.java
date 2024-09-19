package com.manish.Collections.HashMap.D_Java8.Example2;

import java.util.HashMap;
import java.util.Map;
/*
The computeIfAbsent() method
The computeIfAbsent(Key, Function) method of the HashMap class is used to compute the value for a given key using the given mapping function and enter that computed value in HashMap; otherwise, it’s null. Please note that the computeIfAbsent() will work only if the key is not present or if the key is present with a null value.

The syntax of this method is:
public V computeIfAbsent(K key,Function<? super K, ? extends V> remappingFunction)

Let’s say we have a HashMap in which the key is a String and the value is the length of the String. We can use the computeIfAbsent() method to insert new pairs in the Map. We will pass a lambda function that returns the length of the key.
 */
public class HashMapDemo {

	public static void main(String args[]) {

		Map<String, Integer> map = new HashMap<>();
		map.put("India", 5);
		map.put("USA", 3);
		map.put("China", 5);
		map.put("Russia", 6);
		
		map.computeIfAbsent("Vietnam", k -> k.length());
		
		System.out.println(map);

	}
}