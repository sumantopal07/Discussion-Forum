package com.au.discussionforum;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.au.discussionforum.dao.AnswerRepository;
import com.au.discussionforum.model.Answer;
import com.au.discussionforum.model.Question;
import com.au.discussionforum.model.Topic;
import com.au.discussionforum.model.User;
import com.au.discussionforum.service.AnswerService;

@SpringBootTest
class AnswerServiceTest {

	@Autowired
	private AnswerService answerService;
	
	@MockBean
	private AnswerRepository answerRepository;
	
	
	@Test
	void getAnswerByQuesIdTest() {
		
		int ques_id=2;
		
		User user1= new User(2,"abc@gmail.com","1234","Rupali","img.jpg");
		User user2= new User(1,"abc@gmail.com","1234","Aman","img.jpg");
		
		Topic topic1= new Topic(3,"games");
		Topic topic2= new Topic(4,"art");
		
		Question ques1= new Question(1,user1,topic1,"national game","Which is our national game?",false);
		Question ques2= new Question(2,user2,topic2,"color","Which is the color of peace?",false);
		
		List<Answer> answer= new ArrayList<Answer>();
		answer.add(new Answer(1,user1,ques1,"hockey is our national game",true));
		answer.add(new Answer(2,user2,ques2,"white color",true));
		
		when(answerRepository.findByQuestionQuesId(ques_id)).thenReturn(answer);
		
		assertEquals(answer,answerService.getAnswerByQuesId(ques_id));
	}

	@Test
	void getAnswerByAnswerIdTest() {
		
		int ans_id=1;
		User user= new User(1,"abc@gmail.com","1234","Aman","img.jpg");
		Topic topic= new Topic(3,"games");
		Question ques= new Question(1,user,topic,"national game","Which is our national game?",false);
		
		Answer ans= new Answer(1,user,ques,"hockey is our national game",true);
		
		when(answerRepository.findByAnsId(ans_id)).thenReturn(ans);
		assertEquals(ans,answerService.getAnswerByAnswerId(ans_id));
	}
	
	@Test
	void setCorrectAnswerTest() {
		
		User user= new User(1,"abc@gmail.com","1234","Aman","img.jpg");
		Topic topic= new Topic(3,"games");
		Question ques= new Question(1,user,topic,"national game","Which is our national game?",false);
		
		Answer ans= new Answer(1,user,ques,"hockey is our national game",true);
		
		answerService.setCorrectAnswer(ans);
		verify(answerRepository,times(1)).save(ans);
	}
	
	@Test
	void addAnswerTest() {
		User user= new User(1,"abc@gmail.com","1234","Aman","img.jpg");
		Topic topic= new Topic(3,"games");
		Question ques= new Question(1,user,topic,"national game","Which is our national game?",false);
		
		Answer ans= new Answer(1,user,ques,"hockey is our national game",false);
		
		answerService.addAnswer(ans);
		verify(answerRepository,times(1)).save(ans);
		
		when(answerService.addAnswer(ans)).thenThrow(new IllegalStateException());
		answerService.addAnswer(ans);
	}
	
	@Test
	void addAnswerCatchTest() {
		User user= new User(1,"abc@gmail.com","1234","Aman","img.jpg");
		Topic topic= new Topic(3,"games");
		Question ques= new Question(1,user,topic,"national game","Which is our national game?",false);
		
		Answer ans= new Answer(1,user,ques,"hockey is our national game",false);
		
		when(answerService.addAnswer(ans)).thenThrow(new IllegalStateException());
		answerService.addAnswer(ans);
		verify(answerRepository,times(1)).save(ans);

	}
}