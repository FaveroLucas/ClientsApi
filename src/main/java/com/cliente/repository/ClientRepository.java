package com.cliente.repository;

import com.cliente.models.Client;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ClientRepository extends MongoRepository<Client, String> {

    List<Client> findAllByNome(String name, Pageable page);

    List<Client> findAllByCpf(String cpf, Pageable page);
}
