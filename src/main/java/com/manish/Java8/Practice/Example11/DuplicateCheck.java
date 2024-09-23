package com.manish.Java8.Practice.Example11;

import java.util.*;
import java.util.stream.*;

public class DuplicateCheck {

    // First approach: Using List and Set comparison
    public boolean containsDuplicateUsingListSet(int[] nums) {
        List<Integer> list = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());

        Set<Integer> set = new HashSet<>(list);

        // If set size and list size are equal, no duplicates exist
        return set.size() != list.size();
    }

    // Second approach: Using Set and anyMatch with Stream
    public boolean containsDuplicateUsingStream(int[] nums) {
        Set<Integer> setData = new HashSet<>();
        // Check if there's any number that is already in the set (duplicate)
        return Arrays.stream(nums).anyMatch(num -> !setData.add(num));
    }

    public static void main(String[] args) {
        DuplicateCheck duplicateCheck = new DuplicateCheck();
        int[] nums = {1, 2, 3, 4, 5, 6, 1};

        // Check for duplicates using the first approach (List and Set)
        boolean result1 = duplicateCheck.containsDuplicateUsingListSet(nums);
        System.out.println("Contains duplicate (List and Set approach): " + result1);

        // Check for duplicates using the second approach (Stream and Set)
        boolean result2 = duplicateCheck.containsDuplicateUsingStream(nums);
        System.out.println("Contains duplicate (Stream approach): " + result2);
    }
}

//11. Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.