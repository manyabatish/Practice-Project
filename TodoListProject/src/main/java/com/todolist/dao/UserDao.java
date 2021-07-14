package com.todolist.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todolist.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	@Query("from User where email = :email")
	public User getUserByEmail(String email);

}
