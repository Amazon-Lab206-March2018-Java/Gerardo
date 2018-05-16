package com.gerardo.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gerardo.relationships.models.Person;
import com.gerardo.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository repository;
	
	public PersonService (PersonRepository repository) {
		this.repository = repository;
	}
	
	public void addPerson (Person e) {
		repository.save(e);
	}
	
	public List<Person> getAllPersons () {
		return repository.findAll();
	}
	
	public Person findPersonById (Long id) {
		return repository.findById(id).get();
	}
	
	public List<Person> getLicenseless () {
		return repository.findAllByLicenseIsNull();
	}
}
