package com.manish.Generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TypeInferenceExample {
    public TypeInferenceExample() {
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList();
        stringList.add("Java");
        stringList.add("Generics");
        stringList.add("Type Inference");
        Iterator var2 = stringList.iterator();

        while(var2.hasNext()) {
            String s = (String)var2.next();
            System.out.println(s);
        }

    }
}