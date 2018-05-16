package com.gerardo.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gerardo.relationships.models.Person;

@Repository
public interface PersonRepository extends CrudRepository <Person, Long>{
	List<Person> findAll();
	List<Person> findAllByLicenseIsNull();
}
