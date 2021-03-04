package com.au.discussionforum.model;

public class Answer {
	private int ansId;
	private int userId;
	private int quesId;
	private String answerBody;
	private boolean correct;
	
	public Answer(int ansId, int userId, int quesId, String answerBody, boolean correct) {
		this.ansId = ansId;
		this.userId = userId;
		this.quesId = quesId;
		this.answerBody = answerBody;
		this.correct = correct;
	}

	public int getAnsId() {
		return ansId;
	}

	public void setAnsId(int ansId) {
		this.ansId = ansId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getQuesId() {
		return quesId;
	}

	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}

	public String getAnswerBody() {
		return answerBody;
	}

	public void setAnswerBody(String answerBody) {
		this.answerBody = answerBody;
	}

	public boolean iscorrect() {
		return correct;
	}

	public void setcorrect(boolean correct) {
		this.correct = correct;
	}
	
}
