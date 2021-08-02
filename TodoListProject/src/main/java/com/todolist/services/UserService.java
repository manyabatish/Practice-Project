package com.todolist.services;

import com.todolist.models.User;

public interface UserService {
	
	/**
	 * Register user
	 * 
	 * @param user
	 * @return
	 */
	public User addUser(User user);

	/**
	 * Check if user already exists
	 * 
	 * @param email
	 * @return
	 */
	public boolean emailExist(String email);

	/**
	 * Fetch user by email
	 * 
	 * @param email
	 * @return
	 */
	User getUserByEmail(String email);
}
