package com.jpa.demo;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.demo.model.Categoria;
import com.jpa.demo.repository.CategoriasRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriasRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		saveAll();
	}
	
	/**
	 * Método save - Interfaz CrudRepository
	 */
	private void save() {
		Categoria cat = new Categoria();
		cat.setNombre("Finanzas");
		cat.setDescripcion("Trabajos relacionados con finanzas y contabilidad");
		repo.save(cat);
		System.out.println(cat);
	}
	
	/**
	 * Método findById - Interfaz CrudRepository
	 */
	private void getById() {
		Optional<Categoria> optional = repo.findById(1);
		if(optional.isPresent())
			System.out.println(optional.get());
		else
			System.out.println("Categoria no encontrada");
	}
	
	/**
	 * Método update - save Interfaz CrudRepository
	 */
	private void update() {
		Optional<Categoria> optional = repo.findById(2);
		if(optional.isPresent()) {
			Categoria catTmp = optional.get();
			catTmp.setNombre("Ing. de Software");
			catTmp.setDescripcion("Desarrollo de sistemas");
			repo.save(catTmp);
			System.out.println(optional.get());
		}
		else
			System.out.println("Categoria no encontrada");
	}
	
	/**
	 * Método deleteById - Interfaz CrudRepository
	 */
	private void delete() {
		int idCategoria = 1;
		repo.deleteById(idCategoria);
	}
	
	/**
	 * Método count - Interfaz CrudRepository
	 */
	private void count() {
		long count = repo.count();
		System.out.println("Total Categorias: " + count);
	}
	
	/**
	 * Método deleteAll - Interfaz CrudRepository
	 */
	private void deleteAll() {
		repo.deleteAll();
	}
	
	/**
	 * Método findAllById - Interfaz CrudRepository
	 */
	private void findAllByIds() {
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(1);
		ids.add(4);
		ids.add(10);
		Iterable<Categoria> categorias = repo.findAllById(ids);
		for(Categoria cat : categorias) {
			System.out.println(cat);
		}
	}
	
	/**
	 * Método findAll - Interfaz CrudRepository
	 */
	private void getAll() {
		Iterable <Categoria> categorias = repo.findAll();
		for(Categoria cat : categorias) {
			System.out.println(cat);
		}
	}
	
	/**
	 * Método existsById - Interfaz CrudRepository
	 */
	private void existsById() {
		boolean existe = repo.existsById(50);
		System.out.println("La categoria existe: " + existe);
	}
	
	/**
	 * Método saveAll - Interfaz CrudRepository
	 */
	private void saveAll() {
		List<Categoria> categorias = getListaCategorias();
		repo.saveAll(categorias);
	}
	
	/**
	 * Método que regresa una lista de 3 Categorias
	 * @return
	 */
	private List<Categoria> getListaCategorias() {
		List<Categoria> lista = new LinkedList<Categoria>();
		//Categoria 1
		Categoria cat1 = new Categoria();
		cat1.setNombre("Programador de Blockchain");
		cat1.setDescripcion("Trabajos relacionados con Bitcoin y Criptomonedas");
		
		//Categoria 2
		Categoria cat2 = new Categoria();
		cat2.setNombre("Soldador/Pintura");
		cat2.setDescripcion("Trabajos relacionados con soldadura, pintura y enderezado");
		
		//Categoria 3
		Categoria cat3 = new Categoria();
		cat3.setNombre("Ingeniero Industrial");
		cat3.setDescripcion("Trabajos relacionados con Ingenieria Industrial.");
		
		lista.add(cat1);
		lista.add(cat2);
		lista.add(cat3);
		
		return lista;
	}
	
}
