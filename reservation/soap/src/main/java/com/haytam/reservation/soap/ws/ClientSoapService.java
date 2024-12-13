package com.haytam.reservation.soap.ws;

import com.haytam.reservation.core.dtos.ChambreDTO;
import com.haytam.reservation.core.dtos.ClientDTO;
import com.haytam.reservation.core.dtos.ReservationDTO;
import com.haytam.reservation.core.entities.Chambre;
import com.haytam.reservation.core.entities.Client;
import com.haytam.reservation.core.entities.Reservation;
import com.haytam.reservation.core.repositories.ClientRepository;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@WebService(serviceName = "ClientWS")
public class ClientSoapService {

    @Autowired
    private ClientRepository clientRepository;

    @WebMethod
    public List<ClientDTO> getClients() {
        return clientRepository.findAll().stream()
                .map(this::mapClientToDTO)
                .collect(Collectors.toList());
    }

    @WebMethod
    public ClientDTO getClientById(@WebParam(name = "id") Long id) {
        return clientRepository.findById(id)
                .map(this::mapClientToDTO)
                .orElse(null);
    }

    @WebMethod
    public ClientDTO createClient(@WebParam(name = "nom") String nom, @WebParam(name = "email") String email) {
        Client client = new Client(null, nom, null, email, null, null);
        Client savedClient = clientRepository.save(client);
        return mapClientToDTO(savedClient);
    }

    @WebMethod
    public boolean deleteClient(@WebParam(name = "id") Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private ClientDTO mapClientToDTO(Client client) {
        return new ClientDTO(
                client.getId(),
                client.getNom(),
                client.getPrenom(),
                client.getEmail(),
                client.getNumTelephone(),
                client.getReservations().stream()
                        .map(Reservation::getId)
                        .collect(Collectors.toList())
        );
    }

    private ChambreDTO mapChambreToDTO(Chambre chambre) {
        return new ChambreDTO(
                chambre.getId(),
                chambre.getTypeChambre().toString(),
                chambre.getPrix(),
                chambre.getDisponible(),
                chambre.getNumeroChambre(),
                chambre.getDescription(),
                chambre.getReservations().stream()
                        .map(Reservation::getId)
                        .collect(Collectors.toList())
        );
    }

    private ReservationDTO mapReservationToDTO(Reservation reservation) {
        return new ReservationDTO(
                reservation.getId(),
                mapClientToDTO(reservation.getClient()),
                mapChambreToDTO(reservation.getChambre()),
                reservation.getDateDebut(),
                reservation.getDateFin(),
                reservation.getStatus().toString(),
                reservation.getNombrePersonnes()
        );
    }
}
