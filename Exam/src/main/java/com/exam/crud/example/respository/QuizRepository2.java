package com.exam.crud.example.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.crud.example.entity.Quiz2;

@Repository
public interface QuizRepository2 extends JpaRepository<Quiz2, Integer> {
	
}