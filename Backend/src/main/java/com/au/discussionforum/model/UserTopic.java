package com.au.discussionforum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserTopic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userTopicId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="topic_id")
	private Topic topic;

	public UserTopic(int userTopicId, User user, Topic topic) {
		super();
		this.userTopicId = userTopicId;
		this.user = user;
		this.topic = topic;
	}
	
	public UserTopic() {
		
	}

	public int getUserTopicId() {
		return userTopicId;
	}

	public void setUserTopicId(int userTopicId) {
		this.userTopicId = userTopicId;
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

	@Override
	public String toString() {
		return "UserTopic [userTopicId=" + userTopicId + ", user=" + user + ", topic=" + topic + "]";
	}
	
}
