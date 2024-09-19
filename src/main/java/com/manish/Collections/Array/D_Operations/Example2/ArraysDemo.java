package com.manish.Collections.Array.D_Operations.Example2;

import java.util.Arrays;

public class ArraysDemo {

	public static void main(String args[]) {

		Integer[] numbers1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Integer[] numbers2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		boolean isEqual = Arrays.equals(numbers1, numbers2);
		
		
		System.out.print("Checking if two arrays are equal : " + isEqual);
	}
}
/*
Checking if two arrays are equal
We can use the equals() method of the Arrays class to check if the two arrays are equal or not. Two arrays are considered equal if both have the same number of elements and all corresponding pairs of elements in the two arrays are equal.

 */