package com.au.discussionforum.model.dto;

public class UserAnswerDTO {
	private int userId;
	private int ansId;
	private Boolean mark;
	
	public Boolean getMark() {
		return mark;
	}
	public void setMark(Boolean mark) {
		this.mark = mark;
	}
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
	
	

	
}