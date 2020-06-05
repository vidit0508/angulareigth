package com.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.entities.ApplicationUser;
import com.entities.ApplicationUserRole;

public class ApplicationUserPrincipal implements UserDetails {
	
	private ApplicationUser applicationUser;
	
	public ApplicationUserPrincipal(ApplicationUser applicationUser) {
		this.applicationUser = applicationUser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> setRoles = new HashSet<>();
		for (ApplicationUserRole role : applicationUser.getRoleSet())
			setRoles.add(new SimpleGrantedAuthority(role.getRoleNameToDisplay()));

		List<GrantedAuthority> result = new ArrayList<>(setRoles);

		return result;
	}

	@Override
	public String getPassword() {
		return applicationUser.getPassword();
	}

	@Override
	public String getUsername() {
		return applicationUser.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
