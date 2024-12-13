package com.haytam.reservation.graphql.controllers;

import com.haytam.reservation.core.dtos.ClientDTO;
import com.haytam.reservation.graphql.services.GraphqlClientService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class ClientControllerGraphQL {

    private final GraphqlClientService clientService;

    @MutationMapping
    public ClientDTO saveClient(@Argument ClientDTO clientDTO) {
        return clientService.saveClient(clientDTO);
    }

    @QueryMapping
    public List<ClientDTO> allClients() {
        return clientService.getAllClients();
    }

    @QueryMapping
    public ClientDTO clientById(@Argument Long id) {
        return clientService.getClientById(id);
    }

    @MutationMapping
    public ClientDTO updateClient(@Argument Long id, @Argument ClientDTO clientDTO) {
        return clientService.updateClient(id, clientDTO);
    }


    @MutationMapping
    public String deleteClient(@Argument Long id) {
        clientService.deleteClient(id);
        return "Client deleted successfully";
    }
}
