package com.manish.CoreJava.StructuralPatterns.CompositePatternExample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class CompanyDirectory implements Employee {
    private List<Employee> employeeList = new ArrayList();

    CompanyDirectory() {
    }

    public void showEmployeeDetails() {
        Iterator var1 = this.employeeList.iterator();

        while(var1.hasNext()) {
            Employee emp = (Employee)var1.next();
            emp.showEmployeeDetails();
        }

    }

    public void addEmployee(Employee emp) {
        this.employeeList.add(emp);
    }

    public void removeEmployee(Employee emp) {
        this.employeeList.remove(emp);
    }
}


