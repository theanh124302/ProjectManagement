package com.example.projectmanagement.service.impl;

import com.example.projectmanagement.dto.Project;
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
    public Project saveOrUpdateProject(Project project) {
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
