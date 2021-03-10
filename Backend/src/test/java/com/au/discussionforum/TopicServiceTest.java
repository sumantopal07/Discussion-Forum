package com.au.discussionforum;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.au.discussionforum.dao.TopicRepository;
import com.au.discussionforum.model.Topic;
import com.au.discussionforum.service.TopicService;

@SpringBootTest
class TopicServiceTest {

	@Autowired
	private TopicService topicService;
	
	@MockBean
	private TopicRepository topicRepository;
	
	@Test
	
	void getTopicByIdTest() {
		
		int topic_id=2;
		Topic topic= new Topic();
		topic.setTopicId(2);
		topic.setTopicName("games");
		
		when(topicRepository.findByTopicId(topic_id)).thenReturn(topic);
		assertEquals(2,topicService.getTopicById(topic_id).getTopicId());
		
		@SuppressWarnings("unused")
		Topic topic1= new Topic(topic.getTopicId(),topic.getTopicName());
	}
	
	@Test
	void getTopicByNameTest() {
		String topic_name = "Badminton";
		Topic topic = new Topic(1,"Badminton");
		
		when(topicRepository.findByTopicName(topic_name)).thenReturn(topic);
		assertEquals("Badminton",topicService.getTopicByName(topic_name).getTopicName());
	}

}