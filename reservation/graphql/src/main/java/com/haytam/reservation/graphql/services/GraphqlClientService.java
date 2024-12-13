package com.haytam.reservation.graphql.services;

import com.haytam.reservation.core.entities.Chambre;
import com.haytam.reservation.core.entities.Client;
import com.haytam.reservation.core.entities.Reservation;
import com.haytam.reservation.core.entities.enums.StatusReservation;
import com.haytam.reservation.core.entities.enums.TypeChambre;
import com.haytam.reservation.core.repositories.ChambreRepository;
import com.haytam.reservation.core.repositories.ClientRepository;
import com.haytam.reservation.core.repositories.ReservationRepository;
import com.haytam.reservation.core.dtos.ChambreDTO;
import com.haytam.reservation.core.dtos.ClientDTO;
import com.haytam.reservation.core.dtos.ReservationDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GraphqlClientService {

    private final ClientRepository clientRepository;
    private final ReservationRepository reservationRepository;
    private final ChambreRepository chambreRepository;

    public GraphqlClientService(ClientRepository clientRepository, ReservationRepository reservationRepository, ChambreRepository chambreRepository) {
        this.clientRepository = clientRepository;
        this.reservationRepository = reservationRepository;
        this.chambreRepository = chambreRepository;
    }

    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = mapToEntity(clientDTO);
        Client savedClient = clientRepository.save(client);
        return mapToDto(savedClient);
    }

    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public ClientDTO getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return mapToDto(client);
    }

    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Client not found for deletion");
        }
        clientRepository.deleteById(id);
    }

    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        client.setNom(clientDTO.getNom());
        client.setPrenom(clientDTO.getPrenom());
        client.setEmail(clientDTO.getEmail());
        client.setNumTelephone(clientDTO.getNumTelephone());

        client.setReservations(clientDTO.getReservationIds().stream()
                .map(this::findReservationById)
                .collect(Collectors.toList()));

        Client updatedClient = clientRepository.save(client);
        return mapToDto(updatedClient);
    }

    private ClientDTO mapToDto(Client client) {
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

    private Client mapToEntity(ClientDTO clientDTO) {
        return Client.builder()
                .id(clientDTO.getId())
                .nom(clientDTO.getNom())
                .prenom(clientDTO.getPrenom())
                .email(clientDTO.getEmail())
                .numTelephone(clientDTO.getNumTelephone())
                .reservations(clientDTO.getReservationIds().stream()
                        .map(this::findReservationById)
                        .collect(Collectors.toList()))
                .build();
    }

    private ReservationDTO mapToDto(Reservation reservation) {
        return new ReservationDTO(
                reservation.getId(),
                new ClientDTO(reservation.getClient().getId(), null, null, null, null, null),
                new ChambreDTO(reservation.getChambre().getId(), null, null, null, null, null, null),
                reservation.getDateDebut(),
                reservation.getDateFin(),
                reservation.getStatus().name(),
                reservation.getNombrePersonnes()
        );
    }

    private Reservation mapToEntity(ReservationDTO reservationDTO) {
        return new Reservation(
                reservationDTO.getId(),
                findClientById(reservationDTO.getClient().getId()),
                findChambreById(reservationDTO.getChambre().getId()),
                reservationDTO.getDateDebut(),
                reservationDTO.getDateFin(),
                StatusReservation.valueOf(reservationDTO.getStatus()),
                reservationDTO.getNombrePersonnes()
        );
    }

    private Reservation findReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    private Client findClientById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    private Chambre findChambreById(Long chambreId) {
        return chambreRepository.findById(chambreId)
                .orElseThrow(() -> new RuntimeException("Chambre not found"));
    }

    private ChambreDTO mapToDto(Chambre chambre) {
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

    private Chambre mapToEntity(ChambreDTO chambreDTO) {
        return new Chambre(
                chambreDTO.getId(),
                TypeChambre.valueOf(chambreDTO.getTypeChambre()),
                chambreDTO.getPrix(),
                chambreDTO.getDisponible(),
                chambreDTO.getNumeroChambre(),
                chambreDTO.getDescription(),
                chambreDTO.getReservationIds().stream()
                        .map(this::findReservationById)
                        .collect(Collectors.toList())
        );
    }
}
