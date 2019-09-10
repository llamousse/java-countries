package com.lambdaschool.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class CountryController
{
	// localhost:2019/names/all
	// return the names of all the country alphabetically
	@GetMapping(value = "/all",
				produces = {"application/json"})
	public ResponseEntity<?> getAllCountries()
	{
		ArrayList<Country> abcCountry = JavacountriesApplication.countryList.countryList;
		abcCountry.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
		return new ResponseEntity<>(abcCountry, HttpStatus.OK);
	}

	// localhost:2019/names/start/{letter}
	// return the countries alphabetically that begin with the given letter
	@GetMapping(value = "/start/{letter}",
				produces = {"application/json"})
	public ResponseEntity<?> getCountriesByFirstLetter(@PathVariable char letter)
	{
		ArrayList<Country> rtnCountry = JavacountriesApplication.countryList
				.findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
		rtnCountry.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
		return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
	}

	// localhost:2019/names/size/{number}
	// return the countries alphabetically that have a name equal to
	// or longer than the given length
	@GetMapping(value = "/size/{number}",
				produces = {"application/json"})
	public ResponseEntity<?> getCountriesByNumberLength(@PathVariable int number)
	{
		ArrayList<Country> rtnCountry = JavacountriesApplication.countryList
				.findCountries(c -> (c.getName().length() >= number));
		return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
	}
}
