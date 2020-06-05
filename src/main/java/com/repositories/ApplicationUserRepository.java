package com.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

	public Optional<ApplicationUser> findByUsername(String username);

}
