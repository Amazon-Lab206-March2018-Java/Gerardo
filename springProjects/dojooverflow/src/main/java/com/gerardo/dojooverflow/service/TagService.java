package com.gerardo.dojooverflow.service;

import org.springframework.stereotype.Service;

import com.gerardo.dojooverflow.models.Tag;
import com.gerardo.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	
	private TagRepository repo;
	
	public TagService (TagRepository repo) {
		this.repo = repo;
	}
	
	public Tag saveTag (Tag e) {
		return repo.save(e);
	}
	
	public Tag getTagBySubject (String subject) {
		return repo.findBySubject(subject);
	}
}
