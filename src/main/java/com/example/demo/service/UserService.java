package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;


public interface UserService {
	
	
	public boolean saveUser(User user);
	
	public List<User> getAllUsers();
	
	public User getUserById(Integer uid);
	
	public boolean deleteUserById(Integer uid);

}
