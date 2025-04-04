package com.learning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
