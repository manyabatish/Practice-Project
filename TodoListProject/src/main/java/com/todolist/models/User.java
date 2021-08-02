package com.todolist.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull(message = "Email can't be null!")
	@Email(message = "Enter valid email address!")
	private String email;

	@NotBlank(message = "First Name cannot be blank!")
	@NotNull(message = "First Name can't be null!")
	private String firstName;

	@NotBlank(message = "Last Name cannot be blank!")
	private String lastName;

	@Size(min =5, message = "Password should be minimum 5 characters")
	private String password;

}
