package com.luisadorno.employeemanagerserver.domain.employee.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.luisadorno.employeemanagerserver.domain.employee.exception.ResourceNotFoundException;
import com.luisadorno.employeemanagerserver.domain.employee.model.Employee;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    Iterable<Employee> getAllEmployees();

    Employee getEmployeeById(long id) throws ResourceNotFoundException;

    Employee updateEmployee(long id, Employee employee) throws ResourceNotFoundException;

    void deleteEmployee(long id) throws ResourceNotFoundException;
}
