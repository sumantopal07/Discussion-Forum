package com.au.discussionforum.service;

import java.util.List;
import com.au.discussionforum.model.User;

public interface UserService {
	
	User getUserByUsername(String username);
	List<User> getAllUsers();
	User getUserByUserId(int id);
	User addUser(User user);
	User getUserByEmail(String email);

}
