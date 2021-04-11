package com.au.discussionforum.service;

import java.util.List;

import com.au.discussionforum.model.Question;
import com.au.discussionforum.model.QuestionNotification;
import com.au.discussionforum.model.User;


public interface QuestionNotificationService {
	List<Question> getQuestions(int userId);
	List<QuestionNotification> markRead(Integer userId);
}
