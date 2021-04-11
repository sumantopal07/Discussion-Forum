package com.au.discussionforum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.discussionforum.dao.UserAnswerRepository;
import com.au.discussionforum.model.Answer;
import com.au.discussionforum.model.User;
import com.au.discussionforum.model.UserAnswer;
import com.au.discussionforum.service.UserAnswerService;

@Service
public class UserAnswerServiceImpl implements UserAnswerService {

	@Autowired
	UserAnswerRepository userAnswerRepository;
	
	@Override
	public Boolean check(User user, Answer answer) {
		return userAnswerRepository.findByUserAndAnswer(user, answer).size()>0;
	}
	
	@Override
	public void addVote(UserAnswer userAnswer) {
		userAnswerRepository.save(userAnswer);
	}
}