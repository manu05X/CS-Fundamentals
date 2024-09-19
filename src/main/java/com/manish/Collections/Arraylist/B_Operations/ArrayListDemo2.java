package com.manish.Collections.Arraylist.B_Operations;

import java.util.ArrayList;
import java.util.List;


public class ArrayListDemo2 {

    public static void main(String args[]) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");

        list.replaceAll((element) -> element.toUpperCase());

        System.out.println(list); //[APPLE, BANANA]
    }
}