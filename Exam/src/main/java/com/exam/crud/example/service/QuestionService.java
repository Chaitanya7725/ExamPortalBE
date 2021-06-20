package com.exam.crud.example.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.crud.example.entity.Question2;
import com.exam.crud.example.respository.QuestionsRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionsRepository repository;

	public Question2 addQuestion(Question2 question) {
		return repository.save(question);
	}

	public List<Question2> addQuestions(List<Question2> question) {
		return repository.saveAll(question);
	}

	public Question2 getQuestionById(int id) {
		return repository.findById(id).orElse(null);
	}

	public List<Question2> getQuestions() {
		return repository.findAll();
	}

	public Question2 updateQuestion(Question2 question) {
		return repository.save(question);
	}

	public List<Question2> deleteQuestion(Integer id, Integer quizId) {
		repository.deleteById(id);
		return repository.findByQuizId(quizId);
	}

	public List<Question2> getQuestionByQuizId(int id) {
		return repository.findByQuizId(id);
	}

	public List<Integer> getQuestionsCount(int id) {
		return repository.getIdCount(id);
	}

	public Question2 saveAnswer(Map<String, String> options) {
		Integer idq=Integer.parseInt(options.get("cqid"));
		Question2 question=repository.getById(idq);
		question.setSelectedOption(options.get("os"));
		return repository.save(question);
	}

}
