package com.manish.Collections.HashSet.A_Creation.Example1;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
	public static void main(String args[]) {
		Set<Integer> set = new HashSet<>();
		
		System.out.println("Inserting 23 in the HashSet:  " + set.add(23));
		System.out.println("Inserting 34 in the HashSet:  " + set.add(34));
		System.out.println("Inserting 23 in the HashSet:  " + set.add(23));
		
		System.out.println(set);
		
	}
}
/*
HashSet does not allow duplicate elements.
HashSet allows only one null element.
The elements are inserted in random order in a HashSet.
A HashSet is internally backed by a HashMap.
 */