package com.todolist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.todolist.dao.TaskDao;
import com.todolist.models.Task;
import com.todolist.servicesimpl.TaskServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskControllerTest {

	@Autowired
	TaskServiceImpl taskServiceImpl;

	@MockBean
	TaskDao taskDao;

	Task RECORD_1 = new Task(1, "Task1", "2021-11-12", 2, "user1@gmail.com");
	Task RECORD_2 = new Task(2, "Task2", "2021-11-12", 2, "user1@gmail.com");
	Task RECORD_3 = new Task(3, "Task3", "2021-11-12", 2, "user2@gmail.com");
	Task RECORD_4 = new Task(4, "Task4", "2021-11-12", 2, "user2@gmail.com");
	
	@Test
	public void addTaskTestSuccess()
	{
		when(taskDao.save(RECORD_1)).thenReturn(RECORD_1);
		assertEquals(RECORD_1 , taskServiceImpl.add(RECORD_1));
	}
	
	@Test
	public void getTaskByUserTestSuccess()
	{
		when(taskDao.findByUsername("user1@gmail.com")).thenReturn(Stream.of(RECORD_1 , RECORD_2).collect(Collectors.toList()));
		assertEquals(2, taskServiceImpl.findByUsername("user1@gmail.com").size());
	}
	
	@Test
	public void getTasksTestSuccess()
	{
		when(taskDao.findAll()).thenReturn( Stream.of(RECORD_1 , RECORD_2, RECORD_3, RECORD_4).collect(Collectors.toList()));
		assertEquals(4, taskServiceImpl.getTasks().size());
	}

}
