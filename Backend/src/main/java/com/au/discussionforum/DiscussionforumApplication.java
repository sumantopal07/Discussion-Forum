package com.au.discussionforum;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.au.discussionforum.dao.TopicRepository;
import com.au.discussionforum.model.Topic;

@SpringBootApplication
@EnableAsync
public class DiscussionforumApplication {

	@Autowired
	private TopicRepository topicRepository;
	
	@PostConstruct
	public void initTopics() {
		try{topicRepository.save(new Topic("Java"));}catch(Exception e){}
		try{topicRepository.save(new Topic("C++"));}catch(Exception e){}
		try{topicRepository.save(new Topic("NodeJs"));}catch(Exception e){}
		try{topicRepository.save(new Topic("Flutter"));}catch(Exception e){}
		try{topicRepository.save(new Topic("Php"));}catch(Exception e){}
		try{topicRepository.save(new Topic("React Native"));}catch(Exception e){}
		try{topicRepository.save(new Topic("Angular"));}catch(Exception e){}
		try{topicRepository.save(new Topic("Spring Framework"));}catch(Exception e){}
		try{topicRepository.save(new Topic("Kafka"));}catch(Exception e){}
		try{topicRepository.save(new Topic("C# .NET"));}catch(Exception e){}
		try{topicRepository.save(new Topic("Go"));}catch(Exception e){}
		
	}
	public static void main(String[] args) {
		SpringApplication.run(DiscussionforumApplication.class);
	}

}
