package com.au.discussionforum.model;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Question implements Comparator<Question>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quesId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="topic_id")
	private Topic topic;
	
	@Column(columnDefinition="TEXT")
	private String title;
	
	@Column(columnDefinition="TEXT")
	private String body;
	private boolean marked;
	
	public Question(int quesId, User user, Topic topic, String title, String body, boolean marked) {
		super();
		this.quesId = quesId;
		this.user = user;
		this.topic = topic;
		this.title = title;
		this.body = body;
		this.marked = marked;
	}
	public Question() {
	}
	public int getQuesId() {
		return quesId;
	}
	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
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
	
	@Override
	public String toString() {
		return "Question [quesId=" + quesId + ", user=" + user + ", topic=" + topic + ", title=" + title + ", body="
				+ body + ", marked=" + marked + "]";
	}
	@Override
	public int compare(Question o1, Question o2) {
		Integer q1 = o1.getQuesId();
		Integer q2 = o2.getQuesId();
		if(q1.compareTo(q2)>0)
			return 1;
		else
			return 0;
	}
	
	
}
