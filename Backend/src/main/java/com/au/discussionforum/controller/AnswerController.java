package com.au.discussionforum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@GetMapping(path = "/api/restriction/answer/{id}")
	public ResponseEntity<List<Answer>> getAnswers(@PathVariable("id") int quesId) {
		return new ResponseEntity<>(answerService.getAnswerByQuesId(quesId),HttpStatus.OK);
	}

	@PostMapping(path = "/api/restriction/answer/markcorrect")
	public ResponseEntity<String>  setCorrectAnswer(@RequestBody int ansId) {
		Answer answer = answerService.getAnswerByAnswerId(ansId);
		answer.setCorrect(true);
		Question question = answer.getQuestion();
		question.setMarked(true);
		questionService.addQuestion(question);
		answerService.setCorrectAnswer(answer);
		return new ResponseEntity<>("Answer Added Successfully",HttpStatus.OK);
	}

	@PostMapping(path = "/api/restriction/addanswers")
	public ResponseEntity<Boolean>  addAnswers(@RequestBody AnswerDTO answerDTO) {
		Answer answer = new Answer();

		User user = userService.getUserByUserId(answerDTO.getUserId());
		Question question = questionService.getQuestionById(answerDTO.getQuesId());

		answer.setUser(user);
		answer.setQuestion(question);
		answer.setCorrect(false);
		answer.setAnswerBody(answerDTO.getAnswerBody());
		answer.setVotes(0);
		return new ResponseEntity<>(answerService.addAnswer(answer),HttpStatus.OK);
	}

	@PostMapping(path = "/api/restriction/upvoteanswer")
	public ResponseEntity<String>  upvoteAnswer(@RequestBody UserAnswerDTO userAnswerDTO) {
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
			return new ResponseEntity<>("user or answer does'nt exist",HttpStatus.NOT_ACCEPTABLE); //user or answer does'nt exist
			
		}
		
		if(answer.getUser().getUserId() == userId ){
			return new ResponseEntity<>("user can't upvote/downvote his/her own answer",HttpStatus.NOT_ACCEPTABLE); //user can't upvote/downvote his/her own answer
		}
		if(userAnswerService.check(user, answer)){
			return new ResponseEntity<>("user can't upvote/downvote an answer more than once",HttpStatus.NOT_ACCEPTABLE); //user can't upvote/downvote an answer more than once
		}
		UserAnswer userAnswer = new UserAnswer();
		userAnswer.setUser(user);
		userAnswer.setMark(voteType);
		userAnswer.setAnswer(answer);
		
		userAnswerService.addVote(userAnswer);
		answer.setVotes(voteType ? answer.getVotes()+1 : answer.getVotes()-1  );
		answerService.setCorrectAnswer(answer);
		return new ResponseEntity<>("sucess",HttpStatus.OK); //success
    }
}