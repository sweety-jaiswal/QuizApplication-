package com.learning.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.learning.dao.QuestionDao;
import com.learning.model.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<List<Question>> getAllQuestions(){
		try {
		return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		 try {
		 return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
		 }catch(Exception e) {
		 e.printStackTrace();
		 }
		 return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) {
	      questionDao.save(question);
	      return new ResponseEntity<>("success", HttpStatus.CREATED);
	}

	public String deleteQuestion(Integer id) {
		 questionDao.deleteById(id);
		  return "deleted";
	}

	public String updateQuestion(Question ques) {
		
		// case consider: update only when object exists else give message
		Optional<Question> existingQuestion = questionDao.findById(ques.getId());

        if (existingQuestion.isPresent()) {
            Question q = existingQuestion.get();
            q.setDifficultylevel(ques.getDifficultylevel()); // Update difficulty level
             questionDao.save(q); // Save the updated question
             return "updated";
        } 
         
	  return "id not exist";
     }
	
	
}
