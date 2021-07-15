package com.todolist.services;

import java.util.List;

import com.todolist.models.Task;

public interface TaskService {

	public Task add(Task task);

	public Task getById(Integer id);

	public Task edit(Task task);

	public void delete(Integer id);
	
	List<?> findByUsername(String username);
}
