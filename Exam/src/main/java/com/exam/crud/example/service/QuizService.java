//package com.exam.crud.example.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.exam.crud.example.entity.Quiz;
//import com.exam.crud.example.respository.QuizRepository;
//
//@Service
//public class QuizService {
//
//	@Autowired
//	private QuizRepository repo;
//	
//	public Quiz addQuiz(Quiz quiz) {
//		return repo.save(quiz);
//	}
//	
//	public List<Quiz> addQuizzes(List<Quiz> quiz) {
//		return repo.saveAll(quiz);
//	}
//	
//	public Quiz getQuizById(Integer id) {
//		return repo.findById(id).orElse(null);
//	}
//	
//	public List<Quiz> getQuizzes() {
//		return repo.findAll();
//	}
//	
//	public Object updateQuiz(Quiz quiz) {
////		return (!(repo.getById(quiz.getId())).getName().isEmpty())  ? repo.save(quiz) : "";
//		Object obj =repo.save(quiz);			
//		return obj;
//		
//	}
//	
//	public List<Quiz> deleteQuiz(Integer id) {
//		repo.deleteById(id);
//		return repo.findAll();
//	}
//}
