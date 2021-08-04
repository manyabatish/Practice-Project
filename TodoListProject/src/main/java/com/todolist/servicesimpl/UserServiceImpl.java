
package com.todolist.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.dao.UserDao;
import com.todolist.exceptions.ServicesException;
import com.todolist.models.User;
import com.todolist.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User addUser(User user){
		User userDetails = null;
		try {
			userDetails = userDao.save(user);
		} catch (Exception e) {
			throw new ServicesException("Exception occurred while saving task details to table.");
		}
		return userDetails;
	}

	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);

	}

	@Override
	public boolean emailExist(String email) {
		if (userDao.getUserByEmail(email) != null)
			return true;
		else
			return false;
	}

}
