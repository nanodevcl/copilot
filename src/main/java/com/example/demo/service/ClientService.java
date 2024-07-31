package com.example.demo.service;
import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * This class represents a service for managing clients.
 */
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    /**
     * Constructs a new ClientService with the specified ClientRepository.
     * @param clientRepository the repository for accessing client data
     */
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Retrieves all clients from the repository.
     * @return a list of all clients
     */
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    /**
     * Retrieves a client by its ID from the repository.
     * @param id the ID of the client to retrieve
     * @return the client with the specified ID
     * @throws RuntimeException if no client is found with the specified ID
     */
    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
    }

    /**
     * Creates a new client in the repository.
     * @param client the client to create
     * @return the created client
     */
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    /**
     * Updates an existing client in the repository.
     * @param id the ID of the client to update
     * @param updatedClient the updated client data
     * @return the updated client
     * @throws RuntimeException if no client is found with the specified ID
     */
    public Client updateClient(Long id, Client updatedClient) {
        Client client = getClientById(id);
        client.setNombre(updatedClient.getNombre());
        client.setEmail(updatedClient.getEmail());
        // Set other properties as needed
        return clientRepository.save(client);
    } 

    /**
     * Deletes a client from the repository.
     * @param id the ID of the client to delete
     * @throws RuntimeException if no client is found with the specified ID
     */
    public void deleteClient(Long id) {
        Client client = getClientById(id);
        clientRepository.delete(client);
    }
}