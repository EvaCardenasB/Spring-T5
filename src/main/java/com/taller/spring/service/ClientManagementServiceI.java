package com.taller.spring.service;

import java.util.List;

import com.taller.spring.entity.Client;



public interface ClientManagementServiceI {
	/**
	 * Inserta un nuevo cliente
	 * 
	 * @param newClient
	 */
	public void insertNewClient(final Client newClient);

	
	/**
	 * Actualiza un cliente
	 * 
	 * @param updatedClient
	 */
	public void updateClient(final Client updatedClient);

	
	/**
	 * Elimina un cliente
	 * 
	 * @param deletedClient
	 */
	public void deleteClient(final Client deletedClient);


	/**
	 * Obtiene un cliente mediante su id
	 * 
	 * @param clientId
	 * @return
	 */
	public Client searchById(final Long clientId);
	
	/**
	 * Obtiene todos los clientes de la DB
	 * 
	 * @return
	 */
	public List<Client> searchAll();
	
	/**
	 * Obtiene un cliente mediante su id
	 * 
	 * @param clientId
	 * @return
	 */

	Client searchByNameAndSurname1AndSurname2(String name, String surname1, String surname2);

}
