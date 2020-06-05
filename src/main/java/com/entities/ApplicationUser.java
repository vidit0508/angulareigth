package com.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "application_user")
public class ApplicationUser {

	@Id
	@Column(name = "application_user_id")
	@SequenceGenerator(initialValue = 1, name = "user_id_gen", sequenceName = "user_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_gen")
	private Long applicationUserId;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role_mapping", joinColumns = {
			@JoinColumn(name = "application_user_id", referencedColumnName = "application_user_id") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "application_role_id", name = "application_role_id") })
	private Set<ApplicationUserRole> roleSet = new HashSet<>();

	public ApplicationUser() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getApplicationUserId() {
		return applicationUserId;
	}

	public void setApplicationUserId(Long applicationUserId) {
		this.applicationUserId = applicationUserId;
	}

	public Set<ApplicationUserRole> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<ApplicationUserRole> roleSet) {
		this.roleSet = roleSet;
	}

}
