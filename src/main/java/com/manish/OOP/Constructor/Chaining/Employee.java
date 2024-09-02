package com.manish.OOP.Constructor.Chaining;

public class Employee {
    private int id;
    private String name;

    public Employee() {
        this("John Doe", 999);
        System.out.println("Default Employee Created");
    }

    public Employee(int i) {
        this("John Doe", i);
        System.out.println("Employee Created with Default Name");
    }
    public Employee(String s, int i) {
        this.id = i;
        this.name = s;
        System.out.println("Employee Created");
    }
    public static void main(String[] args) {

        Employee emp = new Employee();
        System.out.println(emp);
        Employee emp1 = new Employee(10);
        System.out.println(emp1);
        Employee emp2 = new Employee("Pankaj", 20);
        System.out.println(emp2);
    }

    @Override
    public String toString() {
        return "ID = "+id+", Name = "+name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
