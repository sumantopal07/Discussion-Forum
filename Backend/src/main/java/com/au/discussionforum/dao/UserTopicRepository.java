package com.au.discussionforum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.au.discussionforum.model.UserTopic;

@Repository
public interface UserTopicRepository extends JpaRepository<UserTopic,Long>{
	List<UserTopic> findByTopicTopicId(int topicId);
	List <UserTopic> findByUserUserId(int userId);
}
