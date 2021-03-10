package com.au.discussionforum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ansId;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="ques_id")
	private Question question;
	
	@Column(columnDefinition="TEXT")
	private String answerBody;
	private boolean correct;
	
	public Answer(int ansId, User user, Question question, String answerBody, boolean correct) {
		super();
		this.ansId = ansId;
		this.user = user;
		this.question = question;
		this.answerBody = answerBody;
		this.correct = correct;
	}
	public Answer() {
	}
	public int getAnsId() {
		return ansId;
	}
	public void setAnsId(int ansId) {
		this.ansId = ansId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public String getAnswerBody() {
		return answerBody;
	}
	public void setAnswerBody(String answerBody) {
		this.answerBody = answerBody;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
	@Override
	public String toString() {
		return "Answer [ansId=" + ansId + ", user=" + user + ", question=" + question + ", answerBody=" + answerBody
				+ ", correct=" + correct + "]";
	}
	
	
}
