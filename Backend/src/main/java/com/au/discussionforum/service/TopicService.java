package com.au.discussionforum.service;

import com.au.discussionforum.model.Topic;

public interface TopicService {
	Topic getTopicById(int topicId);
	Topic getTopicByName(String topicName);
}
