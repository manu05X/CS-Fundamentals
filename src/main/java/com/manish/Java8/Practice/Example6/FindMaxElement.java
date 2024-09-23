package com.manish.Java8.Practice.Example6;

//6. Given a list of integers, find the maximum value element present in it using Stream functions?

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindMaxElement{
  public static void main(String args[]) {
          List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
          int max =  myList.stream()
                           .max(Integer::compare)
                           .get();
          System.out.println(max);   

/* or we can try using below way */
      int[] arr = {10,15,8,49,25,98,100,32,15, 47,71} ;

        int maxdata = Arrays.stream(arr).boxed()
                            .max(Comparator.naturalOrder()).get();

        System.out.println(maxdata);              
  }
}