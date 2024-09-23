package com.manish.Java8.Practice.Example2;

import java.util.*;

public class NumberStartingWithOne{
    public static void main(String args[]) {
            List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
            myList.stream()
                  .map(s -> s + "") // Convert integer to String
                  .filter(s -> s.startsWith("1"))
                  .forEach(System.out::println);

/* or can also try below method */
/*
      List<String> list = Arrays.stream(arr).boxed()
                                .map(s -> s + "")
                                .filter(s -> s.startsWith("1"))
                                .collect(Collectors.toList());

    System.out.println(list);

 */
    }
}

//2. Given a list of integers, find out all the numbers starting with 1 using Stream functions?
