package com.gerardo.queriesandjoins.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gerardo.queriesandjoins.repositories.CityRepository;
import com.gerardo.queriesandjoins.repositories.CountryRepository;
import com.gerardo.queriesandjoins.repositories.LanguageRepository;

@Service
public class MainService {
	
	private CountryRepository countryRepo;
	private LanguageRepository languageRepo;
	private CityRepository cityRepo;
	
	public MainService (CountryRepository countryRepo, LanguageRepository languageRepo, CityRepository cityRepo) {
		this.countryRepo = countryRepo;
		this.languageRepo = languageRepo;
		this.cityRepo = cityRepo;
	}

	public void queries() {
		
//		List<Object[]> slovenneCountries = countryRepo.getCountriesThatSpeakSlovenne ("Slovene");
//		for (Object[] data : slovenneCountries) {
//			System.out.println("Country name: "+data[0]+" Country language: "+data[1]+" Language percentage: "+data[2]);
//		}
		
//		List<Object[]> citiesByCountry = countryRepo.getCitiesPerCountry();
//		for (Object[] data : citiesByCountry) {
//			System.out.println("Country name: "+data[0]+" Amount of cities: "+data[1]);
//		}
		
		List<Object[]> citiesWith500k = countryRepo.getCitiesWith500k();
		for (Object[] data : citiesWith500k) {
			System.out.println("City's name: "+data[0]+" Population: "+data[1]);
		}
		
//		List<Object[]> citiesWith500k = countryRepo.getCitiesWith500k();
//		for (Object[] data : citiesWith500k) {
//			System.out.println("Country name: "+data[0]+" Amount of cities: "+data[1]);
//		}
		
	}

}
