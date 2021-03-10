package com.au.discussionforum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
    @Column(unique = true)
	private String email;
	private String password;
	
    @Column(unique = true)
	private String username;
	private String photo;

	public User(int userId, String email, String password, String username, String photo) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.username = username;
		this.photo = photo;
	}
	
	public User() {
		
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "User [userid=" + userId + ", email=" + email + ", password=" + password + ", username=" + username
				+ ", photo=" + photo + "]";
	}
	
}
