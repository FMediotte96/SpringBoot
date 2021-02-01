package com.empleos.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empleos.app.model.Categoria;
import com.empleos.app.service.ICategoriasService;

@Controller
@RequestMapping(value = "/categorias")
public class CategoriasController {
	
	@Autowired
	private ICategoriasService serviceCategorias;

	@GetMapping("/index")
	public String getIndex(Model model) {
		List<Categoria> categorias = serviceCategorias.getAll();
		model.addAttribute("categorias", categorias);
		return "categorias/listCategorias";
	}

	@GetMapping("/create")
	public String create(Categoria categoria) {
		return "categorias/formCategoria";
	}

	@PostMapping("/save")
	public String save(Categoria categoria, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			System.out.println("Se detectaron errores");
			return "categorias/formCategoria";
		}
		serviceCategorias.save(categoria);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		return "redirect:/categorias/index";
	}

}
