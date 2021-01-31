package com.empleos.app.service;

import java.util.List;

import com.empleos.app.model.Vacante;

public interface IVacantesService {
	
	List<Vacante> getAll();
	Vacante getById(Integer id);
	void save(Vacante vacante);

}
