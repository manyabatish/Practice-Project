package com.todolist.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.dao.TaskDao;
import com.todolist.models.Task;
import com.todolist.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao taskDao;

	public Task add(Task task) {
		return taskDao.save(task);
	}

	public Task getById(Integer id) {
		return taskDao.getById(id);
	}

	public Task edit(Task task) {
		return taskDao.save(task);
	}

	public void delete(Integer id) {
		taskDao.deleteById(id);
	}

	public List<?> findByUsername(String username) {
		return taskDao.findByUsername(username);
	}
	

}
