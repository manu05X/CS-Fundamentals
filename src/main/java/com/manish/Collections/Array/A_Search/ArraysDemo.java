package com.manish.Collections.Array.A_Search;

import java.util.Arrays;

public class ArraysDemo {

	public static void main(String args[]) {
    
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int index = Arrays.binarySearch(numbers, 4);

		System.out.println("The index of element 4 in the array is " + index);

		int[] numbers1 = {1, 3, 5, 6, 7, 8, 9, 10, 11};
		int index1 = Arrays.binarySearch(numbers1, 4);
		// -(insertion point) - 1 => -(2)-1 => -3

		System.out.println("The index of element 4 in the array is " + index1);


		int[] numbers2 = {1, 5, 4, 6, 7, 8, 9, 10, 11};

		int index2 = Arrays.binarySearch(numbers2, 4);
		//The result will be undefined because the array is not sorted. It may return a negative value or an incorrect index

		System.out.println("The index of element 4 in the array is " + index2);


	}
}
/*
Here’s a breakdown of what happens in each part of the code:
First Array (numbers): The array is {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}. The element 4 is present at index 3.
Second Array (numbers1): The array is {1, 3, 5, 6, 7, 8, 9, 10, 11}. The element 4 is not present in this array. Since binarySearch cannot find the element, it returns a negative value indicating that the element is not found. The specific return value can be calculated as -(insertion point) - 1, which in this case results in -3.
Third Array (numbers2): The array is {1, 5, 4, 6, 7, 8, 9, 10, 11}. This array is not sorted. Therefore, calling binarySearch on it will yield an undefined result (it may return a negative value or an incorrect index). However, since the algorithm does not guarantee a valid index for unsorted arrays, it’s unpredictable.
 */