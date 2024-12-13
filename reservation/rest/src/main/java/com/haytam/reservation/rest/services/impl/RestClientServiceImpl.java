package com.haytam.reservation.rest.services.impl;

import com.haytam.reservation.rest.services.RestClientService;
import com.haytam.reservation.core.dtos.ClientDTO;
import com.haytam.reservation.core.entities.Client;
import com.haytam.reservation.core.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("restClientServiceImpl")
public class RestClientServiceImpl implements RestClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClientById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.map(this::toDTO).orElse(null);
    }

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = toEntity(clientDTO);
        Client savedClient = clientRepository.save(client);
        return toDTO(savedClient);
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isEmpty()) {
            return null;
        }
        Client client = clientOptional.get();
        client.setNom(clientDTO.getNom());
        client.setPrenom(clientDTO.getPrenom());
        client.setEmail(clientDTO.getEmail());
        client.setNumTelephone(clientDTO.getNumTelephone());
        Client updatedClient = clientRepository.save(client);
        return toDTO(updatedClient);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    private ClientDTO toDTO(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setNom(client.getNom());
        dto.setPrenom(client.getPrenom());
        dto.setEmail(client.getEmail());
        dto.setNumTelephone(client.getNumTelephone());
        return dto;
    }

    private Client toEntity(ClientDTO dto) {
        Client client = new Client();
        client.setNom(dto.getNom());
        client.setPrenom(dto.getPrenom());
        client.setEmail(dto.getEmail());
        client.setNumTelephone(dto.getNumTelephone());
        return client;
    }
}
