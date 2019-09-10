package com.lambdaschool.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;

@RestController
@RequestMapping("/population")
public class PopulationController
{
	// localhost:2019/population/size/{people}
	// return the countries that have a population equal to or
	// greater than the given population
	@GetMapping(value = "/size/{people}",
				produces = {"application/json"})
	public ResponseEntity<?> getCountriesByPopulation(@PathVariable int people)
	{
		ArrayList<Country> rtnCountry = JavacountriesApplication.countryList
				.findCountries(c -> c.getPopulation() >= people);
		return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
	}

	// localhost:2019/population/min
	// return the country with the smallest population
	@GetMapping(value = "/min",
				produces = {"application/json"})
	public ResponseEntity<?> getSmallestCountryByPopulation()
	{
		ArrayList<Country> minCountry = JavacountriesApplication.countryList.countryList;
		minCountry.sort(Comparator.comparingInt(Country::getPopulation));
		return new ResponseEntity<>(minCountry.get(0), HttpStatus.OK);
	}

	// localhost:2019/population/max
	// return the country with the largest population
	@GetMapping(value = "/max",
				produces={"application/json"})
	public ResponseEntity<?> getLargestCountryByPopulation()
	{
		ArrayList<Country> maxCountry = JavacountriesApplication.countryList.countryList;
		maxCountry.sort(Comparator.comparingInt(Country::getPopulation));
		return new ResponseEntity<>(maxCountry.get(maxCountry.size()-1), HttpStatus.OK);
	}
}
