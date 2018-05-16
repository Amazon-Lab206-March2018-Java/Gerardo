package com.gerardo.dojooverflow.service;

import org.springframework.stereotype.Service;

import com.gerardo.dojooverflow.models.Answer;
import com.gerardo.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	
	private AnswerRepository repo;
	
	public AnswerService (AnswerRepository repo) {
		this.repo = repo;
	}
	
	public Answer saveAnswer (Answer e) {
		return repo.save(e);
	}
}
