package com.au.discussionforum.controller;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.au.discussionforum.model.User;
import com.au.discussionforum.model.UserTopic;
import com.au.discussionforum.model.dto.UserDTO;
import com.au.discussionforum.model.dto.UserSignupDTO;
import com.au.discussionforum.service.TopicService;
import com.au.discussionforum.service.UserService;
import com.au.discussionforum.service.UserTopicService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserTopicService userTopicService;
	
	@Autowired
	private TopicService topicService;
	
	@PostMapping(path = "/api/login")
    public User checkUser(@RequestBody UserDTO userDTO) {
			
    	User user = userService.getUserByUsername(userDTO.getUsername());
    	if(user==null) {
    		return null;
    	}else {
    		if(BCrypt.checkpw(userDTO.getPassword(), user.getPassword())) {
    			return user;
    		}
    	}
       
        return null;
    }
	
	@PostMapping(path = "/api/signup")
	public int addUser(@RequestBody UserSignupDTO userSignupDTO) {
		User user = new User();
		user.setEmail(userSignupDTO.getSignupEmail());
		
		String password = BCrypt.hashpw(userSignupDTO.getSignupPassword(), BCrypt.gensalt());
		user.setPassword(password);
		user.setPhoto(userSignupDTO.getSignupPhoto());
		user.setUsername(userSignupDTO.getSignupUsername());
		
		if(userService.getUserByUsername(userSignupDTO.getSignupUsername()) != null) {
			return 1;
		}
		
		if(userService.getUserByEmail(userSignupDTO.getSignupEmail()) != null) {
			return 2;
		}
		
		user = userService.addUser(user);
		
		List<String> topics = userSignupDTO.getSignupTopic();
		
		for(String topic : topics) {
			UserTopic userTopic = new UserTopic();
			userTopic.setUser(user);
			userTopic.setTopic(topicService.getTopicByName(topic));
			userTopicService.addUserTopic(userTopic);
		}
		
		return 0;

	}
}
