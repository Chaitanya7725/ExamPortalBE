package com.exam.crud.example.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exam.crud.example.entity.Question2;

@Repository
public interface QuestionsRepository extends JpaRepository<Question2, Integer>{
	
	List<Question2> findByQuizId(int id);

	@Query("select i.id from Question2 i where i.quiz.id =:id")
	List<Integer> getIdCount(int id);
	
	@Query("select count(i) from Question2 i where i.quiz.id=:idq AND i.selectedOption!='0'")
	int getCountofAnswered(@Param("idq") Integer idq);
	
	
}
