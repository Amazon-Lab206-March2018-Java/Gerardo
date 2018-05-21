package com.gerardo.funsies2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gerardo.funsies2.models.Idea;
import com.gerardo.funsies2.repositories.IdeaRepository;

@Service
public class IdeaService {

	private IdeaRepository ideaRepo;
	
	public IdeaService (IdeaRepository ideaRepo) {
		this.ideaRepo = ideaRepo;
	}
	
	public void saveIdea (Idea idea) {
		ideaRepo.save(idea);
	}
	
	public void deleteIdea (Long id) {
		ideaRepo.deleteById(id);
	}
	
	public Idea findIdea (Long id) {
		return ideaRepo.findById(id).get();
	}
	
	public List<Idea> getAllIdeas () {
		return ideaRepo.findAll();
	}
}
