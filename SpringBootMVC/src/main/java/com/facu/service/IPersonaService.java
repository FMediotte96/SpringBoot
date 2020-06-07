package com.facu.service;

import java.util.List;

import com.facu.model.Persona;

public interface IPersonaService {
	
	void save(Persona p);
	void update(Persona p);
	void deleteById(Integer id);
	List<Persona> getAll();

}
