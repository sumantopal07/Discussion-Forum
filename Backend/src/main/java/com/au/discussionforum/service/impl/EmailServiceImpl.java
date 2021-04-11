package com.au.discussionforum.service.impl;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.au.discussionforum.dao.QuestionNotificationRepository;
import com.au.discussionforum.dao.QuestionRepository;
import com.au.discussionforum.model.Question;
import com.au.discussionforum.model.QuestionNotification;
import com.au.discussionforum.model.User;
import com.au.discussionforum.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;
    
    @Autowired
    QuestionNotificationRepository questionNotificationRepository;

    @Async
    public void sendSimpleMessage(Question question, List<User> users, String subject, String text) {
    	
    	
    	for(User user: users )
    	{
    		QuestionNotification notification = new QuestionNotification();
    		notification.setQuestion(question);
    		notification.setReadComment(0);
    		notification.setUser(user);
    		questionNotificationRepository.save(notification);
    		
    		Properties props = new Properties();
            props.put("mail.smtp.auth", true);
            props.put("mail.smtp.ssl.trust", "*");
        	
            SimpleMailMessage message = new SimpleMailMessage(); 
            message.setFrom("auprojecteam2@gmail.com");
            message.setTo(user.getEmail()); 
            message.setSubject(subject); 
            message.setText(text);
            emailSender.send(message);
    	}
    }
}