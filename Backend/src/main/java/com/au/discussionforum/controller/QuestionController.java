package com.au.discussionforum.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.au.discussionforum.model.QuesKeywords;
import com.au.discussionforum.model.Question;
import com.au.discussionforum.model.Topic;
import com.au.discussionforum.model.User;
import com.au.discussionforum.model.UserTopic;
import com.au.discussionforum.model.dto.QuestionDTO;
import com.au.discussionforum.service.EmailService;
import com.au.discussionforum.service.QuesKeywordsService;
import com.au.discussionforum.service.QuestionService;
import com.au.discussionforum.service.TopicService;
import com.au.discussionforum.service.UserService;
import com.au.discussionforum.service.UserTopicService;

@RestController
public class QuestionController {
	@Autowired
	QuesKeywordsService quesKeywordsService;
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserTopicService userTopicService;
	
	@Autowired
	TopicService topicService;

	
	@Autowired
	EmailService emailService;
	
	static Logger log = LogManager.getLogger(QuestionController.class);

	
	@PostMapping(path = "/api/question/keywords")
    public List<Question> getQuestionsByKeyword(@RequestBody String quesKeywords) {
		List<String> keywords = Arrays.asList(quesKeywords.split(","));
		List<Question> questionList = quesKeywordsService.getQuestionByKeyword(keywords);
		questionList = questionService.getSortedQuestionList(questionList);
		
    	return questionList;
    }
	
	@GetMapping(path = "/api/userquestions/{uid}")
	public List<Question> getQuestionsByUser(@PathVariable("uid") int userId) {
		
		return questionService.getQuestionByUser(userId);
	}
	
	@PostMapping(path = "/api/addquestion")
	public void addQuestion(@RequestBody QuestionDTO questionDTO) {
		Question question = new Question();
		User user = userService.getUserByUserId(questionDTO.getUserId());
		Topic topic = topicService.getTopicByName(questionDTO.getTopicName());
		
		question.setTitle(questionDTO.getTitle());
		question.setBody(questionDTO.getBody());
		question.setMarked(false);
		question.setUser(user);
		question.setTopic(topic);
		
		question = questionService.addQuestion(question);
		
		List<String> keywords = Arrays.asList(questionDTO.getKeyword().split(","));
		
		for(String key : keywords) {
			QuesKeywords quesKeywords = new QuesKeywords();
			quesKeywords.setQuestion(question);
			quesKeywords.setKeyword(key);
			quesKeywordsService.addQuesKeywords(quesKeywords);
		}
		try {
			List<User> users = userTopicService.getUsersByTopic(topic.getTopicId());
			for(User u : users) {
				emailService.sendSimpleMessage(u.getEmail(), "New Question Added", "Someone asked Question related to " + topic.getTopicName()+" visit your profile for answering the question");
			}
		}catch(Exception e) {
			log.error("Failed To Send Email");
		}
	} 
	
	@GetMapping(path = "/api/questions/{uid}")
	public List<Question> getQuestionsByTopic(@PathVariable("uid") int userId) {
		List <UserTopic> topics=userTopicService.getTopicByUser(userId);
		List <Question> res=new ArrayList<>();
		for(UserTopic topic: topics) {
			res.addAll(questionService.getQuestionByTopic(topic.getTopic().getTopicId()));
		}
		
		return res;
	}
}
