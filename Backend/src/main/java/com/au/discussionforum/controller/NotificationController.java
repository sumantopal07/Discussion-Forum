package com.au.discussionforum.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.au.discussionforum.model.Question;
import com.au.discussionforum.model.QuestionNotification;
import com.au.discussionforum.service.QuestionNotificationService;

@RestController
public class NotificationController {
	
	
	@Autowired
	private QuestionNotificationService notificationService;
	
	@GetMapping(path = "/api/restriction/notifications/{uid}")
	public ResponseEntity<List<Question>> getQuestionsByUser(@PathVariable("uid") int userId) {
		List<Question> res=new ArrayList<>();
		res=notificationService.getQuestions(userId);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	@PostMapping(path = "/api/restriction/notificationsmarkall")
	public ResponseEntity<List<QuestionNotification>> markRead(@RequestBody Integer userId) {
		
		return new ResponseEntity<>(notificationService.markRead(userId),HttpStatus.OK);
	}
//	@PostMapping(path = "/api/notificationsmarkall")
//	public List<Question> markReadAll(@PathVariable("uid") int userId) {
//		List<Question> res=notificationService.getQuestions(userId);
//		return res;
//	}
}
