package com.taller.spring.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 
 * Entidad de tabla CLIENTE
 * 
 * @author Eva
 *
 */
@Entity
@Table(name = "client")
public class Client implements Serializable  {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	/** Nombre del cliente */
	@Column(name = "NAME", nullable = false)
	private String name;

	/** Primer apellido del cliente */
	@Column(name = "SURNAME1", nullable = false)
	private String surname1;

	/** Segundo apellido del cliente */
	@Column(name = "SURNAME2", nullable = false)
	private String surname2;
	
	/** Fecha de nacimiento del cliente */
	@Column(name = "DATE_OF_BIRTH", nullable = false)
	private String dateOfBirth;
	
	@Column(name = "DNI", nullable = false)
	/** dni del cliente */
	private String dni;


	/**
	 * @param name
	 * @param surname1
	 * @param surname2
	 * @param dateOfBirth
	 * @param dni
	 */
	public Client(String name, String surname1, String surname2, String dateOfBirth, String dni) {
		super();
		this.name = name;
		this.surname1 = surname1;
		this.surname2 = surname2;
		this.dateOfBirth = dateOfBirth;
		this.dni = dni;
	}
	


	public Client() {
		
	}



	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname1
	 */
	
	public String getSurname1() {
		return surname1;
	}

	/**
	 * @param surname1 the surname1 to set
	 */
	public void setSurname1(String surname1) {
		this.surname1 = surname1;
	}

	/**
	 * @return the surname2
	 */
	
	public String getSurname2() {
		return surname2;
	}

	/**
	 * @param surname2 the surname2 to set
	 */
	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}
	@Override
	public String toString() {
		return "Cliente [clientId=" + id + ", name=" + name + ", surname1=" + surname1 + ", surname2=" + surname2
				+ ", dni=" + dni + "]\n";
	}
	
}
