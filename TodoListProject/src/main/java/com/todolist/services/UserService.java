package com.todolist.services;

import com.todolist.exceptions.ServicesException;
import com.todolist.models.User;

public interface UserService {
	
	/**
	 * Register user.
	 * 
	 * @param user
	 * @return User
	 */
	public User addUser(User user);

	/**
	 * Check if user already exists.
	 * 
	 * @param email
	 * @return boolean value
	 */
	public boolean emailExist(String email);

	/**
	 * Fetch user by email.
	 * 
	 * @param email
	 * @return User
	 */
	User getUserByEmail(String email);
}
