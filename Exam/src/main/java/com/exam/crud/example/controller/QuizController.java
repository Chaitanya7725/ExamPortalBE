//package com.exam.crud.example.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.exam.crud.example.entity.Quiz;
//import com.exam.crud.example.service.QuizService;
//
//@RestController
//@CrossOrigin(origins = "*")
//public class QuizController {
//
//	@Autowired
//	private QuizService service;
//	
//	@PostMapping("/add")
//	public Quiz addQuiz(@RequestBody Quiz quiz) {
//		return service.addQuiz(quiz);
//		
//	}
//	
//	@PostMapping("/addlist")
//	public List<Quiz> addQuizList(@RequestBody List<Quiz> quiz){
//		return service.addQuizzes(quiz);
//		
//	}
//	
//	@GetMapping("/{id}")
//	public Quiz getQuiz(@PathVariable int id) {
//		return service.getQuizById(id);
//		
//	}
//	
//	@GetMapping("/getlist")
//	public List<Quiz> getQuizzes() {
//		return service.getQuizzes();
//		
//	}
//	
//	@PutMapping("/update")
//	public Object updateQuiz(@RequestBody Quiz quiz) {
//		Object updatedQuiz=service.updateQuiz(quiz);
//		return updatedQuiz;
//		
//	}
//	
//	@DeleteMapping("/{id}")
//	public List<Quiz> deleteQuiz(@PathVariable int id) {
//		return service.deleteQuiz(id);
//	}
//}
