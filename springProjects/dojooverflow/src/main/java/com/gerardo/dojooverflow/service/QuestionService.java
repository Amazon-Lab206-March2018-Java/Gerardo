package com.gerardo.dojooverflow.service;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.gerardo.dojooverflow.models.Answer;
import com.gerardo.dojooverflow.models.Question;
import com.gerardo.dojooverflow.models.Tag;
import com.gerardo.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	
	private QuestionRepository repo;
	private TagService tagService;
	private AnswerService anService;
	
	public QuestionService (QuestionRepository repo, TagService tagService, AnswerService anService) {
		this.repo = repo;
		this.tagService = tagService;
		this.anService = anService;
	}
	
	public List<Question> getAllQuestions () {
		return repo.findAll();
	}
	
	public Question getQuestion (Long id) {
		return repo.findById(id).get();
	}
	
	public void addQuestion (Question e) {
		String strTags = e.getStrTags();
		List<String> tagList = Arrays.asList(strTags.split(","));
		
		if (strTags != null && strTags.length() > 0) {
			for (String subject : tagList) {
				
				//removes spaces
				subject = subject.trim();
				
				//tries to find the tag in the database, searches by subject
				Tag tag = tagService.getTagBySubject(subject);
				
				if (tag != null) {//if it found something
					e.addTag(tag);//adds the tag to the question
				} else {
					//creates a new tag
					tag = new Tag (subject);
					//saveTag will return a Tag that then gets added to the question
					tag = tagService.saveTag(tag);
					e.addTag( tag );
				}
			}
		}
		repo.save(e); //saves the now modified question YAYYY~!!!
	}

	public void addAnswer(Answer answer, Long q_id) {
		Question question = repo.findById(q_id).get();
		question.addAnswer(answer);
		//repo.save(question);
	}
	
	
}
