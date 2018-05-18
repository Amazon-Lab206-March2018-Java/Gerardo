package com.gerardo.queriesandjoins.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gerardo.queriesandjoins.models.Country;

@Repository
public interface CountryRepository extends CrudRepository <Country, Long> {
	
	@Query ("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE language = ?1 ORDER BY l.percentage DESC")
	List<Object[]>  getCountriesThatSpeakSlovenne (String language);
	
	@Query ("SELECT c.name, COUNT(cit) FROM Country c JOIN c.cities cit GROUP BY c.name ORDER BY COUNT(cit) DESC")
	List<Object[]> getCitiesPerCountry ();
	
	@Query ("SELECT cit.name, cit.population FROM Country c JOIN c.cities cit WHERE c.name = 'Mexico' AND cit.population > 500000 ORDER BY cit.population DESC")
	List<Object[]> getCitiesWith500k();
}
