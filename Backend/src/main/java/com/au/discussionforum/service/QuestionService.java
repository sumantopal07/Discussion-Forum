package com.au.discussionforum.service;

import java.util.List;

import com.au.discussionforum.model.Question;

public interface QuestionService {
	List<Question> getSortedQuestionList(List<Question> questionList);
	List<Question> getQuestionByUser(int userId);
	Question addQuestion(Question q);
	List<Question> getQuestionByTopic(int topicId);
	Question getQuestionById(int quesId);
}
