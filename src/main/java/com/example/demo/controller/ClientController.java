package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Client;
import com.example.demo.service.ClientService;

/**
 * The ClientController class handles HTTP requests related to clients.
 */
@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    /**
     * Constructs a new ClientController with the given ClientService.
     * 
     * @param clientService the ClientService to be used
     */
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Retrieves all clients.
     * 
     * @return a list of all clients
     */
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    /**
     * Retrieves a client by its ID.
     * 
     * @param id the ID of the client to retrieve
     * @return the client with the specified ID
     */
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    /**
     * Creates a new client.
     * 
     * @param client the client to be created
     * @return the created client
     */
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    /**
     * Updates an existing client.
     * 
     * @param id the ID of the client to update
     * @param client the updated client information
     * @return the updated client
     */
    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }

    /**
     * Deletes a client by its ID.
     * 
     * @param id the ID of the client to delete
     */
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
