package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	public UserRepo userRepo;

	@Override
	public boolean saveUser(User user) {
		User savedUser = userRepo.save(user);

		return savedUser.getUid() != null;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(Integer uid) {

		Optional<User> byId = userRepo.findById(uid);
		if (byId.isPresent()) {
			return byId.get();
		} else
			return null;
	}

	@Override
	public boolean deleteUserById(Integer uid) {

		if (userRepo.existsById(uid)) {
			userRepo.deleteById(uid);

		}
		return false;
	}

}
