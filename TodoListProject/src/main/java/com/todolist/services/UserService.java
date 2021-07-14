package com.todolist.services;

import com.todolist.models.User;

public interface UserService {
	
	public User add(User user);

	public boolean emailExist(String email);

	User getUserByEmail(String email);
}
