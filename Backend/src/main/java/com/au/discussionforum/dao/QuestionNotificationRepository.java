package com.au.discussionforum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.discussionforum.model.Comment;
import com.au.discussionforum.model.QuestionNotification;


@Repository
public interface QuestionNotificationRepository extends JpaRepository<QuestionNotification,Long>{
	List<QuestionNotification> findByUserUserId(int userId);
}
