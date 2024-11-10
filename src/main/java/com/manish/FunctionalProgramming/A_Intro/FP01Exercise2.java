package com.manish.FunctionalProgramming.A_Intro;

import java.util.List;

public class FP01Exercise2 {
    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        printAllCoursesInList(courses);
        printSpecificCourse(courses);
        printWordLength(courses);
        printWordLengthWithCourseName(courses);
        printWordWithGivenLength(courses);

    }

    private static void printAllCoursesInList(List<String> courses){
        System.out.println("Print each Courses in the List : ");
        courses.stream()
                .forEach(System.out::println);
    }

    private static void printSpecificCourse(List<String> courses){
        System.out.println("Printing Courses That Contain the Word \"Spring\"");

        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);
    }

    private static void printWordLength(List<String> courses){
        System.out.println("Printing Courses Word Length : ");

        courses.stream()
                .map(course -> course.length())   // Map each course to its length
                .forEach(System.out::println);    // Print the length of each course

    }

    private static void printWordLengthWithCourseName(List<String> courses){
        System.out.println("Printing Course Names with Their Lengths : ");

        courses.stream()
                .map(course -> course + " : " + course.length()) // Map to "course name + length"
                .forEach(System.out::println); // Print the course and its length

    }

    private static void printWordWithGivenLength(List<String> courses){
        System.out.println("Print courses with at least four letters");

        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }
}
