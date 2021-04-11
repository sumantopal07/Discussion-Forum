package com.au.discussionforum.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.au.discussionforum.dao.QuesKeywordsRepository;
import com.au.discussionforum.dao.QuestionNotificationRepository;
import com.au.discussionforum.model.QuesKeywords;
import com.au.discussionforum.model.Question;
import com.au.discussionforum.model.QuestionNotification;
import com.au.discussionforum.service.QuesKeywordsService;
import com.au.discussionforum.service.QuestionNotificationService;

@Service
public class QuestionNotificationServiceImpl implements QuestionNotificationService{
	@Autowired
	QuestionNotificationRepository notificationRepository;

	@Override
	public List<Question> getQuestions(int userId) {
		List<QuestionNotification> notifiations = notificationRepository.findByUserUserId(userId);
		List<Question> questions=new ArrayList<>();
		for(QuestionNotification  q : notifiations)
		{
			if(q.getReadComment()==0)
				questions.add(q.getQuestion());
		}
		return questions;
	}

	@Override
	public List<QuestionNotification> markRead(Integer userId) {
		// TODO Auto-generated method stub
		List<QuestionNotification> notifiations = notificationRepository.findByUserUserId(userId);
		for(QuestionNotification  q : notifiations)
		{
			q.setReadComment(1);
			notificationRepository.save(q);
		}
		return notifiations;
	}
	
	
}
