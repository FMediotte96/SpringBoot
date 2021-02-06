package com.tutorialesvip.tutorialunittest.controller;

import com.tutorialesvip.tutorialunittest.models.Country;
import com.tutorialesvip.tutorialunittest.models.CountryResponse;
import com.tutorialesvip.tutorialunittest.repositories.CountryRepository;
import com.tutorialesvip.tutorialunittest.util.DiferenciaEntreFechas;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Period;
import java.util.Optional;

/**
 * Author: VIP
 */
@RestController()
public class IndependenceController {

	CountryRepository countryRepository;
	DiferenciaEntreFechas diferenciaEntreFechas;

	public IndependenceController(CountryRepository countryRepository, DiferenciaEntreFechas diferenciaEntreFechas) {
		this.countryRepository = countryRepository;
		this.diferenciaEntreFechas = diferenciaEntreFechas;
	}

	@GetMapping(path = "/country/{countryId}")
	public ResponseEntity<CountryResponse> getCountryDetails(@PathVariable("countryId") String countryId) {
		Optional<Country> country = Optional.of(new Country());
		CountryResponse countryResponse = new CountryResponse();

		country = Optional.ofNullable(countryRepository.findCountryByIsoCode(countryId.toUpperCase()));

		if (country.isPresent()) {
			Period period = diferenciaEntreFechas
					.calculateYearsOfIndependence(country.get().getCountryIndependenceDate());
			countryResponse.setCountryName(country.get().getCountryName());
			countryResponse.setCapitalName(country.get().getCountryCapital());
			countryResponse.setIndependenceDate(country.get().getCountryIndependenceDate());
			countryResponse.setDaysOfIndependence(period.getDays());
			countryResponse.setMonthsOfIndependence(period.getMonths());
			countryResponse.setYearsOfIndependence(period.getYears());
		}
		return ResponseEntity.ok(countryResponse);
	}
}