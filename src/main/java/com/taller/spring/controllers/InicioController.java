package com.taller.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
	@GetMapping("/")
	public String iniciarSesion() {
		return "inicio";
	}
}
