package com.au.discussionforum.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.discussionforum.model.Answer;
import com.au.discussionforum.model.User;
import com.au.discussionforum.model.UserAnswer;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer,Long>{

	List<UserAnswer> findByUserAndAnswer(User user,Answer answer);
}