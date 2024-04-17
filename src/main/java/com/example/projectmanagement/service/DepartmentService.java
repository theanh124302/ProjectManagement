package com.example.projectmanagement.service;

import com.example.projectmanagement.entity.Department;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    public List<Department> getAllDepartments();

    public Optional<Department> getDepartmentById(Long id);

    public Department saveOrUpdateDepartment(Department department);

    public void deleteDepartmentById(Long id);
}
