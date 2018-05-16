package com.gerardo.dojooverflow.service;

import org.springframework.stereotype.Service;

import com.gerardo.dojooverflow.models.Question;
import com.gerardo.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	
	private QuestionRepository repo;
	
	public QuestionService (QuestionRepository repo) {
		this.repo = repo;
	}
	
	public void addQuestion (Question e) {
		repo.save(e);
	}
}
