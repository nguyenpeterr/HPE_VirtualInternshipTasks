package com.example.restservice;

import java.util.List;
import java.util.ArrayList;

// Class to store the list of employees
public class Employees {
    private List<Employee> employeeList;

    // Method to return the list of employees
    public List<Employee> getEmployeeList() {
        if(employeeList == null) {
            employeeList = new ArrayList<>();
        }
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
