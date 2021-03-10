package com.au.discussionforum.service;

import java.util.List;

import com.au.discussionforum.model.Comment;

public interface CommentService {
	List<Comment> getCommentsByAnswerId(int ansId);
	Boolean addComment(Comment comment);
}
