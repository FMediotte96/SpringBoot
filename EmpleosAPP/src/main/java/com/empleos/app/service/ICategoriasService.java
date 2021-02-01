package com.empleos.app.service;

import java.util.List;

import com.empleos.app.model.Categoria;

public interface ICategoriasService {
	void save(Categoria categoria);
	List<Categoria> getAll();
	Categoria getById(Integer idCategoria);	
}
