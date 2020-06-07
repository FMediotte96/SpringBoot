package com.facu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facu.model.Persona;
import com.facu.service.IPersonaService;


@RestController
@RequestMapping("/personas")
public class RestDemoController {

	@Autowired
	private IPersonaService personaService;
	
	@GetMapping
	public List<Persona> listar() {
		return personaService.getAll();
	}
	
	@PostMapping
	public void insertar(@RequestBody Persona per) {
		personaService.save(per);
	}
	
	@PutMapping
	public void modificar(@RequestBody Persona per) {
		personaService.save(per);
	}
	
	@DeleteMapping(value ="/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		personaService.deleteById(id);
	}
}
