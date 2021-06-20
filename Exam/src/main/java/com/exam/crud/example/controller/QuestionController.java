package com.exam.crud.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.crud.example.entity.Question2;
import com.exam.crud.example.service.QuestionService;

@RestController
@CrossOrigin(origins="*")
public class QuestionController {

	@Autowired
	private QuestionService service;
	
	@PostMapping("/question/add")
	public Question2 addQuestion(@RequestBody Question2 question) {
		return service.addQuestion(question);
	}

	@PostMapping("/question/addlist")
	public List<Question2> addQuestionList(@RequestBody List<Question2> question){
		return service.addQuestions(question);
	}
	
	@GetMapping("/question/{id}")
	public Question2 getQuestion(@PathVariable int id) {
		return service.getQuestionById(id);
		
	}
	
	@GetMapping("/question/getlist")
	public List<Question2> getQuestions() {
		return service.getQuestions();	
	}
	
	@GetMapping("/question/getlistById/{id}")
	public List<Question2> getQuestionByQuizId(@PathVariable int id){
		return service.getQuestionByQuizId(id);
	}
	
	@PutMapping("/question/update")
	public Question2 updateQuestion(@RequestBody Question2 question) {
		Question2 updatedQuestion=service.updateQuestion(question);
		return updatedQuestion;
		
	}
	
	@DeleteMapping("/question/{id}/{quizId}")
	public List<Question2> deleteQuestion(@PathVariable Integer id,@PathVariable Integer quizId) {
		return service.deleteQuestion(id,quizId);
	}
	
	@GetMapping("/question/count/{id}")
	public List<Integer> getQuestionsCount(@PathVariable String id) {
		return service.getQuestionsCount(Integer.parseInt(id));	
	}

	@PostMapping("/question/answer")
	public Question2 saveAnswer(@RequestBody Map<String, String> options) {
		System.out.println("cont"+options.get("cqid")+" "+options.get("os"));
		return service.saveAnswer(options);
	}
}
