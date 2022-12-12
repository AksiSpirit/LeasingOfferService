package ru.aksi.leasingofferservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aksi.leasingofferservice.model.Client;
import ru.aksi.leasingofferservice.repository.ClientRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    private ClientRepository clientRepository;
    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    @GetMapping("/{clientId}")
    public Client getClientById(UUID clientId) {
        return clientRepository.findById(clientId).orElse(null);
    }
}
