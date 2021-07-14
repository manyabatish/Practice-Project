package com.todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.exceptions.EmailExistsException;
import com.todolist.model.User;
import com.todolist.serviceimpl.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserServiceImpl userServiceImpl;

	@PostMapping("/signUp")
	public User registerNewUserAccount(@RequestBody User userDetails) throws EmailExistsException {
		if (userServiceImpl.emailExist(userDetails.getEmail())) {
			throw new EmailExistsException("There is an account with that email adress:" + userDetails.getEmail());
		}
		else {
		User user = new User();
		user.setEmail(userDetails.getEmail());
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());

		user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
		
		System.out.println(user);
		return userServiceImpl.add(user);
		}
	}

}
