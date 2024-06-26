package com.example.projectmanagement.service;

import com.example.projectmanagement.dto.CreateProject;
import com.example.projectmanagement.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    public List<Project> getAllProjects();
    public Optional<Project> getProjectById(Long id);
    public Project saveOrUpdateProject(CreateProject createProject);
    public void deleteProjectById(Long id);
    public List<Project> findProjectsByName(String name);
}
