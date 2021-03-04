package com.au.discussionforum.model;

public class Question {
	private int quesId;
	private int userId;
	private int topicId;
	private String title;
	private String body;
	private boolean marked;
	
	public Question(int quesId, int userId, int topicId, String title, String body, boolean marked) {
		this.quesId = quesId;
		this.userId = userId;
		this.topicId = topicId;
		this.title = title;
		this.body = body;
		this.marked = marked;
	}

	public int getQuesId() {
		return quesId;
	}

	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public boolean isMarked() {
		return marked;
	}

	public void setMarked(boolean marked) {
		this.marked = marked;
	}
	
	
}
