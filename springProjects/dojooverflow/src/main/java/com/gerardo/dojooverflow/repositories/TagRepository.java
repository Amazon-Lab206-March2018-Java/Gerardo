package com.gerardo.dojooverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gerardo.dojooverflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository <Tag, Long> {
	Tag findBySubject (String subject);
}
