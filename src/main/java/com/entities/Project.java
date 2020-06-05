package com.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@Column(name = "project_id")
	@GeneratedValue(generator = "project_id_gen", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(initialValue = 1, name = "project_id_gen", sequenceName = "project_id_seq")
	public Long projectId;

	@Column(name = "project_name")
	public String projectName;

	@Column(name = "date_of_start")
	public Date dateOfStart;

	@Column(name = "team_size")
	public Integer teamSize;

	public Project() {

	}

	public Project(Long projectId, String projectName, Date dateOfStart, int teamSize) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.dateOfStart = dateOfStart;
		this.teamSize = teamSize;
	}

	public Project(String projectName, Date dateOfStart, int teamSize) {
		this.projectName = projectName;
		this.dateOfStart = dateOfStart;
		this.teamSize = teamSize;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getDateOfStart() {
		return dateOfStart;
	}

	public void setDateOfStart(Date dateOfStart) {
		this.dateOfStart = dateOfStart;
	}

	public Integer getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}

}
