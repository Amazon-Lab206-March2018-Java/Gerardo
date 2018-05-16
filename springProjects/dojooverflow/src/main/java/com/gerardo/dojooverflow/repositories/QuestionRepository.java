package com.gerardo.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gerardo.dojooverflow.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository <Question, Long>{
	List<Question> findAll();
}
