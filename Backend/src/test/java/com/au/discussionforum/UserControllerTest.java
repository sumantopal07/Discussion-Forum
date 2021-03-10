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

import com.au.discussionforum.controller.UserController;
import com.au.discussionforum.model.User;
import com.au.discussionforum.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private UserService userService;
	
	@Test
	void checkUserTest() throws Exception {
		User user= new User(1,"abc@gmail.com","1234","Nisarg","img.jpg");
		User user2 = new User();
		user2.setUsername("Nisarg");
		user2.setPassword("1234");
		
		when(userService.getUserByUsername("Nisarg")).thenReturn(user);
		
		String url = "/api/login";
		MvcResult mvcResult = mockMvc.perform(
											post(url)
											.contentType("application/json")
											.content(objectMapper.writeValueAsString(user2))
										).andExpect(status().isOk()).andReturn();
		
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		String expectedJsonResponse = objectMapper.writeValueAsString(user);
		System.out.println(actualJsonResponse);
		System.out.println(expectedJsonResponse);
		assertEquals(actualJsonResponse,expectedJsonResponse);
	}
}
