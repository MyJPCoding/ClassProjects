package com.john.beltexam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.john.beltexam.models.Task;
import com.john.beltexam.models.User;
import com.john.beltexam.services.TaskService;
import com.john.beltexam.services.UserService;

@Controller
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserService userService;
	
	
	// passing team ModelAttribute for form, check if logged in, pass in all Team for jsp page
	@GetMapping("/tasks/new")
	public String createTeam(@ModelAttribute("task") Task task, Model model, HttpSession session) {
		
		if(session.getAttribute("userid") == null) {
			return "redirect:/login";
		}
		//pass in team model info
		model.addAttribute("tasks", taskService.allTasks());
		// When using a model to filter on the jsp side, make sure to set the model and add attribute
		Long user_id = (Long) session.getAttribute("userid");
		User currentUser = userService.findUserById(user_id);
		model.addAttribute("user", currentUser);
		List<User> users = userService.allUsers();
		model.addAttribute("users", users);
		return "createTask.jsp";
		
	}
	
	//Creation of the team, check if logged in, if errors-  render error page, if no errors save new team
	@PostMapping("/create-task")
	public String submitTeam(@Valid @ModelAttribute("task") Task task, BindingResult result, HttpSession session, Model model) {
		if(session.getAttribute("userid") == null) {
			return "redirect:/login";
		}		
		if(result.hasErrors()) {
			return "createTask.jsp";
		}
		
		//creating new user model to be what is in session
		Long user_id = (Long) session.getAttribute("userid");
		User currentUser = userService.findUserById(user_id);
		if (taskService.areTasksMoreThanThree(task.getAssignee().getId())) {
			model.addAttribute("user", currentUser);
			List<User> users = userService.allUsers();
			model.addAttribute("users", users);
			Boolean cannotAddAnotherUser = true;
			model.addAttribute("tooManyTasks", cannotAddAnotherUser);
			return "createTask.jsp";
		}
		task.setCreator(currentUser);
		taskService.save(task);
		return "redirect:/tasks/new";
		
	}
	
	// posting jsp page, checking if logged in, find unique team by id, pass in team in model
		@GetMapping("/tasks/{id}")
		public String showTask(@PathVariable("id") Long id, Model model, HttpSession session) {
			if(session.getAttribute("userid") == null) {
				return "redirect:/login";
			}
			Task task = taskService.findById(id);
			model.addAttribute("task", task);
			return "showTask.jsp";
		}
	
	// posting jsp page, checking if logged in, find unique team by id, pass in team in model
	@GetMapping("/tasks/{id}/edit")
	public String findOne(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userid") == null) {
			return "redirect:/login";
		}
		Long currentUser = (Long) session.getAttribute("userid");
		User loggedInUser = userService.findUserById(currentUser);
		
		Task currentTask = taskService.findById(id);
		User assigned = currentTask.getAssignee();
		
		if(loggedInUser.getId() != assigned.getId() ) {
			
			return "redirect:/tasks";
		} else {
			Boolean isAssignee = true;
			model.addAttribute("isAssignee", isAssignee);
		}
		Task task = taskService.findById(id);
		model.addAttribute("task", task);
		List<User> users = userService.allUsers();
		model.addAttribute("users", users);
		return "editTask.jsp";
		
	}
	
	// edit team by POST, find team by looking up by id in url, validate edit fits validation requirements 
	@PostMapping("/edit-task/{id}")
	public String editTeam(@PathVariable("id") Long id, 
						   @Valid @ModelAttribute("task") Task task, 
						   BindingResult result,
						   HttpSession session,
						   Model model) {
		
		if(session.getAttribute("userid") == null) {
			return "redirect:/login";
		}
		if (taskService.areTasksMoreThanThree(task.getAssignee().getId())) {
			Task currenttask = taskService.findById(id);
			model.addAttribute("task", currenttask);
			List<User> users = userService.allUsers();
			model.addAttribute("users", users);
			Boolean cannotAddAnotherUser = true;
			model.addAttribute("tooManyTasks", cannotAddAnotherUser);
			return "editTask.jsp";
		}
		if(result.hasErrors()) {
			Task currenttask = taskService.findById(id);
			model.addAttribute("task", currenttask);
			List<User> users = userService.allUsers();
			model.addAttribute("users", users);
			return "editTask.jsp";
		}
		Long user_id = (Long) session.getAttribute("userid");
		User currentUser = userService.findUserById(user_id);
		task.setCreator(currentUser);
		taskService.save(task);
		return "redirect:/create-task";
	}
	
	// delete by POST, find team id by url id, void delete by id,  redirect to create team
	@PostMapping("/tasks/{id}/delete")
	public String delete(@PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userid") == null) {
			return "redirect:/login";
		}
		taskService.delete(id);
		return "redirect:/tasks";
	}
	
	//get jsp page, show all teams, pass in all teams into teams model
	@GetMapping("/tasks")
	public String all(Model model, HttpSession session) {
		if(session.getAttribute("userid") == null) {
			return "redirect:/login";
		}		
		model.addAttribute("tasks", taskService.allTasks());
		return "allTasks.jsp";
	}
	
	
	
}