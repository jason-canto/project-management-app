package com.canto.pma.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canto.pma.domain.Project;
import com.canto.pma.service.ProjectService;
import com.canto.pma.service.ValidationService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ValidationService validationService;

	@PostMapping
	public ResponseEntity<?> createProject(@Valid @RequestBody Project project, BindingResult result) {
		Map<String, String> errors = validationService.validate(result);
		if (errors != null) {
			return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
		}
		Project saved = projectService.save(project);
		return new ResponseEntity<Project>(saved, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Project>> findAllProjects() {
		List<Project> projects = projectService.findAll();
		return new ResponseEntity<>(projects, HttpStatus.OK);
	}

	@GetMapping("/{projectId}")
	public ResponseEntity<Project> findProjectByIdentifier(@PathVariable String projectId) {
		Project project = projectService.findProjectById(projectId);
		return new ResponseEntity<>(project, HttpStatus.OK);
	}

	@DeleteMapping("/{projectId}")
	public ResponseEntity<Void> deleteProject(@PathVariable String projectId) {
		projectService.deleteProject(projectId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
