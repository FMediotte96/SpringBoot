package com.facu.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.facu.DemoConsolaApplication;

@Repository
public class PersonaRepoImpl implements IPersonRepo {
	
	private static Logger LOG = LoggerFactory.getLogger(DemoConsolaApplication.class);

	@Override
	public void registrar(String nombre) {
		LOG.info("SE REGISTRO A " + nombre);
	}

}
