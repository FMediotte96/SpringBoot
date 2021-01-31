package com.empleos.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/categorias")
public class CategoriasController {

	// @GetMapping("/index")
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getIndex(Model model) {
		return "categorias/listCategorias";
	}

	// @GetMapping("/create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "categorias/formCategoria";
	}

	// @PostMapping("/save")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@RequestParam("nombre") String nombre, 
			@RequestParam("descripcion") String descripcion) {
		System.out.println("Categoria: " + nombre);
		System.out.println("Descripción: " + descripcion);
		return "categorias/listCategorias";
	}

}
