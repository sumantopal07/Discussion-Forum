package com.au.discussionforum.service;

import java.util.List;

import com.au.discussionforum.model.User;
import com.au.discussionforum.model.UserTopic;

public interface UserTopicService {
	List<User> getUsersByTopic(int topicId);
	List <UserTopic> getTopicByUser(int userId);
	UserTopic addUserTopic(UserTopic userTopic);
}
