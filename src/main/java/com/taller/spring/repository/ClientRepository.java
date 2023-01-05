package com.taller.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taller.spring.entity.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	/**
	 * Busca clientes por nombre y apellidos
	 * 
	 * @param name
	 * @param surname1
	 * @param surname2
	 */
	Client findByNameAndSurname1AndSurname2(String name, String surname1,String surname2);
	
	/**
	 * Busca clientes por su dni.
	 * 
	 * @param dni
	 */
	Client findByDni(String dni);
	
	/**
	 * Busca clientes por su nombre.
	 * 
	 * @param name
	 */
	Client findByName(String name);

}
