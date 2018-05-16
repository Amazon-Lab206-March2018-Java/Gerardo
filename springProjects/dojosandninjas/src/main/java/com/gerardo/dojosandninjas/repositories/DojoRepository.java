package com.gerardo.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gerardo.dojosandninjas.models.Dojo;

public interface DojoRepository extends CrudRepository <Dojo, Long>{
	List<Dojo> findAll();
}
