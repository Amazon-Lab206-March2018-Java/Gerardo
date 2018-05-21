package com.gerardo.funsies2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gerardo.funsies2.models.Idea;

@Repository
public interface IdeaRepository extends CrudRepository <Idea, Long>{
	List<Idea> findAll();
}
