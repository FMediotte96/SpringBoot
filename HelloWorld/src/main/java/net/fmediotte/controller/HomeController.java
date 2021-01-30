package net.fmediotte.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping(path = "/")
	public String inicio() {
		return "Hola Mundo";
	}

}
