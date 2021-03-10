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
		
		User user1= new User();
		user1.setUserId(1);
		user1.setEmail("abc@gmail.com");
		user1.setPassword("1234");
		user1.setUsername("Rupali");
		user1.setPhoto("img.jpg");
		
		User user2= new User(2,"mnp@gmail.com","900","Sakshi","img.jpg");
		User user3= new User(3,"abc@gmail.com","1234","Aman","img.jpg");
		Topic topic1= new Topic(1,"country");
		Question ques1= new Question();
		ques1.setQuesId(1);
		ques1.setUser(user1);
		ques1.setTopic(topic1);
		ques1.setTitle("national bird");
		ques1.setBody("Which is our national bird?");
		ques1.setMarked(false);
		
		Topic topic2= new Topic();
		topic2.setTopicId(2);
		topic2.setTopicName("art");
		
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
		
		String ques4 = "Question [quesId=" + ques3.getQuesId() + ", user=" + ques3.getUser() + ", topic=" + ques3.getTopic() + ", title=" + ques3.getTitle() + ", body="
				+ ques3.getBody() + ", marked=" + ques3.isMarked() + "]";
		
		assertEquals(ques4,ques3.toString());
		
	}
	
	@Test
	void getQuestionByIdTest() {
		User user1= new User(1,"mnp@gmail.com","900","Sakshi","img.jpg");
		Topic topic1= new Topic(1,"games");
		
		int ques_id=3;
		
		Question ques3= new Question(3,user1,topic1,"football","When was first match of football held? ",false);
		when(questionRepository.findByQuesId(ques_id)).thenReturn(ques3);
		
		assertEquals(ques3.toString(),questionService.getQuestionById(ques_id).toString());
	}
	
	@Test
	void getQuestionByTopicTest() {
		User user1= new User(1,"mnp@gmail.com","900","Sakshi","img.jpg");
		Topic topic1= new Topic(1,"art");
		Question ques1= new Question(1,user1,topic1,"colr","Which is color of peace?",false);
		Question ques2= new Question(2,user1,topic1,"football","When was first match of football held? ",true);
		
		int t_id=1;
		
		List<Question> q= new ArrayList<>();
		q.add(ques1);
		q.add(ques2);
		
		when(questionRepository.findByTopicTopicId(t_id)).thenReturn(q);
		
		assertEquals(1,questionService.getQuestionByTopic(t_id).size());
	}
}