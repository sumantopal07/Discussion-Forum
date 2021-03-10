package com.au.discussionforum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.discussionforum.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long>{
	List<Question> findByUserUserId(int userId);
	List<Question> findByTopicTopicId(int topicId);
	Question findByQuesId(int quesId);
}