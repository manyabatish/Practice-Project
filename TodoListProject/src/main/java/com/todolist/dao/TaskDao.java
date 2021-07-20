package com.todolist.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todolist.models.Task;

@Repository
public interface TaskDao extends JpaRepository<Task, Integer> {

	List<Task> findByUsername(String username);
}
