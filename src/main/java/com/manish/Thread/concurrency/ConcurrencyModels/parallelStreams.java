package com.manish.Thread.concurrency.ConcurrencyModels;

import java.util.Arrays;
import java.util.List;

public class parallelStreams {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        list.parallelStream().forEach(System.out::println);
    }
}
