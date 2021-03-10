package com.au.discussionforum;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.CoreMatchers.is;

import com.au.discussionforum.controller.AnswerController;
import com.au.discussionforum.model.Answer;
import com.au.discussionforum.model.Question;
import com.au.discussionforum.model.Topic;
import com.au.discussionforum.model.User;
import com.au.discussionforum.model.dto.AnswerDTO;
import com.au.discussionforum.service.AnswerService;
import com.au.discussionforum.service.QuestionService;
import com.au.discussionforum.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(AnswerController.class)
class AnswerControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private AnswerService answerService;
	
	@MockBean
	private QuestionService questionService;

	@MockBean
	private UserService userService;
	
	@Test
	void getAnswersTest() throws JsonProcessingException, Exception {
		
        int ques_id=2;
		
		User user1= new User(1,"abc@gmail.com","1234","Rupali","img.jpg");
		User user2= new User(2,"abc@gmail.com","1234","Aman","img.jpg");
		
		Topic topic1= new Topic(3,"games");
		Topic topic2= new Topic(4,"art");
		
		Question ques1= new Question(2,user1,topic1,"national game","Which is our national game?",false);
		Question ques2= new Question(2,user2,topic2,"color","Which is the color of peace?",false);
		
		List<Answer> answer= new ArrayList<Answer>();
		answer.add(new Answer(1,user1,ques1,"hockey is our national game",true));
		answer.add(new Answer(2,user2,ques2,"white color",true));
		
		when(answerService.getAnswerByQuesId(ques_id)).thenReturn(answer);
		
		String url = "/api/answer/{id}";
		MvcResult mvcResult = mockMvc.perform(
											get(url,2)
											.contentType("application/json")
											.content(objectMapper.writeValueAsString(answer))
										).andExpect(status().isOk()).andReturn();
		
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		String expectedJsonResponse = objectMapper.writeValueAsString(answer);
		assertEquals(actualJsonResponse,expectedJsonResponse);
		
	}
	
	@Test
	void setCorrectAnswer() throws JsonProcessingException, Exception {
		int ans_id=2;
		
		User user1= new User();
		user1.setUserId(1);
		user1.setEmail("abc@gmail.com");
		user1.setPassword("1234");
		user1.setUsername("sakshi");
		user1.setPhoto("img.jpg");
		
		Topic topic1= new Topic();
		topic1.setTopicId(3);
		topic1.setTopicName("games");
	
		
		Question ques1= new Question(2,user1,topic1,"national game","Which is our national game?",true);
		
		Answer ans= new Answer(2,user1,ques1,"hockey is our national game",true);
		when(answerService.getAnswerByAnswerId(ans_id)).thenReturn(ans);
		when(questionService.addQuestion(ques1)).thenReturn(ques1);
		Mockito.doNothing().when(answerService).setCorrectAnswer(ans);

		String url = "/api/answer/markcorrect";
		mockMvc.perform(post(url)
								.contentType("application/json")
								.content(objectMapper.writeValueAsString(ans_id))
						).andExpect(status().isOk());
		
	
		
	}
	
	@Test
	void addAnswersTest() throws JsonProcessingException, Exception {
		AnswerDTO ans= new AnswerDTO();
		ans.setUserId(1);
		ans.setQuesId(1);
		ans.setAnswerBody("this is ans body");
		
		User user1= new User();
		user1.setUserId(1);
		user1.setEmail("abc@gmail.com");
		user1.setPassword("1234");
		user1.setUsername("sakshi");
		user1.setPhoto("img.jpg");
		
		Topic topic1= new Topic();
		topic1.setTopicId(3);
		topic1.setTopicName("games");
		
		Question ques1= new Question();
		ques1.setQuesId(1);
		ques1.setUser(user1);
		ques1.setTopic(topic1);
		ques1.setTitle("national game");
		ques1.setBody("which is our national game");
		ques1.setMarked(true);
		
		
		Answer answer= new Answer();
		answer.setAnsId(1);
		answer.setUser(user1);
		answer.setQuestion(ques1);
		answer.setCorrect(true);
		answer.setAnswerBody(ans.getAnswerBody());
		
		assertEquals(user1,answer.getUser());
		
		when(answerService.addAnswer(answer)).thenReturn(true);
		String url = "/api/addanswers";

	mockMvc.perform(
							post(url)
							.contentType("application/json")
							.content(objectMapper.writeValueAsString(answer)))
	                        .andReturn();

	}
}
