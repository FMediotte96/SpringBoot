package com.facu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facu.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer> {

}
