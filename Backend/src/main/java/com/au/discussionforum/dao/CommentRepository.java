package com.au.discussionforum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.discussionforum.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long>{
	List<Comment> findByAnswerAnsId(int ansId);
}
