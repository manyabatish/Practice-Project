package com.todolist.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.dao.UserDao;
import com.todolist.model.User;
import com.todolist.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public User add(User user) {
		return userDao.save(user);
		
	}

	public boolean emailExist(String email) {
		if(userDao.getUserByEmail(email)!= null)
			return true;
		else 
			return false;
	}

}
