package com.manish.Java8.Practice.Example1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNumber{
    public static void main(String args[]) {
      List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
            list.stream()
                .filter(n -> n%2 == 0)
                .forEach(System.out::println);

    /* or can also try below method */

//    Map<Boolean, List<Integer>> list = Arrays.stream(nums).boxed()
//    .collect(Collectors.partitioningBy(num -> num % 2 == 0));
//    System.out.println(list);
       }
   }
