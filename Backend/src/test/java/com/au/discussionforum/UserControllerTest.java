package com.au.discussionforum;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.au.discussionforum.controller.UserController;
import com.au.discussionforum.model.Topic;
import com.au.discussionforum.model.User;
import com.au.discussionforum.model.UserTopic;
import com.au.discussionforum.model.dto.UserSignupDTO;
import com.au.discussionforum.service.TopicService;
import com.au.discussionforum.service.UserService;
import com.au.discussionforum.service.UserTopicService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private UserService userService;
	
	@MockBean
	private UserTopicService userTopicService;
	
	@MockBean
	private TopicService topicService;
	
	@Test
	void checkUserTest() throws Exception {
		User user= new User(1,"abc@gmail.com","1234","Nisarg","img.jpg");
		User user2 = new User();
		user2.setUsername("Nisarg");
		user2.setPassword("1234");
		
		when(userService.getUserByUsername("Nisarg")).thenReturn(null);
		
		String url = "/api/login";
		MvcResult mvcResult = mockMvc.perform(
											post(url)
											.contentType("application/json")
											.content(objectMapper.writeValueAsString(user2))
										).andExpect(status().isOk()).andReturn();
		
		String actualJsonResponse = mvcResult.getResponse().getContentType();
		System.out.println(actualJsonResponse);
		assertEquals(null,actualJsonResponse);
	}

	@Test
	void addUserTest() throws JsonProcessingException, Exception {
		UserSignupDTO user= new UserSignupDTO();
		user.setSignupEmail("abc@gmail.com");
		user.setSignupPassword("123");
		user.setSignupPhoto("i.jpg");
		user.setSignupUsername("sakshi");
		user.setSignupTopic(new ArrayList<>(Arrays.asList("games","art")));
		
		User user1= new User();
		user1.setEmail(user.getSignupEmail());
		user1.setPassword(user.getSignupPassword());
		user1.setPhoto(user.getSignupPhoto());
		user1.setUserId(1);
		user1.setUsername(user.getSignupUsername());
		
		when(userService.addUser(user1)).thenReturn(user1);
		
		List<String> topic_list= new ArrayList<>();
		topic_list.add("games");
		topic_list.add("art");
		
		Topic topic= new Topic();
		topic.setTopicId(1);
		topic.setTopicName("games");
		
		UserTopic userTopic = new UserTopic();
		userTopic.setUserTopicId(1);
		userTopic.setUser(user1);
		userTopic.setTopic(topic);
		when(userTopicService.addUserTopic(userTopic)).thenReturn(userTopic);
		
		String url ="/api/signup";
		MvcResult mvcResult = mockMvc.perform(
											post(url)
											.contentType("application/json")
											.content(objectMapper.writeValueAsString(user))
										).andExpect(status().isOk()).andReturn();
		
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		String expectedJsonResponse = objectMapper.writeValueAsString(0);
		System.out.println(actualJsonResponse);
		System.out.println(expectedJsonResponse);
		assertEquals(actualJsonResponse,expectedJsonResponse);
	}
}