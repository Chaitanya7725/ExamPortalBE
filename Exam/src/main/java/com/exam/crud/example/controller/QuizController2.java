package com.exam.crud.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.crud.example.entity.Quiz2;
import com.exam.crud.example.service.QuizService2;

@CrossOrigin(origins = "*")
@RestController
public class QuizController2 {

	@Autowired
	private QuizService2 service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/add")
	public Quiz2 addQuiz(@RequestBody Quiz2 quiz) {
		return service.addQuiz(quiz);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addlist")
	public List<Quiz2> addQuizList(@RequestBody List<Quiz2> quiz){
		return service.addQuizzes(quiz);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public Quiz2 getQuiz(@PathVariable int id) {
		return service.getQuizById(id);
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getlist")
	public List<Quiz2> getQuizzes() {
		return service.getQuizzes();
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update")
	public Quiz2 updateQuiz(@RequestBody Quiz2 quiz) {
		Quiz2 updatedQuiz=service.updateQuiz(quiz);
		return updatedQuiz;
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{id}")
	public List<Quiz2> deleteQuiz(@PathVariable Integer id) {
		return service.deleteQuiz(id);
	}
}
