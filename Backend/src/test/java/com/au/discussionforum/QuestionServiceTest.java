package com.au.discussionforum;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.au.discussionforum.dao.QuestionRepository;
import com.au.discussionforum.model.Question;
import com.au.discussionforum.model.Topic;
import com.au.discussionforum.model.User;
import com.au.discussionforum.service.QuestionService;

@SpringBootTest
class QuestionServiceTest {

	@Autowired
	private QuestionService questionService;
	
	@MockBean
	private QuestionRepository questionRepository;
	
	@Test
	void getQuestionByUserTest() {
		
		int user_id=2;
		
		List<Question> questions= new ArrayList<Question>();
		User user1= new User(2,"abc@gmail.com","1234","Rupali","img.jpg");
		User user2= new User(1,"abc@gmail.com","1234","Aman","img.jpg");
		
		Topic topic1= new Topic(3,"games");
		Topic topic2= new Topic(4,"art");
		
		questions.add(new Question(1,user1,topic1,"national game","Which is our national game?",false));
		questions.add(new Question(2,user2,topic2,"color","Which is the color of peace?",false));
		
		when(questionRepository.findByUserUserId(user_id)).thenReturn(questions);
		assertArrayEquals(questions.toArray(),questionService.getQuestionByUser(user_id).toArray());
	}

	@Test
	void addQuestionTest() {
		User user1= new User(2,"abc@gmail.com","1234","Rupali","img.jpg");
		Topic topic1= new Topic(3,"games");
		Question ques1= new Question(1,user1,topic1,"national game","Which is our national game?",false);
		
		questionService.addQuestion(ques1);
		verify(questionRepository,times(1)).save(ques1);
		
	}
	
	@Test
	void getSortedQuestionListTest() {
		
		List<Question> q_List= new ArrayList<Question>();
		
		
		User user1= new User(1,"abc@gmail.com","1234","Rupali","img.jpg");
		User user2= new User(2,"mnp@gmail.com","900","Sakshi","img.jpg");
		User user3= new User(3,"abc@gmail.com","1234","Aman","img.jpg");
		Topic topic1= new Topic(1,"country");
		Question ques1= new Question(1,user1,topic1,"national bird","Which is our national bird?",false);
		
		Topic topic2= new Topic(2,"art");
		Question ques2= new Question(2,user2,topic2,"colr","Which is color of peace?",false);
		
		Topic topic3= new Topic(3,"games");
		Question ques3= new Question(3,user3,topic3,"football","When was first match of football held? ",false);
		
		q_List.add(ques1);
		q_List.add(ques1);
		q_List.add(ques1);
		q_List.add(ques2);
		q_List.add(ques2);
		q_List.add(ques3);
		
		List<Question> q_sorted_List= new ArrayList<Question>();
		q_sorted_List.add(ques1);
		q_sorted_List.add(ques2);
		q_sorted_List.add(ques3);

		System.out.println(questionService.getSortedQuestionList(q_List));
		assertEquals(q_sorted_List,questionService.getSortedQuestionList(q_List));
		
	}
}
