package com.todolist.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todolist.exceptions.EmailExistsException;
import com.todolist.exceptions.ServicesException;
import com.todolist.models.Task;

@Service
public interface TaskService {

	/**
	 * Create task for User
	 *
	 * @param task
	 * @return Task
	 * @throws EmailExistsException
	 */
	public Task addTask(Task task);

	/**
	 * Get User Task by id
	 * 
	 * @param id
	 * @return
	 * @throws TaskNotFoundException
	 * @throws ServicesException
	 */
	public Task getTaskById(Integer id);

	/**
	 * Modify existing User Task
	 * 
	 * @param task
	 * @return
	 * @throws ServicesException
	 */
	public Task editTask(Task task);

	/**
	 * Delete User Task by id
	 * 
	 * @param id
	 * @throws ServicesException
	 */
	public void deleteTask(Integer id);

	/**
	 * Get Tasks by logged in User
	 * 
	 * @param username
	 * @return
	 * @throws ServicesException
	 */
	List<Task> findByUsername(String username);

	List<Task> getTasks() throws ServicesException;
}
