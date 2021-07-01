package com.exam.crud.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.crud.example.entity.Quiz2;
import com.exam.crud.example.respository.QuestionsRepository;
import com.exam.crud.example.respository.QuizRepository2;

@Service
public class QuizService2 {

	@Autowired
	private QuizRepository2 repo;
	
	@Autowired
	private QuestionsRepository questionRepo;
	
	public Quiz2 addQuiz(Quiz2 quiz) {
		return repo.save(quiz);
	}
	
	public List<Quiz2> addQuizzes(List<Quiz2> quiz) {
		return repo.saveAll(quiz);
	}
	
	public Quiz2 getQuizById(Integer id) {
		updateStatus(id);
		return repo.findById(id).orElse(null);
	}
	
	public List<Quiz2> getQuizzes() {
		return repo.findAll();
	}
	
	public Quiz2 updateQuiz(Quiz2 quiz) {
//		return (!(repo.getById(quiz.getId())).getName().isEmpty())  ? repo.save(quiz) : "";
		Quiz2 obj =repo.save(quiz);			
		return obj;
		
	}
	
	public List<Quiz2> deleteQuiz(Integer id) {
		repo.deleteById(id);
		return repo.findAll();
	}
	
	public void updateStatus(Integer id) {
		int count=questionRepo.getCountofAnswered(id);
		Quiz2 quizDetails= repo.findById(id).orElse(null);
		quizDetails.setAnswered(count);
		List<Integer> totalCount = questionRepo.getIdCount(id);
		quizDetails.setNotAnswered(totalCount.size()-count);
		repo.saveAndFlush(quizDetails);
	}
}
