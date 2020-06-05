package com.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Project;
import com.repositories.ProjectRepository;

@RestController
@CrossOrigin
@RequestMapping("project")
public class ProjectResource {

	@Autowired
	private ProjectRepository projectRepository;

	@GetMapping(value = "check")
	public String checkFlow() {
		return "Working";
	}

	@GetMapping(value = "getall")
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@PostMapping(value = "createorupdate")
	public Project createProject(@RequestBody Project project) {

		Project up = null;

		if (project.getProjectId() != null && project.getProjectId() != 0) {

			Optional<Project> optProject = projectRepository.findById(project.getProjectId());
			if (optProject.isPresent()) {
				up = optProject.get();
				up.setDateOfStart(project.getDateOfStart());
				up.setProjectName(project.getProjectName());
				up.setTeamSize(project.getTeamSize());
				up = projectRepository.save(project);
			} else {
				return null;
			}
		}

		up = projectRepository.save(project);

		return up;

	}

	@DeleteMapping(value = "delete")
	public Long deleteProject(@RequestParam(name = "projectId") Long projectId) {

		if (projectId != null) {

			Optional<Project> optProject = projectRepository.findById(projectId);
			if (optProject.isPresent()) {
				projectRepository.delete(optProject.get());
				return projectId;
			}
		}

		return -1L;
	}

	@GetMapping(value = "search")
	public List<Project> searchProject(@RequestParam("searchby") String searchby, @RequestParam("value") String value) {

		List<Project> searchList = new ArrayList<>();

		if (searchby.equalsIgnoreCase("projectName")) {
			searchList = projectRepository.findAllByProjectName(value);
		} else if (searchby.equalsIgnoreCase("projectId")) {
			Optional<Project> optProject = projectRepository.findById(Long.parseLong(value));
			if (optProject.isPresent()) {
				searchList.add(optProject.get());
			}
		} else if (searchby.equalsIgnoreCase("dateOfStart")) {
			searchList = projectRepository.findAllByDateOfStart(value);
		} else if (searchby.equalsIgnoreCase("teamSize")) {
			searchList = projectRepository.findAllByTeamSize(Integer.parseInt(value));
		}

		return searchList;
	}
}
