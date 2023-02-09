package com.huoji.gemtries.services;

import com.huoji.gemtries.models.User;
import com.huoji.gemtries.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

	@Autowired
	UserRepository repo;

	@Autowired
	PasswordEncoder encoder;


	public User register(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
	}
	public User updateUser(User user) {
		return repo.save(user);
	}

	public User getUserByUsername(String username) {
		Optional<User> op = repo.findByUsername(username);
		return op.orElse(null);
	}

	public User setHasSubmitted(User user) {
		user.setHasSubmitted(true);
		return repo.save(user);
	}

}
