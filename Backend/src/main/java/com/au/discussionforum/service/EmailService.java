package com.au.discussionforum.service;

public interface EmailService {
	void sendSimpleMessage(String to, String subject, String text);
}
