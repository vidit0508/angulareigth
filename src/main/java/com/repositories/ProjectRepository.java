package com.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Project;

/*@Repository*/
public interface ProjectRepository extends JpaRepository<Project, Long> {

	List<Project> findAllByProjectName(String projectName);
	
	List<Project> findAllByDateOfStart(String dateofStart);
	
	List<Project> findAllByTeamSize(Integer teamSize);

}
