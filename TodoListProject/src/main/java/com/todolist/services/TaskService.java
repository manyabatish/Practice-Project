package com.todolist.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todolist.models.Task;

@Service
public interface TaskService {

	public Task add(Task task);

	public Task getById(Integer id);

	public Task edit(Task task);

	public void delete(Integer id);
	
	List<?> findByUsername(String username);
}
