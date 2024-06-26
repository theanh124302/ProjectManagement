package com.example.projectmanagement.service;

import com.example.projectmanagement.dto.CreateEmployee;
import com.example.projectmanagement.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public Optional<Employee> getEmployeeById(Long id);
    public Employee saveOrUpdateEmployee(CreateEmployee createEmployee);
    public void deleteEmployeeById(Long id);
    public Page<Employee> findEmployeesByName(String name, Pageable pageable);
    public boolean isValidGender(String gender);
    public boolean isValidDateOfBirth(Date dateOfBirth);
}
