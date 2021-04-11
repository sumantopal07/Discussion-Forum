package com.au.discussionforum.controller;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.au.discussionforum.model.Question;
import com.au.discussionforum.model.QuestionNotification;
import com.au.discussionforum.model.User;
import com.au.discussionforum.model.UserTopic;
import com.au.discussionforum.model.dto.UserDTO;
import com.au.discussionforum.model.dto.UserSignupDTO;
import com.au.discussionforum.service.QuestionNotificationService;
import com.au.discussionforum.service.TopicService;
import com.au.discussionforum.service.UserService;
import com.au.discussionforum.service.UserTopicService;

@RestController
public class NotificationController {
	
	
	@Autowired
	private QuestionNotificationService notificationService;
	
	@GetMapping(path = "/api/notifications/{uid}")
	public List<Question> getQuestionsByUser(@PathVariable("uid") int userId) {
		List<Question> res=new ArrayList<>();
		res=notificationService.getQuestions(userId);
		return res;
	}
	
	@PostMapping(path = "/api/notificationsmarkall")
	public List<QuestionNotification> markRead(@RequestBody Integer userId) {
		
		return notificationService.markRead(userId);
	}
//	@PostMapping(path = "/api/notificationsmarkall")
//	public List<Question> markReadAll(@PathVariable("uid") int userId) {
//		List<Question> res=notificationService.getQuestions(userId);
//		return res;
//	}
}
