package com.au.discussionforum.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.discussionforum.dao.QuestionRepository;
import com.au.discussionforum.model.Question;
import com.au.discussionforum.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
    QuestionRepository questionRepository;
	 
	public List<Question> getSortedQuestionList(List<Question> questionList){	
		
		List<Question> sortedQuestionList = new ArrayList<>();
		Map<Question,Integer> questionCount = new HashMap<>();
		for(Question q : questionList) {
            if(questionCount.containsKey(q)) {
                Integer  count = questionCount.get(q);
                questionCount.put(q, ++count);
            } else {
                questionCount.put(q,1);
            }
        }
		
		Map<Question,Integer> sortedQuestionMap = questionCount.entrySet().stream()
                								  .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                								  .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                								   (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		for(Question question : sortedQuestionMap.keySet()) {
			sortedQuestionList.add(question);
		}
		return sortedQuestionList;
		
	}

	public List<Question> getQuestionByUser(int userId) {
		return questionRepository.findByUserUserId(userId);
	}
	
	public Question addQuestion(Question q) {
		return questionRepository.save(q);
	}
	
	public List<Question> getQuestionByTopic(int topicId) {
		List <Question> temp=questionRepository.findByTopicTopicId(topicId);
		List <Question> res=new ArrayList<>();
		for(Question t: temp) {
			if(!t.isMarked())
				res.add(t);
		}
		return res;
	}

	public Question getQuestionById(int quesId) {
		return questionRepository.findByQuesId(quesId);
	}
	
}
