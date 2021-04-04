package com.au.discussionforum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DiscussionforumApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscussionforumApplication.class);
	}

}
