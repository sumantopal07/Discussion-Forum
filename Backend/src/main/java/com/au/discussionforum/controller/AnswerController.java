package com.au.discussionforum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.au.discussionforum.model.Answer;
import com.au.discussionforum.model.Question;
import com.au.discussionforum.model.User;
import com.au.discussionforum.model.dto.AnswerDTO;
import com.au.discussionforum.service.AnswerService;
import com.au.discussionforum.service.QuestionService;
import com.au.discussionforum.service.UserService;

@RestController
public class AnswerController {
	
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private QuestionService questionService;

	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/api/answer/{id}")
    public List<Answer> getAnswers(@PathVariable("id") int quesId) {
		
		return answerService.getAnswerByQuesId(quesId);
    }
	
	@PostMapping(path = "/api/answer/markcorrect")
	public void setCorrectAnswer(@RequestBody int ansId) {
		Answer answer = answerService.getAnswerByAnswerId(ansId);
		answer.setCorrect(true);
		Question question = answer.getQuestion();
		question.setMarked(true);
		questionService.addQuestion(question);
		answerService.setCorrectAnswer(answer);
	}
	
	@PostMapping(path = "/api/addanswers")
	public Boolean addAnswers(@RequestBody AnswerDTO answerDTO) {
		Answer answer = new Answer();
		
		User user = userService.getUserByUserId(answerDTO.getUserId());
		Question question = questionService.getQuestionById(answerDTO.getQuesId());
		
		answer.setUser(user);
		answer.setQuestion(question);
		answer.setCorrect(false);
		answer.setAnswerBody(answerDTO.getAnswerBody());
		return answerService.addAnswer(answer);
    }
}
