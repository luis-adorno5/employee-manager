package com.luisadorno.employeemanagerserver.domain.employee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luisadorno.employeemanagerserver.domain.employee.exception.ResourceNotFoundException;
import com.luisadorno.employeemanagerserver.domain.employee.model.Employee;
import com.luisadorno.employeemanagerserver.domain.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Employee with id: {%s}", id)));
        return employee;
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) throws ResourceNotFoundException {
        Employee employeeToUpdate = getEmployeeById(id);
        employeeToUpdate.setFirstName(employee.getFirstName());
        employeeToUpdate.setLastName(employee.getLastName());
        employeeToUpdate.setEmailId(employee.getEmailId());
        return employeeRepository.save(employeeToUpdate);
    }

    @Override
    public void deleteEmployee(long id) throws ResourceNotFoundException {
        Employee employeeToDelete = getEmployeeById(id);
        employeeRepository.delete(employeeToDelete);
    }

}
