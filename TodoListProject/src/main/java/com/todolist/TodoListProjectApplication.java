package com.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.todolist.servicesimpl.TaskServiceImpl;

@SpringBootApplication(scanBasePackages = "com.todolist.*")
public class TodoListProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoListProjectApplication.class, args);
	}

}
