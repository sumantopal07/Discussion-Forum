package com.au.discussionforum.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.discussionforum.model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic,Long>{
	Topic findByTopicId(int id); 
	Topic findByTopicName(String name);
}