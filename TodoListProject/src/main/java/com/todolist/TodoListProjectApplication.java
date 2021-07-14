package com.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.todolist.*")
public class TodoListProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoListProjectApplication.class, args);
	}

}
