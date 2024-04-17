package com.example.projectmanagement.service.impl;

import com.example.projectmanagement.dto.CreateProject;
import com.example.projectmanagement.entity.Project;
import com.example.projectmanagement.repository.DepartmentRepository;
import com.example.projectmanagement.repository.ProjectRepository;
import com.example.projectmanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    @Cacheable("projects")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    @CacheEvict(value = "projects", allEntries = true)
    public Project saveOrUpdateProject(CreateProject createProject) {
        Project project = new Project();
        project.setName(createProject.getName());
        project.setDescription(createProject.getDescription());
        project.setLeaderId(createProject.getLeaderId());
        project.setDepartment(departmentRepository.getReferenceById(createProject.getDepartmentId()));
        project.setEmployees(createProject.getEmployees());
        return projectRepository.save(project);
    }

    @Override
    @CacheEvict(value = "projects", allEntries = true)
    public void deleteProjectById(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public List<Project> findProjectsByName(String name) {
        return projectRepository.findByName(name);
    }
}
