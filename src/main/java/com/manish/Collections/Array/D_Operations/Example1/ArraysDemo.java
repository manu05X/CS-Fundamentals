package com.manish.Collections.Array.D_Operations.Example1;

import java.util.Arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysDemo {

	public static void main(String args[]) {

		Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		List<Integer> list = Arrays.asList(numbers);

		System.out.print(list);
	}
}
/*
Converting an Array into a List
We can convert an array into a list using the asList() method. If any changes are made to the resulting list, then changes are propagated to the original array. The asList() method returns a fixed-size list, so it is not possible to add or remove elements from this list.
 */