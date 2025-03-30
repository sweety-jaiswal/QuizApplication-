package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.model.Question;
 
import com.learning.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestion() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("category/{cat}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable("cat") String category){
		return questionService.getQuestionByCategory(category);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		
		return questionService.addQuestion(question);
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteQuestion(@PathVariable Integer id) {
		
		 return questionService.deleteQuestion(id);
	}
	
	@PutMapping("update")
	public String updateQuestion(@RequestBody Question ques) {
		return questionService.updateQuestion(ques);
	}
}
