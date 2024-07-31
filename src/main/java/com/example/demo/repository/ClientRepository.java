/**
 * The ClientRepository interface is responsible for providing CRUD operations for the Client entity.
 */
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Client;

/**
 * The ClientRepository interface provides methods to perform CRUD operations on the Client entity.
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}

