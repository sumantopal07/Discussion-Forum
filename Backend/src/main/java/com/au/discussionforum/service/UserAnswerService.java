
package com.au.discussionforum.service;

import com.au.discussionforum.model.Answer;
import com.au.discussionforum.model.User;
import com.au.discussionforum.model.UserAnswer;

public interface UserAnswerService {
	Boolean check(User user,Answer answer);
	void addVote(UserAnswer userAnswer);
}
