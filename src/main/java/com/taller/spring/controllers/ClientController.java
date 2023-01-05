package com.taller.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.taller.spring.entity.Client;
import com.taller.spring.repository.ClientRepository;

@Controller
@RequestMapping(path = "/client")
public class ClientController {
	@Autowired
	private ClientRepository clienteRepository;

	@GetMapping(value = "/agregar")
	public String agregarCliente(Model model) {
		model.addAttribute("client", new Client());
		return "/add_client";
	}

	@GetMapping(value = "/mostrar")
	public String mostrarCliente(Model model) {
		model.addAttribute("clients", clienteRepository.findAll());
		return "/mostrar_clientes";
	}
	
	@GetMapping(value = "/buscar")
	public String buscarCliente(Model model) {
		return "/buscar_clientes";
	}
	
	/*@GetMapping(value = "/buscar/{name}")
	public String buscarCliente(Model model,@PathVariable String name) {
		model.addAttribute("clients", clienteRepository.findByName(name));
		return "/buscar_clientes";
	}*/

	@GetMapping(value = "/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable long id, Model model) {
		model.addAttribute("client", clienteRepository.findById(id).orElse(null));
		return "/editar_cliente";
	}
	

	// Agregar un cliente a la DB
	@PostMapping(value = "/agregar")
	public String guardarCliente(@ModelAttribute @Validated Client client, BindingResult bindingResult,
			RedirectAttributes redirectAttrs) {
		if (bindingResult.hasErrors()) {
			return "client/agregar";
		}
		if (clienteRepository.findByDni(client.getDni()) != null) {
			redirectAttrs.addFlashAttribute("mensaje", "Ya existe un cliente con ese dni").addFlashAttribute("clase",
					"warning");
			return "redirect:/client/agregar";
		}
		clienteRepository.save(client);
		redirectAttrs.addFlashAttribute("mensaje", "Agregado correctamente").addFlashAttribute("clase", "success");
		return "redirect:/client/agregar";
	}

	// Eliminar un cliente a la DB
	@PostMapping(value = "/eliminar")
	public String eliminarCliente(@ModelAttribute Client client, RedirectAttributes redirectAttrs) {
		redirectAttrs.addFlashAttribute("mensaje", "Eliminado correctamente").addFlashAttribute("clase", "warning");
		clienteRepository.deleteById(client.getId());
		return "redirect:/client/mostrar";
	}

	// Editar un cliente
	@PostMapping(value = "/editar/{id}")
	public String actualizarCliente(@ModelAttribute @Validated Client client, BindingResult bindingResult,
			RedirectAttributes redirectAttrs) {
		if (bindingResult.hasErrors()) {
			return "client/editar";
		}
		Client clienteExistente = clienteRepository.findByDni(client.getDni());

		if (clienteExistente != null && !clienteExistente.getId().equals(client.getId())) {
			redirectAttrs.addFlashAttribute("mensaje", "Ya existe un cliente con ese dni").addFlashAttribute("clase",
					"warning");
			return "redirect:/client/mostrar";
		}
		clienteRepository.save(client);
		redirectAttrs.addFlashAttribute("mensaje", "Cliente editado correctamente").addFlashAttribute("clase",
				"success");
		return "redirect:/client/mostrar";
	}
}
