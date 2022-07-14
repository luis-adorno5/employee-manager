package com.luisadorno.employeemanagerserver.domain.employee.services;

import com.luisadorno.employeemanagerserver.domain.core.exception.ResourceNotFoundException;
import com.luisadorno.employeemanagerserver.domain.employee.model.Employee;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    Iterable<Employee> getAllEmployees();

    Employee getEmployeeById(long id) throws ResourceNotFoundException;

    Employee updateEmployee(long id, Employee employee) throws ResourceNotFoundException;

    void deleteEmployee(long id) throws ResourceNotFoundException;
}
