package com.facu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.facu.repository.IPersonRepo;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	@Qualifier("persona2")
	private IPersonRepo repo;
	
	@Override
	public void registrar(String nombre) {
		repo.registrar(nombre);
	}
}