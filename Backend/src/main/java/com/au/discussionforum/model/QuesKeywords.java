package com.au.discussionforum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class QuesKeywords {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quesKeywordsId;
	
	@ManyToOne
	@JoinColumn(name="ques_id")
	private Question question;
	
	private String keyword;

	public QuesKeywords(int quesKeywordsId, Question question, String keyword) {
		super();
		this.quesKeywordsId = quesKeywordsId;
		this.question = question;
		this.keyword = keyword;
	}

	public QuesKeywords() {
	}

	public int getQuesKeywordsId() {
		return quesKeywordsId;
	}

	public void setQuesKeywordsId(int quesKeywordsId) {
		this.quesKeywordsId = quesKeywordsId;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "QuesKeywords [quesKeywordsId=" + quesKeywordsId + ", question=" + question + ", keyword=" + keyword
				+ "]";
	}
	
	
	
}
