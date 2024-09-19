package com.manish.Collections.Array.D_Operations.Example3;

import java.util.Arrays;

public class ArraysDemo {

	public static void main(String args[]) {

		Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int i : numbers) {
			System.out.print(i + " ");
		}

		System.out.println(" ");

		Arrays.fill(numbers, 20);
		System.out.println("After Filling with default value:  ");

		for (int i : numbers) {
			System.out.print(i + " ");
		}
	}
}
/*
Filling an array with default value
Have you ever encountered a scenario where you need to initialize an array and then fill it with some default value?

If yes, then you might have iterated the array and filled each element with the default value. This task can be made simple using the fill() method of the Arrays class. This method takes an array and a default value as input. It then assigns the default value to each element of the array.
 */