package com.todolist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.models.Task;
import com.todolist.servicesimpl.TaskServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Controller class for task
 * 
 * @author manyabatish
 * 
 *
 */
@RestController
@CrossOrigin
public class TaskController {

	@Autowired
	private TaskServiceImpl taskServiceImpl;

	/**
	 * Creating Task for User.
	 * 
	 * @param authentication
	 * @param task
	 * @return ResponseEntity
	 */
	@ApiOperation(value = "Creating Task for  User", tags = { "Task" })
	@PostMapping("/create-task")
	public ResponseEntity<Task> addTask(Authentication authentication, @RequestBody Task task) {
		task.setUsername(authentication.getName());
		return ResponseEntity.ok(taskServiceImpl.addTask(task));
	}

	/**
	 * Modify existing task.
	 * 
	 * @param task
	 * @return Task
	 */
	@ApiOperation(value = "Editing Task for User", tags = { "Task" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "User Task modified successfully", response = Task.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class) })
	@PutMapping("/edit-task")
	public Task editTask(@RequestBody Task task) {
		return taskServiceImpl.editTask(task);
	}

	/**
	 * Delete existing task by id.
	 * 
	 * @param id
	 */
	@ApiOperation(value = "Creating Task for  User", tags = { "Task" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User Task deleted successfully", response = Task.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class) })
	@DeleteMapping("/delete-task/{id}")
	public void deleteTask(@PathVariable("id") Integer id) {
		taskServiceImpl.deleteTask(id);
	}

	/**
	 * Get Task by task id
	 * 
	 * @param id
	 * @return fetched task by id
	 */
	@ApiOperation(value = "Getting Task for  User", tags = { "Task" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User Task fetched successfully", response = Task.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class) })
	@GetMapping("/get-task/{id}")
	public Task getTaskById(@PathVariable("id") Integer id) {
		return taskServiceImpl.getTaskById(id);
	}

	/**
	 * Get all tasks of logged in user
	 * 
	 * @param authentication
	 * @return tasks present under logged in user
	 */
	@ApiOperation(value = "Fetching Task for logged in User", tags = { "Task" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "User Tasks feteched successfully", response = Task.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class) })
	@GetMapping("/tasks-list")
	public List<Task> getTasksByUser(Authentication authentication) {
		return taskServiceImpl.findByUsername(authentication.getName());
	}

	/**
	 * Get all tasks present in database
	 * 
	 * @return all tasks present in DB
	 */
	@ApiOperation(value = "Getting all tasks present in database", tags = { "Task" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Tasks Fetched successfully", response = Task.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Void.class) })
	@GetMapping("/tasks")
	public List<Task> getTasks() {
		return taskServiceImpl.getTasks();
	}

}