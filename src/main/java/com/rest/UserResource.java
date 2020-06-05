package com.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.ApplicationUser;

@RestController
@RequestMapping("user")
public class UserResource {

	@PostMapping(value = "login")
	public ApplicationUser doLogin(@RequestBody ApplicationUser applicationUser) {
		
		return null;
	}

}
