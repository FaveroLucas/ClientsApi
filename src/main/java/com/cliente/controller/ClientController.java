package com.cliente.controller;


import com.cliente.models.Client;
import com.cliente.service.ClientService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getClients(
            @PageableDefault(sort = "name", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable page
            ){
        return ResponseEntity.ok(clientService.getClients(page));
    }

    @GetMapping(path = "/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getClientsName(
            @RequestParam(required = true) String name,
            @PageableDefault(sort = "name", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable page
        ){
            return ResponseEntity.ok(clientService.getClientsName(page, name));
    }
    @GetMapping(path = "/cpf", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getClientsCpf(
            @RequestParam(required = true) String cpf,
            @PageableDefault(sort = "name", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable page
    ){
        return ResponseEntity.ok(clientService.getClientsCpf(page, cpf));
    }
    @PostMapping
    public ResponseEntity createdClient(@RequestBody Client client){return clientService.createdClient(client);}

    @PutMapping("/{id}")
    public ResponseEntity updateClient(@RequestBody Client client,
                                       @PathVariable("id") String id){
        return clientService.updateClient(id, client);
    }

//    @DeleteMapping("/{id}")
//    public void deleteClient(@PathVariable("id") String id){
//        clientService.deleteClient(id);
//    }
}
