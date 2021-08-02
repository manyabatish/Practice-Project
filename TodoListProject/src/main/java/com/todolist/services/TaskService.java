package com.todolist.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.todolist.models.Task;

@Service
public interface TaskService {

	/**
	 * Create task for User
	 *
	 * @param task
	 * @return Task
	 */
	public Task addTask(Task task);

	/**
	 * Get User Task by id
	 * 
	 * @param id
	 * @return
	 */
	public Task getTaskById(Integer id);

	/**
	 * Modify existing User Task
	 * 
	 * @param task
	 * @return
	 */
	public Task editTask(Task task);

	/**
	 * Delete User Task by id
	 * 
	 * @param id
	 */
	public void deleteTask(Integer id);
	
	/**
	 * Get Tasks by logged in User
	 * 
	 * @param username
	 * @return
	 */
	List<Task> findByUsername(String username);

	List<Task> getTasks();
}
