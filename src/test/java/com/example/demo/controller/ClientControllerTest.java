package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Client;
import com.example.demo.service.ClientService;

@SpringBootTest
class ClientControllerTests {

    @Mock
    private ClientService clientService;

    @InjectMocks
    private ClientController clientController;

    @Test
    void testDeleteClient() {
        // Arrange
        Long clientId = 1L;

        // Act
        clientController.deleteClient(clientId);

        // Assert
        verify(clientService, times(1)).deleteClient(clientId);
    }

    @Test
    void testCreateClient() {
        // Arrange
        Client client = new Client();
        client.setId(1L);
        client.setNombre("John");
        client.setApellido("Doe");
        client.setRut("16582189-0");
        client.setEmail("johndoe@example.com");

        // Act
        when(clientService.createClient(client)).thenReturn(client);
        Client createdClient = clientController.createClient(client);

        // Assert
        assertNotNull(createdClient);
        assertEquals(client.getId(), createdClient.getId());
        assertEquals(client.getNombre(), createdClient.getNombre());
        assertEquals(client.getApellido(), createdClient.getApellido());
        assertEquals(client.getRut(), createdClient.getRut());
        assertEquals(client.getEmail(), createdClient.getEmail());
        verify(clientService, times(1)).createClient(client);
    }

    @Test
    void testGetClientById() {
        // Arrange
        Long clientId = 1L;
        Client client = new Client();
        client.setId(clientId);
        client.setNombre("John");
        client.setApellido("Doe");
        client.setRut("16582189-0");
        client.setEmail("johndoe@example.com");

        // Act
        when(clientService.getClientById(clientId)).thenReturn(client);
        Client retrievedClient = clientController.getClientById(clientId);

        // Assert
        assertNotNull(retrievedClient);
        assertEquals(client.getId(), retrievedClient.getId());
        assertEquals(client.getNombre(), retrievedClient.getNombre());
        assertEquals(client.getApellido(), retrievedClient.getApellido());
        assertEquals(client.getRut(), retrievedClient.getRut());          
        assertEquals(client.getEmail(), retrievedClient.getEmail());
        verify(clientService, times(1)).getClientById(clientId);
    }

    @Test
    void testUpdateClient() {
        // Arrange
        Long clientId = 1L;
        Client client = new Client();
        client.setId(clientId);
        client.setNombre("John");
        client.setApellido("Doe");
        client.setRut("16582189-0");
        client.setEmail("johndoe@example.com");

        // Act
        when(clientService.updateClient(clientId, client)).thenReturn(client);
        Client updatedClient = clientController.updateClient(clientId, client);

        // Assert
        assertNotNull(updatedClient);
        assertEquals(client.getId(), updatedClient.getId());
        assertEquals(client.getNombre(), updatedClient.getNombre());
        assertEquals(client.getApellido(), updatedClient.getApellido());
        assertEquals(client.getRut(), updatedClient.getRut());   
        assertEquals(client.getEmail(), updatedClient.getEmail());
        verify(clientService, times(1)).updateClient(clientId, client);
    }
}