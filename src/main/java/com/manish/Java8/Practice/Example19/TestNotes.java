package com.manish.Java8.Practice.Example19;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestNotes {

    public static void main(String[] args){
      List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
      Map<String,Long> namesCount = names
                                   .stream()
                       .filter(x-> Collections.frequency(names, x)>1)
                       .collect(Collectors.groupingBy
                       (Function.identity(), Collectors.counting()));

      System.out.println(namesCount);

/*or you can also try using  */

Map<String, Long> namesCount1 = names.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }
}

//19. How to find only duplicate elements with its count from the String ArrayList in Java8?