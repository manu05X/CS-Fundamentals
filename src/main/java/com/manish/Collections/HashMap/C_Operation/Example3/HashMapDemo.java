package com.manish.Collections.HashMap.C_Operation.Example3;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class HashMapDemo {
	public static void main(String args[]) {
		Map<String, Integer> map = new HashMap<>();

		map.put("abc", 23);
		map.put("def", 34);
		map.put("ghi", 56);

		System.out.println(map.isEmpty());
	}
}

/*
Checking if the HashMap is empty
We can check if the HashMap is empty using the isEmpty() method. This method returns true if the Map does not have any elements and returns false if the Map has some elements.
 */