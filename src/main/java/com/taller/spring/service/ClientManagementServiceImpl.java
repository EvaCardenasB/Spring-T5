package com.taller.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.spring.entity.Client;
import com.taller.spring.repository.ClientRepository;

/**
 * Servicio de gestion de clientes
 * @author Eva
 *
 */
@Service
public class ClientManagementServiceImpl implements ClientManagementServiceI {

	@Autowired
	private ClientRepository clientRepository;

	/**
	 * Insertar clientes de la DB
	 */
	@Override
	public void insertNewClient(final Client newClient) {

		// Verificación de nulidad o inexistencia en la DB
		if (newClient != null && newClient.getId() == null) {

			// Insercción del nuevo cliente.
			clientRepository.save(newClient);
		}

	}

	/**
	 * Actualizar clientes de la DB
	 */
	@Override
	public void updateClient(final Client updatedClient) {

		// Verificación de nulidad o inexistencia en la DB
		if (updatedClient != null && updatedClient.getId() != null) {

			// Actualización del cliente.
			clientRepository.save(updatedClient);
		}

	}

	/**
	 * Eliminar clientes de la DB
	 */
	@Override
	public void deleteClient(final Client deletedClient) {

		// Verificación de nulidad o inexistencia en la DB
		if (deletedClient != null && deletedClient.getId() != null) {

			// Eliminación del cliente
			clientRepository.delete(deletedClient);
		}

	}

	/**
	 * Buscar clientes por id .orElse(null), si no encuentra el cliente que devuelva
	 * null, tuve que añadir esto porque me devolvía un optional (no tengo claro el
	 * por qué)
	 */
	@Override
	public Client searchById(final Long clientId) {
		Client client = null;

		// Verificación de nulidad
		if (clientId != null) {

			// Obtención del cliente por id
			client = clientRepository.findById(clientId).orElse(null);
		}

		return client;
	}

	/**
	 * Busca todos los clientes de la DB
	 */
	@Override
	public List<Client> searchAll() {
		return (List<Client>) clientRepository.findAll();
	}

	/**
	 * Busca los clientes por nombre y apellidos
	 */
	@Override
	public Client searchByNameAndSurname1AndSurname2(final String name, final String surname1, final String surname2) {
		Client client = null;

		// Obtención del cliente por nombre y apellidos
		client = clientRepository.findByNameAndSurname1AndSurname2(name, surname1, surname2);

		return client;
	}

}
