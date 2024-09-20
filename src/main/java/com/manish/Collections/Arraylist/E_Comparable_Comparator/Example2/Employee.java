package com.manish.Collections.Arraylist.E_Comparable_Comparator.Example2;

public class Employee implements Comparable<Employee> {

    String name;
    int age;

	public Employee(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Employee emp) {
        //We will sort the employee based on age in ascending order
        //returns a negative integer, zero, or a positive integer as this employee age
        //is less than, equal to, or greater than the specified object.
        return (this.age - emp.age);
    }
}
