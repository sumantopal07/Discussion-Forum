package com.au.discussionforum.model.dto;

public class CommentDTO {
	private int userId;
	private int ansId;
	private String commentBody;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAnsId() {
		return ansId;
	}
	public void setAnsId(int ansId) {
		this.ansId = ansId;
	}
	public String getCommentBody() {
		return commentBody;
	}
	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}
	
	
}
