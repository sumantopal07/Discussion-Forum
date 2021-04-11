package com.au.discussionforum.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserAnswer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userAnsId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="ans_id")
	private Answer answer;
	
	private Boolean mark;
	

	public Boolean getMark() {
		return mark;
	}

	public void setMark(Boolean mark) {
		this.mark = mark;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public int getUserAnsId() {
		return userAnsId;
	}

	public void setUserAnsId(int userAnsId) {
		this.userAnsId = userAnsId;
	}

	
	
}