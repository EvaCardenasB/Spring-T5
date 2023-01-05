package com.taller.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.taller.spring.entity.Client;
import com.taller.spring.service.ClientManagementServiceI;

@SpringBootApplication
public class SpringMain implements CommandLineRunner {

	Client client = new Client();
	@Autowired
	private ClientManagementServiceI clientService;

	public static void main(String[] args) {
		SpringApplication.run(SpringMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Consumir clase servicio

		// Crear cliente
		client.setName("Cristina");
		client.setSurname1("Sanchez");
		client.setSurname2("Flores");
		client.setDateOfBirth("28/04/06");
		client.setDni("29678675K");

		// Añadir cliente
		clientService.insertNewClient(client);

		// Actualizar cliente
		client.setDni("29678675M");
		clientService.updateClient(client);

		// Eliminar un cliente
		// clientService.deleteClient(client);

		// Buscar un cliente por id
		System.out.println(clientService.searchById(17L) == null ? "No existe cliente con ese id" : clientService.searchById(17L).getName());

		// Buscar todos los clientes de la base de datos
		System.out.println(clientService.searchAll().toString());

		// Buscar todos los clientes de la base de datos
		System.out.println(clientService.searchByNameAndSurname1AndSurname2("C%", "S%", "F%"));

	}

}
