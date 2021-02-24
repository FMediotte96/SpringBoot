package com.jpa.demo;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.jpa.demo.repository.PerfilesRepository;
import com.jpa.demo.repository.VacantesRepository;
import com.jpa.demo.service.CategoriasService;
import com.jpa.demo.service.PerfilesService;
import com.jpa.demo.service.UsuariosServices;
import com.jpa.demo.service.VacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.demo.model.Categoria;
import com.jpa.demo.repository.CategoriasRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	@Autowired
	private CategoriasService serviceCategorias;

	@Autowired
	private VacantesService vacantesService;

	@Autowired
	private PerfilesService perfilesService;

	@Autowired
	private UsuariosServices usuariosService;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		usuariosService.findById();
	}
}
