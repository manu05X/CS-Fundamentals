package com.manish.Collections.Array.B_Sorting.Example2;

import java.util.Arrays;

public class ArraysDemo {

	public static void main(String args[]) {

		Integer[] numbers = { 10, 2, 32, 12, 15, 76, 17, 48, 79, 9 };
		Arrays.parallelSort(numbers);

		for (int i : numbers) {
			System.out.print(i + " ");
		}
	}
}
/*
Sorting an array in parallel
In Java 8, a new method parallelSort() was introduced to sort the arrays parallelly. Unlike sort(), which sorts data sequentially using a single thread, parallelSort() uses a parallel sort-merge sorting algorithm. It breaks the array into sub-arrays that are themselves sorted and then merged.

This method uses the ForkJoin pool for executing parallel tasks. The array is sorted parallelly only when certain conditions are met. If the array size is less than or equal to 8192 or the processor has only one core, then the sequential dual-pivot Quicksort algorithm is used. Otherwise, it uses a parallel sort.
 */