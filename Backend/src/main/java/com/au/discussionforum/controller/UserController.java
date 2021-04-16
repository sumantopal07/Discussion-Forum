package com.au.discussionforum.controller;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.au.discussionforum.model.User;
import com.au.discussionforum.model.UserTopic;
import com.au.discussionforum.model.dto.LoginResponseDTO;
import com.au.discussionforum.model.dto.UserDTO;
import com.au.discussionforum.model.dto.UserSignupDTO;
import com.au.discussionforum.security.IJwtTokenProviderService;
import com.au.discussionforum.service.QuestionNotificationService;
import com.au.discussionforum.service.TopicService;
import com.au.discussionforum.service.UserService;
import com.au.discussionforum.service.UserTopicService;

@RestController
public class UserController {
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
    
    @Autowired
    private IJwtTokenProviderService jwtTokenProviderService;


	@Autowired
	private UserService userService;
	
	@Autowired
	private UserTopicService userTopicService;
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private QuestionNotificationService notificationService;
	
	static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping(path = "/api/allowed/login")
    public ResponseEntity<LoginResponseDTO> checkUser(@RequestBody UserDTO userDTO) {
		log.info("entered login");
			
    	User user = userService.getUserByUsername(userDTO.getUsername());
    	if(user==null) {
    		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    	}else {
    		if(BCrypt.checkpw(userDTO.getPassword(), user.getPassword())) {
    			LoginResponseDTO l = new LoginResponseDTO();
    			l.setUser(user);
    			l.setAccessToken(jwtTokenProviderService.createToken(user.getUsername(), user.getRoles()));
    			return new ResponseEntity<>(l,HttpStatus.OK);	
    		}
    	}
       
    	return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
	
	@PostMapping(path = "/api/allowed/signup")
	public ResponseEntity<String> addUser(@RequestBody UserSignupDTO userSignupDTO) {
		log.info("entered signup");
		User user = new User();
		user.setEmail(userSignupDTO.getSignupEmail());
		
		String password = BCrypt.hashpw(userSignupDTO.getSignupPassword(), BCrypt.gensalt());
		user.setPassword(password);
		user.setPhoto(userSignupDTO.getSignupPhoto());
		user.setUsername(userSignupDTO.getSignupUsername());
		
		if(userService.getUserByUsername(userSignupDTO.getSignupUsername()) != null) {
			return new ResponseEntity<>("Username already exists",HttpStatus.NOT_FOUND);
		}
		
		if(userService.getUserByEmail(userSignupDTO.getSignupEmail()) != null) {
			return new ResponseEntity<>("email already exists",HttpStatus.NOT_FOUND);
		}
		
		user = userService.addUser(user);
		
		List<String> topics = userSignupDTO.getSignupTopic();
		
		for(String topic : topics) {
			UserTopic userTopic = new UserTopic();
			userTopic.setUser(user);
			userTopic.setTopic(topicService.getTopicByName(topic));
			userTopicService.addUserTopic(userTopic);
		}
		
		return new ResponseEntity<>("account created successfully",HttpStatus.OK);

	}
}
