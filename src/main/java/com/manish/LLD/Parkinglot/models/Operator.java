package com.manish.LLD.Parkinglot.models;

public class Operator extends BaseModel {
    private String name;
    private int employeeID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
