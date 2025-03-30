package com.learning.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learning.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

	List<Question> findByCategory(String category);

	
 @Query(value= "SELECT * FROM question q WHERE q.category=:category", nativeQuery = true)
	List<Question> findRandomQuestionsByCategory(String category);

}
