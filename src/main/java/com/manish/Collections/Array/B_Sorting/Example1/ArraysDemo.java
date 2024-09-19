package com.manish.Collections.Array.B_Sorting.Example1;

import java.util.Arrays;

public class ArraysDemo {

	public static void main(String args[]) {

		Integer[] numbers = { 10, 2, 32, 12, 15, 76, 17, 48, 79, 9 };
		Arrays.sort(numbers);

		for (int i : numbers) {
			System.out.print(i + " ");
		}
	}
}
/*

The Arrays class has a sort() method that is used to sort the arrays of objects and primitives. If we are sorting a primitive array, then quicksort is used. And if we are sorting an object array, then merge sort is used.

Although quicksort is faster in both cases, it is not a stable algorithm. Merge sort is a stable algorithm, so it is used in the case of sorting an object array. In the case of the primitive array, we don’t care about stability, so quicksort is used.


Stable sorting algorithms are algorithms that maintain the relative order of equal elements. For example, we have an array [1,4,6,8,6], which we need to sort. Now after sorting this array, the result is [1,4,6,6,8]. Although there are two sixes in the array, we don’t care which six came first in the sorted array. But in the case of an object array, the relative order of elements also matters. If two objects are the same in an object array, then their relative order should be the same in the sorted array.

The sort method has two variants:

sort(array) – sorts the full array into ascending order
sort(array, fromIndex, toIndex) – sorts only the elements from fromIndex to toIndex.
 */