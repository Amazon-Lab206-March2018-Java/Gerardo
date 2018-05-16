package com.gerardo.dojooverflow.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table (name="questions")
public class Question {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@Column (updatable=false)
	private Date createdAt;
	private Date updatedAt;
	

	@NotNull
	@Size (min=4, message="The question must be at least 4 characters")
	private String question;
	
	
	@ManyToMany (fetch = FetchType.LAZY)
	@JoinTable (
			name = "tags_questions",
			joinColumns = @JoinColumn (name="question_id"),
			inverseJoinColumns = @JoinColumn (name = "tag_id")
	)
	private List<Tag> tags;
	
	@OneToMany (mappedBy="question", fetch = FetchType.LAZY)
	private List<Answer> answers;
	
	@Transient
	@Pattern (regexp = "^$|^\\w*\\s*$|^\\w*,\\s*\\w*$|^\\w*,\\s*\\w*,\\s*\\w*$", message="Three tags max. Please enter your tags in the format: tag1, tag2, tag3")
	private String strTags;
	
	public Question () {
		tags = new ArrayList<Tag>();
	}
	
	public void addTag (Tag e) {
		tags.add(e);
	}
	
	public void addAnswer (Answer e) {
		answers.add(e);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStrTags() {
		return strTags;
	}

	public void setStrTags(String strTags) {
		this.strTags = strTags;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}	
	
	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@PrePersist
	public void onCreate () {
		createdAt = new Date();
	}
	
	@PreUpdate
	public void onUpdate () {
		updatedAt = new Date();
	}
}
