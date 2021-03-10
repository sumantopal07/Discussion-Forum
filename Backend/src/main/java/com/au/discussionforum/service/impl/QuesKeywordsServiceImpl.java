package com.au.discussionforum.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.discussionforum.dao.QuesKeywordsRepository;
import com.au.discussionforum.model.QuesKeywords;
import com.au.discussionforum.model.Question;
import com.au.discussionforum.service.QuesKeywordsService;

@Service
public class QuesKeywordsServiceImpl implements QuesKeywordsService{
	@Autowired
	QuesKeywordsRepository quesKeywordsRepository;
	
	public List<Question> getQuestionByKeyword(List<String> keyword){
		List<QuesKeywords> quesKeywords = quesKeywordsRepository.findByKeywordIn(keyword);
		List<Question> questions = new ArrayList<>();
		for(QuesKeywords quesKeyword : quesKeywords) {
			questions.add(quesKeyword.getQuestion());
		}
			
		return questions;
	}

	public void addQuesKeywords(QuesKeywords quesKeywords) {
		quesKeywordsRepository.save(quesKeywords);		
	}
}
