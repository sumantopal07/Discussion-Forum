package com.au.discussionforum.model.dto;

import java.util.List;

public class UserSignupDTO {
	private String email;
	private String password;
	private String username;
	private String photo;
	private List<String> topic;
	
	public String getSignupEmail() {
		return email;
	}
	public void setSignupEmail(String email) {
		this.email = email;
	}
	public String getSignupPassword() {
		return password;
	}
	public void setSignupPassword(String password) {
		this.password = password;
	}
	public String getSignupUsername() {
		return username;
	}
	public void setSignupUsername(String username) {
		this.username = username;
	}
	public String getSignupPhoto() {
		return photo;
	}
	public void setSignupPhoto(String photo) {
		this.photo = photo;
	}
	public List<String> getTopic() {
		return topic;
	}
	public void setTopic(List<String> topic) {
		this.topic = topic;
	}
	
}
