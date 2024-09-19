package com.manish.Collections.HashMap.B_UpdateRemove.Example3;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

	public static void main(String args[]) {

		Map<String, Integer> stockPrice = new HashMap<>();

		stockPrice.put("Oracle", 56);
		stockPrice.put("Fiserv", 117);
		stockPrice.put("BMW", 73);
		stockPrice.put("Microsoft", 213);
		
		//This will remove Oracle from the Map and return 56.
		System.out.println(stockPrice.remove("Oracle"));
		
		//This will return null as Google is not present in the Map.
		System.out.println(stockPrice.remove("Google"));

		//This will return false because the value passed does not match the value of BMW in the Map.
		System.out.println(stockPrice.remove("BMW", 45));


	}
}
/*
Removing an element from a HashMap#
An element can be easily removed for the HashMap using the remove(Object key) method. It takes a key as a parameter and removes that key from the map. This method returns the value of the key that was removed. If the key is not present, then it returns null.

Another overloaded version of this method remove(Object key, Object value) was added in Java 8. This method removes a key only if it is currently mapped to the specified value. This method returns true if the key is removed; otherwise, it returns false.


 */