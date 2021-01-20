package com.john.beltexam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.john.beltexam.models.User;
import com.john.beltexam.services.UserService;
import com.john.beltexam.validators.UserValidator;

@Controller
public class UserController {
    private final UserService userService;
    private UserValidator userValidator;
    
    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    @RequestMapping("/")
    public String registerForm(@ModelAttribute("user") User user) {
        return "users/registration.jsp";
    }
    
    @RequestMapping("/login")
    public String login() {
        return "users/login.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    	userValidator.validate(user, result);
    	
    	if(result.hasErrors()) {
    		return "users/registration.jsp";
    	}
    	User newUser = userService.registerUser(user);
    	session.setAttribute("userid", newUser.getId());
    	return "redirect:/tasks";
    	//home page TO MAIN CONTROLLEr
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, 
    						@RequestParam("password") String password, 
    						Model model, 
    						HttpSession session) {
    	
    	if(userService.authenticateUser(email, password)) {
    		// successful
    		User thisUser = userService.findByEmail(email);
    		session.setAttribute("userid", thisUser.getId());
    		return "redirect:/tasks";
    	}
        // failure
    	model.addAttribute("error", "Invalid login");
    	return "users/login.jsp";
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
    	return "redirect:/homepage";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
    	return "redirect:/login";
    }
}