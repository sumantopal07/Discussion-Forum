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
import com.au.discussionforum.model.Comment;
import com.au.discussionforum.model.User;
import com.au.discussionforum.model.dto.CommentDTO;
import com.au.discussionforum.service.AnswerService;
import com.au.discussionforum.service.CommentService;
import com.au.discussionforum.service.UserService;

@RestController
public class CommentController {
	@Autowired
	CommentService commentService;
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private AnswerService answerService;
	
	@GetMapping(path = "/api/restriction/comment/{ansid}")
    public ResponseEntity<List<Comment>> getComments(@PathVariable("ansid") int ansId) {
		return new ResponseEntity<>(commentService.getCommentsByAnswerId(ansId),HttpStatus.OK);
    }
	
	@PostMapping(path = "/api/restriction/addcomment")
	public ResponseEntity<Boolean> addComment(@RequestBody CommentDTO commentDTO) {
		Comment comment = new Comment();
		
		User user = userService.getUserByUserId(commentDTO.getUserId());
		Answer answer = answerService.getAnswerByAnswerId(commentDTO.getAnsId());
		
		comment.setUser(user);
		comment.setCommentBody(commentDTO.getCommentBody());
		comment.setAnswer(answer);
		
		return new ResponseEntity<>(commentService.addComment(comment),HttpStatus.OK);
	}

}
