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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name="tags")
public class Tag {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@Column (updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@NotNull
	@Size (min=4)
	private String subject;
	
	@ManyToMany (fetch = FetchType.LAZY)
	@JoinTable (
			name = "tags_questions",
			joinColumns = @JoinColumn (name="tag_id"),
			inverseJoinColumns = @JoinColumn (name="question_id")
	)
	private List<Question> questions;
	
	public Tag () {
		
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
