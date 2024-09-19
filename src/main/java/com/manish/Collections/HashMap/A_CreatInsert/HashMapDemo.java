package com.manish.Collections.HashMap.A_CreatInsert;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
	
	public static void main(String args[]) {
		//Map<String, Integer> map = new HashMap<>();
		Map<String, Integer> stockPrice = new HashMap<>();
		
		stockPrice.put("Oracle", 56); //Inserting share price of Oracle in the Map.
		System.out.println(stockPrice);
		
		stockPrice.put("Oracle", 60); //Inserting share price of Oracle again. This will update the value.
		System.out.println(stockPrice);
		
		stockPrice.putIfAbsent("Oracle", 70); //Inserting share price of Oracle again using putIfAbsent() method. This will not update the value.
		System.out.println(stockPrice);
	}
}
/*Some of the features of HashMap are:

The keys should be unique.
HashMap allows only one null key.
The values can be null or duplicate.
The keys are stored in random order.

Load factor is a number that defines when a Map should be resized. If the load factor is 0.75, then it means that the Map should be resized when it is 75 percent full.
 */