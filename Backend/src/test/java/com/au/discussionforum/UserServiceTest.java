package com.au.discussionforum;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.au.discussionforum.dao.UserRepository;
import com.au.discussionforum.model.User;
import com.au.discussionforum.service.UserService;

@SpringBootTest
class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	
	
	@Test
	void getUserbyUsernameTest() {
		
		String username="Rupali";
		User user= new User();
		user.setUserId(1);
		user.setEmail("abc@gmail.com");
		user.setPassword("1234");
		user.setUsername("Rupali");
		user.setPhoto("img.jpg");
	
		
		when(userRepository.findByUsername(username))
		.thenReturn(user);
         assertEquals("Rupali", userService.getUserByUsername(username).getUsername());
         
         String userString = "User [userid=" + user.getUserId() + ", email=" + user.getEmail() + ", password=" + user.getPassword() + ", username=" + user.getUsername()
			+ ", photo=" + user.getPhoto() + "]";
         
         assertEquals(userString,user.toString());
         
	}
	
	@Test
	void getAllUsersTest() {
		
		User user1= new User(1,"abc@gmail.com","1234","Aman","img.jpg");
		User user2= new User(2,"pqr@gmail.com","098","Rupali","pic.jpg");
		
		when(userRepository.findAll()).thenReturn(Stream.of(user1,user2).collect(Collectors.toList()));
		assertEquals(2,userService.getAllUsers().size());
	}
	
	@Test
	void getUserByUserIdTest() {
		
		int user_id=2;
		User user= new User(2,"abc@gmail.com","1234","Aman","img.jpg");
		
		when(userRepository.findByUserId(user_id))
		.thenReturn(user);
         assertEquals(2, userService.getUserByUserId(user_id).getUserId());
	}
	
	
	@Test
	void addUserTest() {
		
		User user= new User(1,"abc@gmail.com","1234","Aman","img.jpg");

		userService.addUser(user);
		verify(userRepository,times(1)).save(user);
	}
	
	@Test
	void getUserByEmailTest() {
		
		User user= new User(2,"abc@gmail.com","1234","Aman","img.jpg");
		when(userRepository.findByEmail("abc@gmail.com")).thenReturn(user);
		
		assertEquals("abc@gmail.com",userService.getUserByEmail("abc@gmail.com").getEmail());
	}
}