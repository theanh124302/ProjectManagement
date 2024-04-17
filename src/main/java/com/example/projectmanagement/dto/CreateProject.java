package com.example.projectmanagement.dto;

import com.example.projectmanagement.entity.Employee;
import lombok.Data;

import java.util.Set;

@Data
public class CreateProject {
    private String name;
    private String description;
    private Long departmentId;
    private Long leaderId;
    Set<Employee> employees;
}
