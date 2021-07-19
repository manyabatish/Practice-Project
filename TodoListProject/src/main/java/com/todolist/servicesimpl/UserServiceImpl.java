
package com.todolist.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.dao.UserDao;
import com.todolist.models.User;
import com.todolist.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User add(User user) {
		return userDao.save(user);
	}

	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	public boolean emailExist(String email) {
		if (userDao.getUserByEmail(email) != null)
			return true;
		else
			return false;
	}

}
