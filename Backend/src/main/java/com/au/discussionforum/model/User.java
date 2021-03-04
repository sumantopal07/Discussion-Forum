package com.au.discussionforum.model;

public class User {
	private int userId;
	private String email;
	private String password;
	private String userName;
	
	public User(int userId, String email, String password, String userName) {
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
