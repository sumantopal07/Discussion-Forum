package com.au.discussionforum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.au.discussionforum.model.QuesKeywords;

@Repository
public interface QuesKeywordsRepository extends JpaRepository<QuesKeywords,Long>{
	List<QuesKeywords> findByKeywordIn(List<String> keyword);
}
