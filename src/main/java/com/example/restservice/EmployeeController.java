package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

// Rest controller with a
@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeManager employeeManager;

    // Implementing a GET method to get the list of all employees as JSON
    @GetMapping(
            path = "/",
            produces = "application/json")

    public Employees getEmployees()
    {
        return employeeManager.getAllEmployees();
    }

    @PostMapping(
            path = "/",
            consumes = "application/json",
            produces = "application/json")

    public ResponseEntity<Object> addEmployee(
            @RequestBody Employee employee)
    {

        // Creating an ID of an employee
        // from the number of employees
        Integer id
                = employeeManager
                .getAllEmployees()
                .getEmployeeList()
                .size()
                + 1;

        employee.setId(id);

        employeeManager
                .addEmployee(employee);

        URI location
                = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(
                        employee.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .build();
    }

}
