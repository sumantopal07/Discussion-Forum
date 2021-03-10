package com.au.discussionforum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Topic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int topicId;
	
	private String topicName;

	public Topic(int topicId, String topicName) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
	}
	
	public Topic() {
		
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", topicName=" + topicName + "]";
	}

	
}
