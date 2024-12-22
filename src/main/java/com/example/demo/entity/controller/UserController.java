package com.example.demo.entity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	public UserService userService;

	@GetMapping("/")
	public String loadForm(Model model) {
		
		User userobj=new User();
		model.addAttribute("user",userobj);
		// Here the model is used to send the data from the controller to the ui.
		
		
		return "index";
	}

	@PostMapping("/user")

	public String handleSubmit(User user,  Model model) {
		
		boolean isSaved = userService.saveUser(user);
		
		if(isSaved) {
			model.addAttribute("smsg", "User saved sucessfully");
		}else {
			model.addAttribute("esmsg", "User not saved");
		}
		
		// Model is used to responsible to send the data controller to the Ui. in the form of key and value pair.

		return "index";
	}

	@GetMapping("/users")
	public String getUsers(Model model) {
		
		List<User> allUsers = userService.getAllUsers();
		
		model.addAttribute("users", allUsers);
		return "users";
	}

}
