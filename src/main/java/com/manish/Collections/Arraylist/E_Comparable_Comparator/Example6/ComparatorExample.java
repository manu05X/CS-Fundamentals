package com.manish.Collections.Arraylist.E_Comparable_Comparator.Example6;

import java.util.*;

class Student {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return name + ": " + grade;
    }
}

class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName()); // Custom order by name
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 90));
        students.add(new Student("Charlie", 80));

        Collections.sort(students, new NameComparator()); // Sort using custom comparator

        for (Student student : students) {
            System.out.println(student);
        }
      // Output
      // Alice: 85
      // Bob: 90
      // Charlie: 80

        // Using a lambda expression for custom sorting by grade in descending order
        Collections.sort(students, (s1, s2) -> Integer.compare(s2.getGrade(), s1.getGrade()));
        System.out.println("Sorted by grade (desc): " + students);

     // Output
      // Bob: 90
      // Alice: 85
      // Charlie: 80
      
    }
}