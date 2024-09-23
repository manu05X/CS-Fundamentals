package com.manish.Java8.Practice.Example17;

import java.util.*;
import java.util.stream.*;

public class TestNotes {

    public static void main(String[] args) {

    List<Notes> noteLst = new ArrayList<>();
    noteLst.add(new Notes(1, "note1", 11));
    noteLst.add(new Notes(2, "note2", 22));
    noteLst.add(new Notes(3, "note3", 33));
    noteLst.add(new Notes(4, "note4", 44));
    noteLst.add(new Notes(5, "note5", 55));

    noteLst.add(new Notes(6, "note4", 66));


    Map<String, Long> notesRecords = noteLst.stream()
                                            .sorted(Comparator
                                            .comparingLong(Notes::getTagId)
                                            .reversed()) // sorting is based on TagId 55,44,33,22,11
                                            .collect(Collectors.toMap
                                            (Notes::getTagName, Notes::getTagId,
                                            (oldValue, newValue) -> oldValue,LinkedHashMap::new));
// consider old value 44 for dupilcate key
// it keeps order
        System.out.println("Notes : " + notesRecords);
    }
}

//17. How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?