package com.manish.Collections.HashMap.Question.Exercise1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
Problem 1: Find the highest stock price
Find the company with the highest stock price.

Solution:
To find the company with the highest stock price, we will have to first iterate the HashMap. We can get the EntrySet and then iterate over it. For each entry, we will check if the stock price is more than whatever max value we have. If yes, we will store the company corresponding to this entry in a variable.
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
		
		int max = 0;
		String company = "";
		
		for(Entry<String, Integer> entry : stockPrice.entrySet()) {
			if(entry.getValue() > max) {
				company = entry.getKey();
				max = entry.getValue();
			}
		}
		
		System.out.println("Company with max stock price is: " + company);
		
	}
}