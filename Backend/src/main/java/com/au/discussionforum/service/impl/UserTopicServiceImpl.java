package com.au.discussionforum.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.discussionforum.dao.UserTopicRepository;
import com.au.discussionforum.model.User;
import com.au.discussionforum.model.UserTopic;
import com.au.discussionforum.service.UserTopicService;

@Service
public class UserTopicServiceImpl implements UserTopicService{

	@Autowired
	UserTopicRepository userTopicRepository; 
	
	public List<User> getUsersByTopic(int topicId) {
		List<UserTopic> userTopic = userTopicRepository.findByTopicTopicId(topicId);
		List<User> users = new ArrayList<>();
		for(UserTopic usertopic : userTopic) {
			users.add(usertopic.getUser());
		}
		return users;
	}
	
	public List <UserTopic> getTopicByUser(int userId){
		return userTopicRepository.findByUserUserId(userId);
	}

	public UserTopic addUserTopic(UserTopic userTopic) {
		return userTopicRepository.save(userTopic);
	}

}
