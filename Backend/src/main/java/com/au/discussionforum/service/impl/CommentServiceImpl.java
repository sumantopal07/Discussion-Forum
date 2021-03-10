package com.au.discussionforum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.discussionforum.dao.CommentRepository;
import com.au.discussionforum.model.Comment;
import com.au.discussionforum.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentRepository commentRepository;
	
	public List<Comment> getCommentsByAnswerId(int ansId) {
		return commentRepository.findByAnswerAnsId(ansId);
	}

	@Override
	public Boolean addComment(Comment comment) {
		try {
			commentRepository.save(comment);
			return true;	
		}
		catch (Exception e)
		{
			return false;
		}
	}

}
