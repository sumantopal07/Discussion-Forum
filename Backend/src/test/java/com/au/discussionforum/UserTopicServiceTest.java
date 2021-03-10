package com.au.discussionforum;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.au.discussionforum.dao.UserTopicRepository;
import com.au.discussionforum.model.Topic;
import com.au.discussionforum.model.User;
import com.au.discussionforum.model.UserTopic;

import com.au.discussionforum.service.UserTopicService;

@SpringBootTest
class UserTopicServiceTest {

	@Autowired
	private UserTopicService userTopicService;
	
	@MockBean
	private UserTopicRepository userTopicRepository;
	
	@Test
	void getUsersByTopicTest() {
		
		int topic_id=2;
		
		User user1= new User();
		user1.setUserId(1);
		user1.setEmail("abc@gmail.com");
		user1.setPassword("123");
		user1.setUsername("Sakshi");
		user1.setPhoto("img.jpg");
		
		User user2= new User(2,"pqr@gmail.com","111","Rupali","aa.jpg");
		
		Topic topic1= new Topic(2,"games");
		
		UserTopic user_topic1= new UserTopic(1,user1,topic1);
		UserTopic user_topic2= new UserTopic(2,user2,topic1);
	
		List<User> users= new ArrayList<>();
		users.add(user1); users.add(user2);
		
		when(userTopicRepository.findByTopicTopicId(topic_id)).thenReturn(Stream.of(user_topic1,user_topic2).collect(Collectors.toList()));
		assertEquals(users,userTopicService.getUsersByTopic(topic_id));
	
		String userTopic = "UserTopic [userTopicId=" + user_topic2.getUserTopicId() + ", user=" + user_topic2.getUser() + ", topic=" + user_topic2.getTopic() + "]";
		assertEquals(userTopic,user_topic2.toString());
	}
	
	@Test
	void getTopicByUserTest(){
	int user_id=1;
	
	User user1= new User(1,"abc@gmail.com","123","Sakshi","img.jpg");
	User user2= new User(2,"pqr@gmail.com","111","Rupali","aa.jpg");
	
	Topic topic1= new Topic(1,"games");
	Topic topic2= new Topic(2,"art");
	
	UserTopic user_topic1= new UserTopic(1,user1,topic1);
	UserTopic user_topic2= new UserTopic(2,user2,topic2);
	
	List<UserTopic> user= new ArrayList<>();
	user.add(user_topic1);
	user.add(user_topic2);
	
	when(userTopicRepository.findByUserUserId(user_id)).thenReturn(Stream.of(user_topic1,user_topic2).collect(Collectors.toList()));
	assertEquals(2,userTopicService.getTopicByUser(user_id).size());
	
	}
	
	@Test
	void addUserTopicTest() {
		User user1= new User(1,"abc@gmail.com","123","Sakshi","img.jpg");
		Topic topic1= new Topic(1,"games");
		UserTopic user_topic1= new UserTopic(1,user1,topic1);
		userTopicService.addUserTopic(user_topic1);
		verify(userTopicRepository,times(1)).save(user_topic1);
	}
}