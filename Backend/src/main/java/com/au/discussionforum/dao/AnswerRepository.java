package com.au.discussionforum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.discussionforum.model.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Long>{

	List<Answer> findByQuestionQuesId(int keyword);
	Answer findByAnsId(int ansId);
}