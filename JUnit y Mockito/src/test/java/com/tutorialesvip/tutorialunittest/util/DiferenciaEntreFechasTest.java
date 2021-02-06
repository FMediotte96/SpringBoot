package com.tutorialesvip.tutorialunittest.util;

import java.time.Period;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DiferenciaEntreFechasTest {
	
	@Autowired
	DiferenciaEntreFechas diferenciaEntreFechas;
	
	@Test
	void calculateYearsOfIndependence() {
		diferenciaEntreFechas = new DiferenciaEntreFechas();
		String fechaIndepencencia = "27/02/1844";
		
		Period resultado = diferenciaEntreFechas.calculateYearsOfIndependence(fechaIndepencencia);
		Assertions.assertEquals(10, resultado.getDays());
		Assertions.assertEquals(11, resultado.getMonths());
		Assertions.assertEquals(176, resultado.getYears());
	}

}
