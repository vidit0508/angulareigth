package com.services;

import java.nio.file.attribute.UserPrincipal;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.entities.ApplicationUser;
import com.repositories.ApplicationUserRepository;

@Service("applicationUserServiceImpl")
public class ApplicationUserServiceImpl implements ApplicationUserService {
	
	private ApplicationUserRepository applicationUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<ApplicationUser> optApplicationUser = applicationUserRepository.findByUsername(username);
		
		if (!optApplicationUser.isPresent())
			throw new UsernameNotFoundException("Username " + username + " not found.");

		ApplicationUserPrincipal principal = new ApplicationUserPrincipal(optApplicationUser.get());

		return principal;
	}

}
