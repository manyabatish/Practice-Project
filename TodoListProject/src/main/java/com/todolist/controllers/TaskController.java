package com.todolist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.models.Task;
import com.todolist.servicesimpl.TaskServiceImpl;

@RestController
public class TaskController {

	@Autowired
	private TaskServiceImpl taskServiceImpl;

	@PostMapping("/addTask")
	public Task addTask(Authentication authentication, @RequestBody Task task) {
		task.setUsername(authentication.getName());
		return taskServiceImpl.add(task);
	}

	@PutMapping("/editTask")
	public Task editTask(@RequestBody Task task) {
		return taskServiceImpl.edit(task);
	}

	@DeleteMapping("/deleteTask/{id}")
	public void deleteTask(@PathVariable("id") Integer id) {
		taskServiceImpl.delete(id);
	}

	@GetMapping("/getTask/{id}")
	public Task getTaskById(@PathVariable("id") Integer id) {
		return taskServiceImpl.getById(id);
	}

	@GetMapping("/tasksList")
	public List<Task> getTasksByUser(Authentication authentication) {
		return taskServiceImpl.findByUsername(authentication.getName());
	}
	
	@GetMapping("/tasks")
	public List<Task> getTasks() {
		return taskServiceImpl.getTasks();
	}
	

}
