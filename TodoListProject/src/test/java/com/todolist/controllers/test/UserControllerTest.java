package com.todolist.controllers.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.todolist.dao.UserDao;
import com.todolist.models.User;
import com.todolist.servicesimpl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserControllerTest {

	@Autowired
	UserServiceImpl userServiceImpl;

	@MockBean
	UserDao userDao;

	User USER_1 = new User(1, "first123@gmail.com", "first", "last", "password");
	User USER_2 = new User(2, "second123@gmail.com", "first", "last", "password");

	
}
