package com.au.discussionforum.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.au.discussionforum.model.Question;

public interface QuestionService {
	List<Question> getSortedQuestionList(List<Question> questionList);
	Page<Question> getQuestionByUser(int userId,int page);
	Question addQuestion(Question q);
	List<Question> getQuestionByTopic(int topicId);
	Question getQuestionById(int quesId);
}
