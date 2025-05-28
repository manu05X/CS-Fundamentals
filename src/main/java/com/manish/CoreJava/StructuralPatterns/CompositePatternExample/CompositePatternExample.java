package com.manish.CoreJava.StructuralPatterns.CompositePatternExample;


public class CompositePatternExample {
    public CompositePatternExample() {
    }

    public static void main(String[] args) {
        Developer dev1 = new Developer(100L, "John Doe", "Pro Developer");
        Developer dev2 = new Developer(101L, "Jane Doe", "Entry Level Developer");
        CompanyDirectory engineeringDirectory = new CompanyDirectory();
        engineeringDirectory.addEmployee(dev1);
        engineeringDirectory.addEmployee(dev2);
        Manager man1 = new Manager(200L, "Mike Smith", "SEO Manager");
        Manager man2 = new Manager(201L, "Mary Williams", "CFO Manager");
        CompanyDirectory managementDirectory = new CompanyDirectory();
        managementDirectory.addEmployee(man1);
        managementDirectory.addEmployee(man2);
        CompanyDirectory companyDirectory = new CompanyDirectory();
        companyDirectory.addEmployee(engineeringDirectory);
        companyDirectory.addEmployee(managementDirectory);
        companyDirectory.showEmployeeDetails();
    }
}