package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

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
    void testGetAllClients() {
        // Arrange
        List<Client> clients = new ArrayList<>();
        Client client1 = new Client();
        client1.setId(1L);
        client1.setNombre("John");
        client1.setApellido("Doe");
        client1.setRut("16582189-0");
        client1.setEmail("johndoe@example.com");
        clients.add(client1);

        Client client2 = new Client();
        client2.setId(2L);
        client2.setNombre("Jane");
        client2.setApellido("Smith");
        client2.setRut("12345678-9");
        client2.setEmail("janesmith@example.com");
        clients.add(client2);

        // Act
        when(clientService.getAllClients()).thenReturn(clients);
        List<Client> retrievedClients = clientController.getAllClients();

        // Assert
        assertNotNull(retrievedClients);
        assertEquals(2, retrievedClients.size());
        assertEquals(client1.getId(), retrievedClients.get(0).getId());
        assertEquals(client1.getNombre(), retrievedClients.get(0).getNombre());
        assertEquals(client1.getApellido(), retrievedClients.get(0).getApellido());
        assertEquals(client1.getRut(), retrievedClients.get(0).getRut());
        assertEquals(client1.getEmail(), retrievedClients.get(0).getEmail());
        assertEquals(client2.getId(), retrievedClients.get(1).getId());
        assertEquals(client2.getNombre(), retrievedClients.get(1).getNombre());
        assertEquals(client2.getApellido(), retrievedClients.get(1).getApellido());
        assertEquals(client2.getRut(), retrievedClients.get(1).getRut());
        assertEquals(client2.getEmail(), retrievedClients.get(1).getEmail());
        verify(clientService, times(1)).getAllClients();
    }

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