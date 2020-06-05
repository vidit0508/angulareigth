package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "application_role")
public class ApplicationUserRole {

	@Id
	@Column(name = "application_role_id")
	@SequenceGenerator(initialValue = 1, name = "user_id_gen", sequenceName = "user_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_gen")
	private Long applicationRoleId;

	@Column(name = "role_name_to_display")
	private String roleNameToDisplay;

	@Column(name = "role_name_to_db")
	private String roleNameForDb;

	public ApplicationUserRole() {
	}

	public Long getApplicationRoleId() {
		return applicationRoleId;
	}

	public void setApplicationRoleId(Long applicationRoleId) {
		this.applicationRoleId = applicationRoleId;
	}

	public String getRoleNameToDisplay() {
		return roleNameToDisplay;
	}

	public void setRoleNameToDisplay(String roleNameToDisplay) {
		this.roleNameToDisplay = roleNameToDisplay;
	}

	public String getRoleNameForDb() {
		return roleNameForDb;
	}

	public void setRoleNameForDb(String roleNameForDb) {
		this.roleNameForDb = roleNameForDb;
	}

}
