package com.haytam.reservation.graphql.services;

import com.haytam.reservation.core.entities.Chambre;
import com.haytam.reservation.core.entities.Client;
import com.haytam.reservation.core.entities.Reservation;
import com.haytam.reservation.core.entities.enums.StatusReservation;
import com.haytam.reservation.core.repositories.ChambreRepository;
import com.haytam.reservation.core.repositories.ClientRepository;
import com.haytam.reservation.core.repositories.ReservationRepository;
import com.haytam.reservation.core.dtos.ReservationDTO;
import com.haytam.reservation.core.dtos.ClientDTO;
import com.haytam.reservation.core.dtos.ChambreDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GraphqlReservationService {

    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;
    private final ChambreRepository chambreRepository;

//    public ReservationDTO saveReservation(ReservationDTO reservationDTO) {
//        Client client = clientRepository.findById(reservationDTO.getClient().getId())
//                .orElseThrow(() -> new RuntimeException("Client not found"));
//        Chambre chambre = chambreRepository.findById(reservationDTO.getChambre().getId())
//                .orElseThrow(() -> new RuntimeException("Chambre not found"));
//
//        Reservation reservation = new Reservation();
//        reservation.setClient(client);
//        reservation.setChambre(chambre);
//        reservation.setDateDebut(reservationDTO.getDateDebut());
//        reservation.setDateFin(reservationDTO.getDateFin());
//        reservation.setStatus(StatusReservation.valueOf(reservationDTO.getStatus()));
//        reservation.setNombrePersonnes(reservationDTO.getNombrePersonnes());
//
//        Reservation savedReservation = reservationRepository.save(reservation);
//
//        return mapToDto(savedReservation);
//    }

//    public ReservationDTO saveReservation(ReservationDTO reservationDTO) {
//        Long clientId = reservationDTO.getClient().getId(); // Ensure this is populated
//        Long chambreId = reservationDTO.getChambre().getId(); // Ensure this is populated
//
//        Client client = clientRepository.findById(clientId)
//                .orElseThrow(() -> new RuntimeException("Client not found"));
//        Chambre chambre = chambreRepository.findById(chambreId)
//                .orElseThrow(() -> new RuntimeException("Chambre not found"));
//
//        Reservation reservation = new Reservation();
//        reservation.setClient(client);
//        reservation.setChambre(chambre);
//        reservation.setDateDebut(reservationDTO.getDateDebut());
//        reservation.setDateFin(reservationDTO.getDateFin());
//        reservation.setStatus(StatusReservation.valueOf(reservationDTO.getStatus()));
//        reservation.setNombrePersonnes(reservationDTO.getNombrePersonnes());
//
//        Reservation savedReservation = reservationRepository.save(reservation);
//
//        return mapToDto(savedReservation);
//    }

    public ReservationDTO saveReservation(ReservationDTO reservationDTO) {
        validateReservationDTO(reservationDTO);

        Long clientId = reservationDTO.getClient().getId();
        Long chambreId = reservationDTO.getChambre().getId();

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + clientId));
        Chambre chambre = chambreRepository.findById(chambreId)
                .orElseThrow(() -> new RuntimeException("Chambre not found with ID: " + chambreId));

        // Validate dates
        if (reservationDTO.getDateFin().before(reservationDTO.getDateDebut())) {
            throw new RuntimeException("End date cannot be before start date");
        }

        Reservation reservation = new Reservation();
        reservation.setClient(client);
        reservation.setChambre(chambre);
        reservation.setDateDebut(reservationDTO.getDateDebut());
        reservation.setDateFin(reservationDTO.getDateFin());
        reservation.setStatus(StatusReservation.valueOf(reservationDTO.getStatus()));
        reservation.setNombrePersonnes(reservationDTO.getNombrePersonnes());

        Reservation savedReservation = reservationRepository.save(reservation);

        return mapToDto(savedReservation);
    }

    private void validateReservationDTO(ReservationDTO reservationDTO) {
        if (reservationDTO.getClient() == null || reservationDTO.getClient().getId() == null) {
            throw new RuntimeException("Client ID is required");
        }
        if (reservationDTO.getChambre() == null || reservationDTO.getChambre().getId() == null) {
            throw new RuntimeException("Chambre ID is required");
        }
        if (reservationDTO.getDateDebut() == null || reservationDTO.getDateFin() == null) {
            throw new RuntimeException("Start and end dates are required");
        }
        if (reservationDTO.getNombrePersonnes() == null || reservationDTO.getNombrePersonnes() <= 0) {
            throw new RuntimeException("Number of persons must be greater than 0");
        }
    }

    public List<ReservationDTO> getAllReservations() {
        return reservationRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public ReservationDTO getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        return mapToDto(reservation);
    }

    public List<ReservationDTO> getReservationsByStatus(String status) {
        return reservationRepository.findByStatus(StatusReservation.valueOf(status))
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public List<ReservationDTO> getReservationsForClient(Long clientId) {
        return reservationRepository.findByClientId(clientId)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public List<ReservationDTO> getReservationsForChambre(Long chambreId) {
        return reservationRepository.findByChambreId(chambreId)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public ReservationDTO updateReservation(Long id, ReservationDTO reservationDTO) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        Client client = clientRepository.findById(reservationDTO.getClient().getId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        Chambre chambre = chambreRepository.findById(reservationDTO.getChambre().getId())
                .orElseThrow(() -> new RuntimeException("Chambre not found"));

        reservation.setClient(client);
        reservation.setChambre(chambre);
        reservation.setDateDebut(reservationDTO.getDateDebut());
        reservation.setDateFin(reservationDTO.getDateFin());
        reservation.setStatus(StatusReservation.valueOf(reservationDTO.getStatus()));
        reservation.setNombrePersonnes(reservationDTO.getNombrePersonnes());

        Reservation updatedReservation = reservationRepository.save(reservation);
        return mapToDto(updatedReservation);
    }

    public void deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        reservationRepository.delete(reservation);
    }

    private ReservationDTO mapToDto(Reservation reservation) {
        ClientDTO clientDTO = new ClientDTO(
                reservation.getClient().getId(),
                reservation.getClient().getNom(),
                reservation.getClient().getPrenom(),
                reservation.getClient().getEmail(),
                reservation.getClient().getNumTelephone(),
                null  // No need to fetch reservations here since they are not required in DTO
        );

        ChambreDTO chambreDTO = new ChambreDTO(
                reservation.getChambre().getId(),
                reservation.getChambre().getTypeChambre().name(),
                reservation.getChambre().getPrix(),
                reservation.getChambre().getDisponible(),
                reservation.getChambre().getNumeroChambre(),
                reservation.getChambre().getDescription(),
                null  // Same for reservations here
        );

        return new ReservationDTO(
                reservation.getId(),
                clientDTO,
                chambreDTO,
                reservation.getDateDebut(),
                reservation.getDateFin(),
                reservation.getStatus().toString(),
                reservation.getNombrePersonnes()
        );
    }
}
