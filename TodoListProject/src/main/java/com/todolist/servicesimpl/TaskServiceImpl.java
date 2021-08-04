package com.todolist.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.dao.TaskDao;
import com.todolist.exceptions.ServicesException;
import com.todolist.models.Task;
import com.todolist.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao taskDao;

	@Override
	public Task addTask(Task task) {
		Task taskDetails = null;
		try {
			taskDetails = taskDao.save(task);
		} catch (Exception e) {
			throw new ServicesException("Exception occurred while saving task details to table.");
		}
		return taskDetails;

	}

	@Override
	public Task getTaskById(Integer id) {
		Task taskDetails = null;
		try {
			taskDetails = taskDao.getById(id);
		} catch (Exception e) {
			throw new ServicesException("Task Not Found : " + id);

		}
		return taskDetails;
	}

	@Override
	public Task editTask(Task task) {
		Task taskDetails = null;
		try {
			taskDetails = taskDao.save(task);
		} catch (Exception e) {
			throw new ServicesException("Exception occurred while editing task details.");
		}
		return taskDetails;
	}

	@Override
	public void deleteTask(Integer id) {
		if (id == null || id < 0) {
			throw new ServicesException("Exception occured due to invalid task id.");
		} else {
			taskDao.deleteById(id);
		}

	}

	@Override
	public List<Task> findByUsername(String username) {
		List<Task> tasks = null;
		try {
			tasks = taskDao.findByUsername(username);
		} catch (Exception e) {
			throw new ServicesException("Exception occurred while Fetching tasks details.");
		}
		return tasks;
	}

	@Override
	public List<Task> getTasks() {
		List<Task> tasks = null;
		try {
			tasks = taskDao.findAll();
		} catch (Exception e) {
			throw new ServicesException("Exception occurred while Fetching tasks details.");
		}
		return tasks;
	}

}
