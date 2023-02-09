package com.huoji.gemtries.controllers;

import com.huoji.gemtries.models.User;
import com.huoji.gemtries.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return service.register(user);
	}

	@GetMapping
	public User getById(Principal principal){
		return service.getUserByUsername(principal.getName());
	}

	@PutMapping
	public User updateUser(@RequestBody User user){
		return service.updateUser(user);
	}


}
