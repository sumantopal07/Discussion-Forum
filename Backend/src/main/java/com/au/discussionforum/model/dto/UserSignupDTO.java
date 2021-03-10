package com.au.discussionforum.model.dto;

import java.util.List;

public class UserSignupDTO {
	private String signupEmail;
	private String signupPassword;
	private String signupUsername;
	private String signupPhoto;
	private List<String> signupTopic;
	
	public String getSignupEmail() {
		return signupEmail;
	}
	public void setSignupEmail(String signupEmail) {
		this.signupEmail = signupEmail;
	}
	public String getSignupPassword() {
		return signupPassword;
	}
	public void setSignupPassword(String signupPassword) {
		this.signupPassword = signupPassword;
	}
	public String getSignupUsername() {
		return signupUsername;
	}
	public void setSignupUsername(String signupUsername) {
		this.signupUsername = signupUsername;
	}
	public String getSignupPhoto() {
		return signupPhoto;
	}
	public void setSignupPhoto(String signupPhoto) {
		this.signupPhoto = signupPhoto;
	}
	public List<String> getSignupTopic() {
		return signupTopic;
	}
	public void setSignupTopic(List<String> signupTopic) {
		this.signupTopic = signupTopic;
	}

	
	
	
}
