package com.cliente.repository;

import com.cliente.models.Client;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

    List<Client> findAllByNome(String name, Pageable page);

    List<Client> findAllByCpf(String cpf, Pageable page);
}
