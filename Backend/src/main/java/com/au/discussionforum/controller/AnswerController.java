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
import com.au.discussionforum.model.UserAnswer;
import com.au.discussionforum.model.dto.AnswerDTO;
import com.au.discussionforum.model.dto.UserAnswerDTO;
import com.au.discussionforum.service.AnswerService;
import com.au.discussionforum.service.QuestionService;
import com.au.discussionforum.service.UserAnswerService;
import com.au.discussionforum.service.UserService;

@RestController
public class AnswerController {

	@Autowired
	private AnswerService answerService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserAnswerService userAnswerService;

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
		answer.setVotes(0);
		return answerService.addAnswer(answer);
	}

	@PostMapping(path = "/api/upvoteanswer")
	public int upvoteAnswer(@RequestBody UserAnswerDTO userAnswerDTO) {
		/*
		 * userId
		 * ansId
		 * up/down
		*/
		int userId       = userAnswerDTO.getUserId();
		int ansId        = userAnswerDTO.getAnsId();
		Boolean voteType = userAnswerDTO.getMark(); 
		
		Answer answer = answerService.getAnswerByAnswerId(ansId);
		User user     = userService.getUserByUserId(userId);
		if(user == null || answer ==null){
			return -1; //user or answer does'nt exist
			
		}
		
		if(answer.getUser().getUserId() == userId ){
			return 0; //user can't upvote/downvote his/her own answer
		}
		if(userAnswerService.check(user, answer)){
			return 1; //user can't upvote/downvote an answer more than once
		}
		UserAnswer userAnswer = new UserAnswer();
		userAnswer.setUser(user);
		userAnswer.setMark(voteType);
		userAnswer.setAnswer(answer);
		
		userAnswerService.addVote(userAnswer);
		answer.setVotes(voteType ? answer.getVotes()+1 : answer.getVotes()-1  );
		answerService.setCorrectAnswer(answer);
		return 2; //success
    }
}