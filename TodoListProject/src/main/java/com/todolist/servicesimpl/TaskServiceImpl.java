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

	@Override
	public Task addTask(Task task) {
		return taskDao.save(task);
	}

	@Override
	public Task getTaskById(Integer id) {
		return taskDao.getById(id);
	}

	@Override
	public Task editTask(Task task) {
		return taskDao.save(task);
	}

	@Override
	public void deleteTask(Integer id) {
		taskDao.deleteById(id);
	}

	@Override
	public List<Task> findByUsername(String username) {
		return taskDao.findByUsername(username);
	}

	@Override
	public List<Task> getTasks() {
		return taskDao.findAll();
	}

}
