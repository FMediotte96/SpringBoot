package com.facu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facu.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {
	
	Usuario findByNombre(String nombre); //Esto disparara una consulta que busque con where Nombre

}
