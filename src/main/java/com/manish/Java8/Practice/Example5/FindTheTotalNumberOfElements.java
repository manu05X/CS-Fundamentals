package com.manish.Java8.Practice.Example5;

//5. Given a list of integers, find the total number of elements present in the list using Stream functions?

import java.util.Arrays;
import java.util.List;

public class FindTheTotalNumberOfElements{
  public static void main(String args[]) {
          List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
          long count =  myList.stream().count();
          System.out.println(count);

/* or can also try below line code */
      int[] arr = {10,15,8,49,25,98,98,32,15, 47,71} ;
      long count1 = Arrays.stream(arr).boxed().count();
      System.out.println(count1);
  }
}
