package com.manish.Collections.HashMap.Question.Exercise3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/*
Problem 3: Remove companies with stock price below 50
Remove all the companies that have a stock price of fewer than 50 dollars.

Solution:
To remove all the companies with prices lower than 50, we will iterate the EntrySet using an iterator and will use the iterator to remove the elements.
 */
public class HashMapDemo {

	public static void main(String args[]) {

		Map<String, Integer> stockPrice = new HashMap<>();

		stockPrice.put("Oracle", 56);
		stockPrice.put("Fiserv", 117);
		stockPrice.put("BMW", 73);
		stockPrice.put("Microsoft", 28);
		stockPrice.put("Google", 421);
		stockPrice.put("Ford", 456);
		stockPrice.put("Novartis", 43);
		stockPrice.put("TCS", 23);
		
		Iterator<Entry<String, Integer>> itr= stockPrice.entrySet().iterator();
		
		while(itr.hasNext()) {
			Entry<String, Integer> entry = itr.next();
			if(entry.getValue() < 50) {
				itr.remove();
			}
		}
		
		System.out.println(stockPrice);
		
	}
}