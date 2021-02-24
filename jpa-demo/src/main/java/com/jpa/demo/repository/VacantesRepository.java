package com.jpa.demo.repository;

import com.jpa.demo.model.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacantesRepository extends JpaRepository<Vacante,Integer> {

}
