package com.manish.Collections.Arraylist.A_InsertRetrive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Example3 {

    public static void main(String args[]) {
        // create a ArrayList String type
        // and Initialize an ArrayList with add()
        System.out.print("1> Using shorthand version of add() method : ");
        List<Integer> list = new ArrayList<>(){
            {
                add(1);
                add(2);
                add(3);
                add(4);
            }
        };
        System.out.println(list);


        System.out.print("2> Initialization using : ArrayList<Type> obj = new ArrayList<Type>(Arrays.asList(Obj A, Obj B, Obj C, ....so on)) => ");
        List<String> list1 = new ArrayList<>(Arrays.asList("Hello", "World", "from", "ArrayList"));
        System.out.println(list1);

        System.out.print("3> Initialization using : List<Type> obj = new ArrayList<>(List.of(Obj A, Obj B, Obj C, ....so on)); => ");
        List<Integer> list2 = new ArrayList<>(List.of(1,2,3,4,5,6,7,8));
        System.out.println(list2);


        System.out.print("4> Initialization using another Collection : List gfg = new ArrayList(collection); => ");
        List<Integer> list3 = new ArrayList<>(list2);
        System.out.println(list3);

        System.out.print("5> Initialization using another Collection : ArrayList<Type> listName = Stream.of(e1, e2, ..., eN).collect(Collectors.toCollection(ArrayList::new)); => ");
        List<Integer> list4 = Stream.of(9,10,11,12,13,14,15).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(list4);

        System.out.print("6> Initialization without using Collection : List<Integer> list5 = List.of(value1,value2,value3,value4,value5); ");
        List<Integer> list5 = List.of(9,10,11,12,13,14,15);
        System.out.println(list5);



    }
}

/*
OUTPUT:
1> Using shorthand version of add() method : [1, 2, 3, 4]
2> Initialization using : ArrayList<Type> obj = new ArrayList<Type>(Arrays.asList(Obj A, Obj B, Obj C, ....so on)) => [Hello, World, from, ArrayList]
3> Initialization using : List<Type> obj = new ArrayList<>(List.of(Obj A, Obj B, Obj C, ....so on)); => [1, 2, 3, 4, 5, 6, 7, 8]
4> Initialization using another Collection : List gfg = new ArrayList(collection); => [1, 2, 3, 4, 5, 6, 7, 8]
5> Initialization using another Collection : ArrayList<Type> listName = Stream.of(e1, e2, ..., eN).collect(Collectors.toCollection(ArrayList::new)); => [9, 10, 11, 12, 13, 14, 15]
 */