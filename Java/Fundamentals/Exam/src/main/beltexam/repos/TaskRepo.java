package com.john.beltexam.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.john.beltexam.models.Task;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {
	List<Task> findAll();
}
