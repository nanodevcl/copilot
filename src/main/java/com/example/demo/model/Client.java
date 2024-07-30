package com.example.demo.model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Represents a client in the system.
 */
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String rut;
    private String email;

    /**
     * Retrieves the ID of the client.
     * 
     * @return the ID of the client
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the client.
     * 
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the client.
     * 
     * @return the name of the client
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the name of the client.
     * 
     * @param nombre the name to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retrieves the last name of the client.
     * 
     * @return the last name of the client
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Sets the last name of the client.
     * 
     * @param apellido the last name to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Retrieves the RUT (national identification number) of the client.
     * 
     * @return the RUT of the client
     */
    public String getRut() {
        return rut;
    }

    /**
     * Sets the RUT (national identification number) of the client.
     * 
     * @param rut the RUT to set
     */
    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     * Retrieves the email address of the client.
     * 
     * @return the email address of the client
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the client.
     * 
     * @param email the email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Constructs a new Client object with the specified properties.
     * 
     * @param id the ID of the client
     * @param nombre the name of the client
     * @param apellido the last name of the client
     * @param rut the RUT of the client
     * @param email the email address of the client
     */
    public Client(Long id, String nombre, String apellido, String rut, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.email = email;
    }

    /**
     * Constructs a new empty Client object.
     */
    public Client() {
        // Empty constructor
    }
}
