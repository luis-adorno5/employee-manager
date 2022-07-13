package com.luisadorno.employeemanagerserver.domain.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luisadorno.employeemanagerserver.domain.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
