package com.au.discussionforum.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.discussionforum.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long>{
	Page<Question> findByUserUserId(int userId,Pageable pageable);
	// Pageable : curent page, content per page
	
	List<Question> findByTopicTopicId(int topicId);
	Question findByQuesId(int quesId);
}