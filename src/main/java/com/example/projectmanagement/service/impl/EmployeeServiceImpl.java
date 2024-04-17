package com.example.projectmanagement.service.impl;

import com.example.projectmanagement.dto.CreateEmployee;
import com.example.projectmanagement.dto.Role;
import com.example.projectmanagement.entity.Employee;
import com.example.projectmanagement.repository.DepartmentRepository;
import com.example.projectmanagement.repository.EmployeeRepository;
import com.example.projectmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee saveOrUpdateEmployee(CreateEmployee createEmployee) {
        Employee employee = new Employee();
        employee.setName(createEmployee.getName());
        employee.setGender(createEmployee.getGender());
        employee.setDepartment(departmentRepository.getReferenceById(createEmployee.getDepartment_id()));
        employee.setDateOfBirth(createEmployee.getDateOfBirth());
        employee.setRole(Role.USER);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findEmployeesByName(String name, Pageable pageable) {
        System.out.println(name);
        return employeeRepository.searchByName(name,pageable);
    }

    @Override
    public boolean isValidGender(String gender) {
        return gender != null && (gender.equals("Male") || gender.equals("Female"));
    }

    @Override
    public boolean isValidDateOfBirth(Date dateOfBirth) {
        Date currentDate = new Date(System.currentTimeMillis());
        Date minDateOfBirth = Date.valueOf("1990-01-01");
        return dateOfBirth != null && dateOfBirth.before(currentDate) && dateOfBirth.after(minDateOfBirth);
    }

}
