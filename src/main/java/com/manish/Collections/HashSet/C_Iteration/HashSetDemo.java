package com.manish.Collections.HashSet.C_Iteration;

import java.util.HashSet;
import java.util.Set;

/*
Using for loop
A HashSet can be easily iterated using an enhanced for loop as shown below.
 */
public class HashSetDemo {
	public static void main(String args[]) {
		Set<Integer> set = new HashSet<>();

		set.add(23);
		set.add(34);
		set.add(56);

		for(int i : set) {
			System.out.println(i);
		}
	}
}