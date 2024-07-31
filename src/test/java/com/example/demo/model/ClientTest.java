package com.example.demo.model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTests {

    @Test
    void testGetId() {
        // Arrange
        Long id = 1L;
        Client client = new Client(id, "John", "Doe", "16582189-0", "john@example.com");

        // Act
        Long result = client.getId();

        // Assert
        assertEquals(id, result);
    }

    @Test
    void testSetId() {
        // Arrange
        Long id = 1L;
        Client client = new Client();

        // Act
        client.setId(id);

        // Assert
        assertEquals(id, client.getId());
    }

    @Test
    void testGetNombre() {
        // Arrange
        String nombre = "John";
        Client client = new Client(1L, nombre, "Doe", "16582189-0", "john@example.com");

        // Act
        String result = client.getNombre();

        // Assert
        assertEquals(nombre, result);
    }

    @Test
    void testSetNombre() {
        // Arrange
        String nombre = "John";
        Client client = new Client();

        // Act
        client.setNombre(nombre);

        // Assert
        assertEquals(nombre, client.getNombre());
    }

    @Test
    void testGetApellido() {
        // Arrange
        String apellido = "Doe";
        Client client = new Client(1L, "John", apellido, "16582189-0", "john@example.com");

        // Act
        String result = client.getApellido();

        // Assert
        assertEquals(apellido, result);
    }

    @Test
    void testSetApellido() {
        // Arrange
        String apellido = "Doe";
        Client client = new Client();

        // Act
        client.setApellido(apellido);

        // Assert
        assertEquals(apellido, client.getApellido());
    }

    @Test
    void testGetRut() {
        // Arrange
        String rut = "16582189-0";
        Client client = new Client(1L, "John", "Doe", rut, "john@example.com");

        // Act
        String result = client.getRut();

        // Assert
        assertEquals(rut, result);
    }

    @Test
    void testSetRut() {
        // Arrange
        String rut = "16582189-0";
        Client client = new Client();

        // Act
        client.setRut(rut);

        // Assert
        assertEquals(rut, client.getRut());
    }

    @Test
    void testGetEmail() {
        // Arrange
        String email = "john@example.com";
        Client client = new Client(1L, "John", "Doe", "16582189-0", email);

        // Act
        String result = client.getEmail();

        // Assert
        assertEquals(email, result);
    }

    @Test
    void testSetEmail() {
        // Arrange
        String email = "john@example.com";
        Client client = new Client();

        // Act
        client.setEmail(email);

        // Assert
        assertEquals(email, client.getEmail());
    }
}