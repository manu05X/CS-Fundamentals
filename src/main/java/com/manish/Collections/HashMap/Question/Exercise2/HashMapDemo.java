package com.manish.Collections.HashMap.Question.Exercise2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
Problem 2: Find the average stock price
Find the average stock price of all the companies

Solution:
To find the average stock price of all the companies, we will first get the sum of all the stock prices. After that, we will divide it by the number of companies. We can use the values() method to get the list of all the values.

The sum of all the values can be found through Java 8 features as well, which is shown in the below example.
 */
public class HashMapDemo {

	public static void main(String args[]) {

		Map<String, Integer> stockPrice = new HashMap<>();

		stockPrice.put("Oracle", 56);
		stockPrice.put("Fiserv", 117);
		stockPrice.put("BMW", 73);
		stockPrice.put("Microsoft", 213);
		stockPrice.put("Google", 421);
		stockPrice.put("Ford", 456);
		stockPrice.put("Novartis", 43);
		stockPrice.put("TCS", 23);
		
		Collection<Integer> values= stockPrice.values();
		
		int sum = 0;
		
		for(int i : values) {
			sum += i;
		}
		// Sum of values using Java 8 features
		//int sum = values.stream().mapToInt(i -> i.intValue()).sum();
		System.out.println("The average  stock price is " + sum / values.size());
		
	}
}