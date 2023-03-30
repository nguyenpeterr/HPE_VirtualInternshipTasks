package com.example.restservice;

import org.springframework.stereotype.Repository;

// Class responsible for initializing the Employees class
@Repository
public class EmployeeManager {
    private static Employees list = new Employees();

    // Static block is executed first
    // Hard-coded employees examples
    static {
        list.getEmployeeList().add(new Employee(1, "Peter", "Nguyen", "peternguyen@gmail.com", "Manager"));
        list.getEmployeeList().add(new Employee(2, "John", "Swanson", "jswanson@gmail.com", "Supervisor"));
        list.getEmployeeList().add(new Employee(3, "Michael", "Jackson", "aheehee@gmail.com", "Employee"));
    }

    // Returns the list of all employees
    public Employees getAllEmployees() {
        return list;
    }
    public void
    addEmployee(Employee employee)
    {
        list.getEmployeeList()
                .add(employee);

    }
}
