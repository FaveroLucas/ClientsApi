package com.cliente.service;

import com.cliente.models.Client;
import com.cliente.repository.ClientRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients(Pageable page) { return clientRepository.findAll(page).getContent();}

    public List<Client> getClientsName(Pageable page, String name) { return clientRepository.findAllByNome(name, page);}

    public List<Client> getClientsCpf(Pageable page, String cpf) { return clientRepository.findAllByCpf(cpf, page);}

    public ResponseEntity createdClient(Client client) { return ResponseEntity.ok().body(clientRepository.save(client));}

    public ResponseEntity updateClient(String id, Client client) {
        Optional<Client> clientOp = clientRepository.findById(id);
        if (!clientOp.isPresent()){
            return ResponseEntity.notFound().build();
        }

        Client cl = clientOp.get();
        cl.setCpf(client.getCpf());
        cl.setName(client.getName());
        cl.setDob(client.getDob());

        Client ClientUpdated = clientRepository.save(cl);
        return ResponseEntity.ok().body(ClientUpdated);
    }

//    public void deleteClient(String id) {
//        boolean exists = clientRepository.existsById(id);
//        if (!exists){
//            throw new IllegalStateException("client with id " + id + " does not exist");
//        }
//        clientRepository.deleteById(id);
//    }
}
