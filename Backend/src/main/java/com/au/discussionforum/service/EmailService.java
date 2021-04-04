package com.au.discussionforum.service;

import java.util.List;

import com.au.discussionforum.model.User;

public interface EmailService {
	void sendSimpleMessage(List<User> to, String subject, String text);
}
