package com.john.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.john.beltexam.models.Task;
import com.john.beltexam.models.User;
import com.john.beltexam.repos.TaskRepo;
import com.john.beltexam.repos.UserRepo;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepo taskRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	public List<Task> allTasks(){
		return taskRepo.findAll();
	}
	
	public Task save(Task t) {
		return taskRepo.save(t);
	}
	
	public Task findById(Long id) {
		Optional<Task> team = taskRepo.findById(id);
		
		if(team.isPresent()) {
			return team.get();
		}else {
			return null;
		}
	}
	
	public void delete(Long id) {
		taskRepo.deleteById(id);
	}
	
	
//	VALIDATION - LIMITING
	public Boolean areTasksMoreThanThree(Long id) {
		Optional<User> user = userRepo.findById(id);
		
		if(user.isPresent()) {
			if(user.get().getAssignedtasks().size() > 2) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

}