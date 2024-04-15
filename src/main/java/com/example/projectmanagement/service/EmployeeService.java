package com.example.projectmanagement.service;

import com.example.projectmanagement.dao.CreateEmployee;
import com.example.projectmanagement.dto.Employee;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public Optional<Employee> getEmployeeById(Long id);
    public Employee saveOrUpdateEmployee(CreateEmployee createEmployee);
    public void deleteEmployeeById(Long id);
    public List<Employee> findEmployeesByName(String name);
    public boolean isValidGender(String gender);
    public boolean isValidDateOfBirth(Date dateOfBirth);
}
