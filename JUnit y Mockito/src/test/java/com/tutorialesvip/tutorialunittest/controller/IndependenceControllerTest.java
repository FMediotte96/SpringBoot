package com.tutorialesvip.tutorialunittest.controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.tutorialesvip.tutorialunittest.models.Country;
import com.tutorialesvip.tutorialunittest.models.CountryResponse;
import com.tutorialesvip.tutorialunittest.repositories.CountryRepository;
import com.tutorialesvip.tutorialunittest.util.DiferenciaEntreFechas;

public class IndependenceControllerTest {
	
	CountryRepository countryRepositoryMock = Mockito.mock(CountryRepository.class);
	
	@Autowired
	DiferenciaEntreFechas diferenciaEntreFechas = new DiferenciaEntreFechas();
	
	@Autowired
	IndependenceController independenceController = new IndependenceController(countryRepositoryMock, diferenciaEntreFechas);
	
	@BeforeEach
	private void setUp() {
		
		Country mockCountry = new Country();
		mockCountry.setIsoCode("DO");
		mockCountry.setCountryIndependenceDate("27/02/1844");
		mockCountry.setCountryId(1L);
		mockCountry.setCountryName("Republica Dominicana");
		mockCountry.setCountryCapital("Santo Domingo");
		
		Mockito.when(countryRepositoryMock.findCountryByIsoCode("DO")).thenReturn(mockCountry);
	}
	
	@Test
	void getCountryDetailsWithValidCountryCode() {
		ResponseEntity<CountryResponse> respuestaServicio;
		respuestaServicio = independenceController.getCountryDetails("DO");
		Assertions.assertEquals("Republica Dominicana", respuestaServicio.getBody().getCountryName());
		Assertions.assertEquals("Santo Domingo", respuestaServicio.getBody().getCapitalName());
		Assertions.assertEquals("27/02/1844", respuestaServicio.getBody().getIndependenceDate());
	}
	
	@Test
	void getCountryDetailsWithInvalidCountryCode() {
		ResponseEntity<CountryResponse> respuestaServicio;
		respuestaServicio = independenceController.getCountryDetails("IT");
		Assertions.assertNull(respuestaServicio.getBody().getCountryName());
	}
	
}
