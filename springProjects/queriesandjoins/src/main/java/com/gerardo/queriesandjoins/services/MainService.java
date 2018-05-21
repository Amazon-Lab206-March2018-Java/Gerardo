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
		
//		List<Object[]> citiesWith500k = countryRepo.getCitiesWith500k();
//		for (Object[] data : citiesWith500k) {
//			System.out.println("City's name: "+data[0]+" Population: "+data[1]);
//		}
		
//		List<Object[]> citiesWith500k = countryRepo.getCitiesWith500k();
//		for (Object[] data : citiesWith500k) {
//			System.out.println("Country name: "+data[0]+" Amount of cities: "+data[1]);
//		}
		
//		List<Object[]> languagesOver89 = countryRepo.getCountriesLanguageOver89();
//		for (Object[] data : languagesOver89) {
//			System.out.println("Country's name: "+data[0]+" Language: "+data[1]+" Percentage: "+data[2]);
//		}
		
//		for (String data : countryRepo.getCountriesSurfaceLess501()) {
//			System.out.println(data);
//		}
		
//		List<Object[]> constitutionalMonarchyCountries = countryRepo.sixthQuery();
//		for (Object[] data : constitutionalMonarchyCountries) {
//			System.out.println("Country's name: "+data[0]+" Goverment Form: "+data[1]+" Surface: "+data[2]+" Life Expectancy: "+data[3]);
//		}
		
//		List<Object[]> argentinaCitiesInBA = countryRepo.seventhQuery();
//		for (Object[] data : argentinaCitiesInBA) {
//			System.out.println("Country's name: "+data[0]+" City Name: "+data[1]+" District: "+data[2]+" Population: "+data[3]);
//		}
		
		List<Object[]> countriesInRegion = countryRepo.countriesPerRegion();
		for (Object[] data : countriesInRegion) {
			System.out.println("Region's name: "+data[0]+" Amount of countries: "+data[1]);
		}
	}

}
