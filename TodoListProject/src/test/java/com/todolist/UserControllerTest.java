package com.todolist;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
public class UserControllerTest {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@MockBean
	UserDao userDao;
	
	User USER_1 = new User(1, "first123@gmail.com", "first", "last", "password");
	
	@Test
	public void addUserTestSuccess()
	{
		when(userDao.save(USER_1)).thenReturn(USER_1);
		assertEquals(userServiceImpl.add(USER_1), USER_1);
		
	}
}
