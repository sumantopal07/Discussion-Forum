package com.au.discussionforum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.discussionforum.dao.TopicRepository;
import com.au.discussionforum.model.Topic;
import com.au.discussionforum.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService{
	@Autowired
	TopicRepository topicRepository;

	public Topic getTopicById(int topicId) {
		return topicRepository.findByTopicId(topicId);
	}

	public Topic getTopicByName(String topicName) {
		return topicRepository.findByTopicName(topicName);
	}
	
}
