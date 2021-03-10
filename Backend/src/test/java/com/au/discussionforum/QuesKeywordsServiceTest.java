package com.au.discussionforum;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.au.discussionforum.dao.QuesKeywordsRepository;
import com.au.discussionforum.model.QuesKeywords;
import com.au.discussionforum.model.Question;
import com.au.discussionforum.model.Topic;
import com.au.discussionforum.model.User;
import com.au.discussionforum.service.QuesKeywordsService;

@SpringBootTest
class QuesKeywordsServiceTest {

	@Autowired
	private QuesKeywordsService quesKeywordsService;
	
	@MockBean
	private QuesKeywordsRepository quesKeywordsRepository;
	
	@Test
	void addQuesKeywordsTest() {
		
		User user= new User(2,"abc@gmail.com","1234","Rupali","img.jpg");
		Topic topic= new Topic(3,"games");
		Question ques= new Question(1,user,topic,"national game","Which is our national game?",false);
		
		QuesKeywords quesKeyword= new QuesKeywords(1,ques,"national");
		
		quesKeywordsService.addQuesKeywords(quesKeyword);
		verify(quesKeywordsRepository,times(1)).save(quesKeyword);
	
	}
	
	@Test
	void getQuestionByKeywordTest() {
		
		List<String> keywords= new ArrayList<>();
		keywords.add("national");
		keywords.add("color");
		keywords.add("bird");
	
		
		User user1= new User(2,"abc@gmail.com","1234","Rupali","img.jpg");
		Topic topic1= new Topic(3,"country");
		Question ques1= new Question(1,user1,topic1,"national bird","Which is our national bird?",false);
		
		QuesKeywords quesKeyword1= new QuesKeywords(1,ques1,"national");
		
		User user2= new User(3,"abc@gmail.com","1234","Sakshi","img.jpg");
		Topic topic2= new Topic(4,"art");
		Question ques2= new Question(2,user2,topic2,"color","Which is the color of peace?",false);
		
		QuesKeywords quesKeyword2= new QuesKeywords();
		quesKeyword2.setQuesKeywordsId(2);
		quesKeyword2.setQuestion(ques2);
		quesKeyword2.setKeyword("color");
		
		User user3= new User();
		user3.setUserId(4);
		user3.setEmail("abc@gmail.com");
		user3.setPassword("1234");
		user3.setUsername("Rupali");
		user3.setPhoto("img.jpg");
		
		Topic topic3= new Topic();
		topic3.setTopicId(3);
		topic3.setTopicName("birds");
		
		Question ques3= new Question();
		ques3.setQuesId(1);
		ques3.setUser(user3);
		ques3.setTopic(topic3);
		ques3.setTitle("fly");
		ques3.setBody("Which is the fastest bird?");
		ques3.setMarked(false);
		
		QuesKeywords quesKeyword3= new QuesKeywords(3,ques3,"bird");
		
		String quesKeywords = "QuesKeywords [quesKeywordsId=" + quesKeyword3.getQuesKeywordsId() + ", question=" + quesKeyword3.getQuestion() + ", keyword=" + quesKeyword3.getKeyword()
				+ "]";
		
		assertEquals(quesKeyword3.toString(),quesKeywords);

		List<Question> ques= new ArrayList<>();
		ques.add(ques1);
		ques.add(ques2);
		ques.add(ques3);
		
		when(quesKeywordsRepository.findByKeywordIn(keywords)).thenReturn(Stream.of(quesKeyword1,quesKeyword2,quesKeyword3).collect(Collectors.toList()));
		assertEquals(ques,quesKeywordsService.getQuestionByKeyword(keywords));
		
	}	
	
}