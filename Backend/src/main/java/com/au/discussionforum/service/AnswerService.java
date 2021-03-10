package com.au.discussionforum.service;

import java.util.List;

import com.au.discussionforum.model.Answer;

public interface AnswerService {
	List<Answer> getAnswerByQuesId(int quesId);
	Answer getAnswerByAnswerId(int ansId);
	void setCorrectAnswer(Answer answer);
	Boolean addAnswer(Answer answer);
	
}
