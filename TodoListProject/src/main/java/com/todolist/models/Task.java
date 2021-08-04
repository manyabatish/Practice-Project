package com.todolist.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table (name = "tasks")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int taskId;
	
	@NotBlank(message = "Name cannot be blank!")
	@NotNull(message = "Name can't be null!")
	private String name;
	
	@NotBlank(message = "Due date cannot be blank!")
	@NotNull(message = "Due date can't be null!")
	private String dueDate;
	
	@Positive(message = "Enter positive numbers only!")
	private int priority;
	
	private String username;

	}
	
