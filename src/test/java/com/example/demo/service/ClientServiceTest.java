package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ClientServiceTests {

    @Mock
    private ClientRepository clientRepository;

    private ClientService clientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clientService = new ClientService(clientRepository);
    }

    @Test
    void testGetAllClients() {
        // Arrange
        List<Client> clients = new ArrayList<>();
        clients.add(new Client(1L, "John", "Doe", "16582189-0", "john@example.com"));
        clients.add(new Client(2L, "Jane", "Smith", "12183117-1", "jane@example.com"));
        when(clientRepository.findAll()).thenReturn(clients);

        // Act
        List<Client> result = clientService.getAllClients();

        // Assert
        assertEquals(clients, result);
        verify(clientRepository, times(1)).findAll();
    }

    @Test
    void testGetClientById() {
        // Arrange
        Long clientId = 1L;
        Client client = new Client(clientId, "John Doe", "", "16582189-0", "john@example.com");
        when(clientRepository.findById(clientId)).thenReturn(Optional.of(client));

        // Act
        Client result = clientService.getClientById(clientId);

        // Assert
        assertEquals(client, result);
        verify(clientRepository, times(1)).findById(clientId);
    }

    @Test
    void testGetClientById_ThrowsExceptionWhenClientNotFound() {
        // Arrange
        Long clientId = 1L;
        when(clientRepository.findById(clientId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(RuntimeException.class, () -> clientService.getClientById(clientId));
        verify(clientRepository, times(1)).findById(clientId);
    }

    @Test
    void testCreateClient() {
        // Arrange
        Client client = new Client(1L, "John", "Doe", "16582189-0", "john@example.com");
        when(clientRepository.save(client)).thenReturn(client);

        // Act
        Client result = clientService.createClient(client);

        // Assert
        assertEquals(client, result);
        verify(clientRepository, times(1)).save(client);
    }

    @Test
    void testUpdateClient() {
        // Arrange
        Long clientId = 1L;
        Client existingClient = new Client(clientId, "Juan", "Lopez", "16582189-0", "john@example.com");
        Client updatedClient = new Client(clientId, "John", "Perez", "16582189-0", "john@example.com");
        when(clientRepository.findById(clientId)).thenReturn(Optional.of(existingClient));
        when(clientRepository.save(existingClient)).thenReturn(updatedClient);

        // Act
        Client result = clientService.updateClient(clientId, updatedClient);

        // Assert
        assertEquals(updatedClient, result);
        assertEquals(updatedClient.getNombre(), existingClient.getNombre());
        assertEquals(updatedClient.getEmail(), existingClient.getEmail());
        verify(clientRepository, times(1)).findById(clientId);
        verify(clientRepository, times(1)).save(existingClient);
    }

    @Test
    void testUpdateClient_ThrowsExceptionWhenClientNotFound() {
        // Arrange
        Long clientId = 1L;
        Client updatedClient = new Client(clientId, "Updated Name", "updated@example.com", "20049936-0", "test@mail.com");
        when(clientRepository.findById(clientId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(RuntimeException.class, () -> clientService.updateClient(clientId, updatedClient));
        verify(clientRepository, times(1)).findById(clientId);
    }

    @Test
    void testDeleteClient() {
        // Arrange
        Long clientId = 1L;
        Client client = new Client(clientId, "John Doe", "john@example.com", null, null);
        when(clientRepository.findById(clientId)).thenReturn(Optional.of(client));

        // Act
        clientService.deleteClient(clientId);

        // Assert
        verify(clientRepository, times(1)).findById(clientId);
        verify(clientRepository, times(1)).delete(client);
    }

    @Test
    void testDeleteClient_ThrowsExceptionWhenClientNotFound() {
        // Arrange
        Long clientId = 1L;
        when(clientRepository.findById(clientId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(RuntimeException.class, () -> clientService.deleteClient(clientId));
        verify(clientRepository, times(1)).findById(clientId);
    }
}