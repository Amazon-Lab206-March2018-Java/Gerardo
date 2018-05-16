package com.gerardo.dojooverflow.models;

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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
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
	
	@Transient
	@Size (min=4)
	private String strTags;
	
	public Question () {
		
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

	@PrePersist
	public void onCreate () {
		createdAt = new Date();
	}
	
	@PreUpdate
	public void onUpdate () {
		updatedAt = new Date();
	}
}
