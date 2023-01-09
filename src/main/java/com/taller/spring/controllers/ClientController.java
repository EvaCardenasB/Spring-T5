package com.taller.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.taller.spring.entity.Client;
import com.taller.spring.repository.ClientRepository;

/**
 * 
 * Controlador REST
 * 
 * @author Eva
 *
 */


@RestController
@RequestMapping(path = "/client")
public class ClientController {
	@Autowired
	private ClientRepository clienteRepository;

	//Mostrar los clientes de la DB
	@RequestMapping("/mostrar")
	public @ResponseBody List<Client> mostrarCliente() {

		return clienteRepository.findAll();
	}

	// Agregar un cliente a la DB
	@PostMapping(value = "/agregar")
	public void guardarCliente(final @RequestBody Client client) {
		clienteRepository.save(client);
	}

	// Eliminar un cliente a la DB
	@PostMapping(value = "/eliminar/{id}")
	public void eliminarCliente(final @PathVariable Long id) {

		clienteRepository.deleteById(id);

	}

	// Editar un cliente
	@PostMapping(value = "/editar/{id}") 
	  public void actualizarCliente(final @PathVariable Long id,final @RequestBody Client client) { 
	
	  Client clienteExistente = clienteRepository.findByDni(client.getDni());
	  
	  if (clienteExistente != null && !clienteExistente.getId().equals(client.getId())) {
		  System.out.println("Ya existe un cliente con ese dni");
	  }
	  
	  clienteRepository.save(client);
	 }
	 
}
