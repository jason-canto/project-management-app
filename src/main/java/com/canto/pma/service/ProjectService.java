package com.canto.pma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canto.pma.domain.Project;
import com.canto.pma.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository repository;

	public Project save(Project project) {
		return repository.save(project);
	}

	public List<Project> findAll() {
		return repository.findAll();
	}

	public Project findProjectById(String projectId) {
		return repository.findByIdentifier(projectId);
	}

	public void deleteProject(String projectId) {
		Project project = repository.findByIdentifier(projectId);
		if (project.getId() != null)
			repository.delete(project);
	}
}
