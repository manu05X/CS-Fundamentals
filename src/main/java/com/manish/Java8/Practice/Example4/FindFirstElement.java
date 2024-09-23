package com.manish.Java8.Practice.Example4;

// 4. Given the list of integers, find the first element of the list using Stream functions?

import java.util.*;
import java.util.stream.*;

public class FindFirstElement{
  public static void main(String args[]) {
          List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
          myList.stream()
                .findFirst()
                .ifPresent(System.out::println);

      /* or can also try below single line code */
      // Alternative approach using an array of integers
      int[] arr = {10, 15, 8, 49, 25, 98, 98, 32, 15}; // Declare the array

      Arrays.stream(arr).boxed().findFirst().ifPresent(System.out::print);
  }
}
