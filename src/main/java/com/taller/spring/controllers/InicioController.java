package com.taller.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador principal 
 * @author Eva
 *
 */
@Controller
public class InicioController {
	@GetMapping("/")
	public String indexController() {
		return "inicio";
	}
}
