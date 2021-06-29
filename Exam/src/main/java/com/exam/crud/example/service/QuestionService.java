package com.exam.crud.example.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.crud.example.entity.Question2;
import com.exam.crud.example.entity.Quiz2;
import com.exam.crud.example.respository.QuestionsRepository;
import com.exam.crud.example.respository.QuizRepository2;

@Service
public class QuestionService {

	@Autowired
	private QuestionsRepository repository;
	
	@Autowired
	private QuizRepository2 quizRepo;

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
		if(options.get("os")=="") {
			question.setSelectedOption("");	
		}else if(!options.get("os").isEmpty()) {
			question.setSelectedOption(options.get("os"));
			updateStatus(options.get("quizId"));			
		}
		return repository.save(question);
	}

	private void updateStatus(String id) {
		Quiz2 quizDetails= quizRepo.getById(Integer.parseInt(id));
		int count=quizDetails.getAnswered();
		quizDetails.setAnswered(count+=1);

	}

}
