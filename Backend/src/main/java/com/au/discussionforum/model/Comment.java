package com.au.discussionforum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="ans_id")
	private Answer answer;
	
	@Column(columnDefinition="TEXT")
	private String commentBody;
	
	public Comment() {
	}

	public Comment(int commentId, User user, Answer answer, String commentBody) {
		this.commentId = commentId;
		this.user = user;
		this.answer = answer;
		this.commentBody = commentBody;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
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

	public String getCommentBody() {
		return commentBody;
	}

	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", user=" + user + ", answer=" + answer + ", commentBody="
				+ commentBody + "]";
	}
	
	
}
