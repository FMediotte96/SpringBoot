package com.facu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facu.model.Persona;
import com.facu.repository.IPersonaRepo;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaRepo personaRepo;
	
	@Override
	public void save(Persona p) {
		personaRepo.save(p);
	}

	@Override
	public void update(Persona p) {
		personaRepo.save(p);
	}

	@Override
	public void deleteById(Integer id) {
		personaRepo.deleteById(id);
	}

	@Override
	public List<Persona> getAll() {
		return personaRepo.findAll();
	}

}
