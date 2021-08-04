package com.todolist.services.test;

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
import com.todolist.exceptions.ServicesException;
import com.todolist.models.User;
import com.todolist.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

	@Autowired
	UserService userService;

	@MockBean
	UserDao userDao;

	User USER_1 = new User(1, "first123@gmail.com", "first", "last", "password");
	User USER_2 = new User(2, "second123@gmail.com", "first", "last", "password");

	@Test
	public void addUserTest_success() throws ServicesException {
		when(userDao.save(USER_1)).thenReturn(USER_1);
		assertEquals(userService.addUser(USER_1), USER_1);

	}

	@Test
	public void addUserTest_fails() throws ServicesException {
		when(userDao.save(USER_1)).thenReturn(USER_1);
		assertNotEquals(USER_2, userService.addUser(USER_1));

	}
}
