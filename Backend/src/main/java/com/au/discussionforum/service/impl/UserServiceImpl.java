package com.au.discussionforum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.discussionforum.dao.UserRepository;
import com.au.discussionforum.model.User;
import com.au.discussionforum.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    UserRepository userRepository;
	
	public User getUserByUsername(String username){
		return userRepository.findByUsername(username);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserByUserId(int id) {
		return userRepository.findByUserId(id);
	}

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
}
