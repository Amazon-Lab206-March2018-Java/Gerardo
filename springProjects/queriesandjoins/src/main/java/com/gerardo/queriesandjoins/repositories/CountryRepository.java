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
	
	@Query ("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.percentage > 89.0 ORDER BY l.percentage DESC")
	List<Object[]> getCountriesLanguageOver89();
	
	@Query ("SELECT c.name FROM Country c WHERE c.surfaceArea < 501 AND c.population > 100000")
	List<String> getCountriesSurfaceLess501();
	
	@Query ("SELECT c.name, c.governmentForm, c.surfaceArea, c.lifeExpectancy FROM Country c WHERE c.governmentForm = 'Constitutional Monarchy' AND c.surfaceArea > 200 AND c.lifeExpectancy > 75")
	List<Object[]> sixthQuery();
	
	@Query ("SELECT c.name, cit.name, cit.district, cit.population FROM Country c JOIN c.cities cit WHERE c.name = 'Argentina' AND cit.district = 'Buenos Aires' AND cit.population > 500000")
	List<Object[]> seventhQuery();
	
	@Query ("SELECT c.region, count(c) FROM Country c GROUP BY c.region ORDER BY COUNT(c) DESC")
	List<Object[]> countriesPerRegion();
}
