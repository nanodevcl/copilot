package com.example.demo.repository;

import com.example.demo.model.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void testSaveClient() {
        // Arrange
        Client client = new Client(1L, "John", "Doe", "16582189-0", "john@example.com");

        // Act
        Client savedClient = clientRepository.save(client);

        // Assert
        assertNotNull(savedClient.getId());
        assertEquals(client.getNombre(), savedClient.getNombre());
        assertEquals(client.getApellido(), savedClient.getApellido());
        assertEquals(client.getRut(), savedClient.getRut());
        assertEquals(client.getEmail(), savedClient.getEmail());
    }

    @Test
    void testFindAllClients() {
        // Arrange
        Client client1 = new Client(1L, "John", "Doe", "16582189-0", "john@example.com");
        Client client2 = new Client(2L, "Jane", "Smith", "12183117-1", "jane@example.com");
        clientRepository.save(client1);
        clientRepository.save(client2);

        // Act
        List<Client> clients = clientRepository.findAll();

        // Assert
        assertEquals(2, clients.size());
        assertFalse(clients.contains(client1));
        assertFalse(clients.contains(client2));
    }

    @Test
    void testFindClientById() {
        // Arrange
        Client client = new Client(1L, "John", "Doe", "16582189-0", "john@example.com");
        clientRepository.save(client);

        // Act
        Optional<Client> foundClient = clientRepository.findById(client.getId());

        // Assert
        assertTrue(foundClient.isPresent());
        assertEquals(client.getId(), foundClient.get().getId());
    }

    @Test
    void testFindClientById_ReturnsEmptyOptionalWhenClientNotFound() {
        // Arrange
        Long clientId = 1L;

        // Act
        Optional<Client> foundClient = clientRepository.findById(clientId);

        // Assert
        assertFalse(foundClient.isPresent());
    }

    @Test
    void testDeleteClient() {
        // Arrange
        Client client = new Client(1L, "John", "Doe", "16582189-0", "john@example.com");
        clientRepository.save(client);

        // Act
        clientRepository.delete(client);

        // Assert
        assertFalse(clientRepository.existsById(client.getId()));
    }
}