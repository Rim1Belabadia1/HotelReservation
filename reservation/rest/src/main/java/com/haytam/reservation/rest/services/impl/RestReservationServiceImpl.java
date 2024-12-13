package com.haytam.reservation.rest.services.impl;

import com.haytam.reservation.rest.services.RestReservationService;
import com.haytam.reservation.core.dtos.ChambreDTO;
import com.haytam.reservation.core.dtos.ClientDTO;
import com.haytam.reservation.core.dtos.ReservationDTO;
import com.haytam.reservation.core.entities.Chambre;
import com.haytam.reservation.core.entities.Client;
import com.haytam.reservation.core.entities.Reservation;
import com.haytam.reservation.core.entities.enums.StatusReservation;
import com.haytam.reservation.core.entities.enums.TypeChambre;
import com.haytam.reservation.core.repositories.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("restReservationServiceImpl")
public class RestReservationServiceImpl implements RestReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<ReservationDTO> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ReservationDTO getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + id));
        return mapToDTO(reservation);
    }

    @Override
    public ReservationDTO createReservation(ReservationDTO reservationDTO) {
        Reservation reservation = mapToEntity(reservationDTO);
        Reservation savedReservation = reservationRepository.save(reservation);
        return mapToDTO(savedReservation);
    }

    @Override
    public ReservationDTO updateReservation(Long id, ReservationDTO reservationDTO) {
        Reservation existingReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + id));
        existingReservation.setDateDebut(reservationDTO.getDateDebut());
        existingReservation.setDateFin(reservationDTO.getDateFin());
        existingReservation.setNombrePersonnes(reservationDTO.getNombrePersonnes());
        existingReservation.setStatus(StatusReservation.valueOf(reservationDTO.getStatus()));
        existingReservation.setClient(mapToClientEntity(reservationDTO.getClient()));
        existingReservation.setChambre(mapToChambreEntity(reservationDTO.getChambre()));
        Reservation updatedReservation = reservationRepository.save(existingReservation);
        return mapToDTO(updatedReservation);
    }

    @Override
    public void deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + id));
        reservationRepository.delete(reservation);
    }

    private ReservationDTO mapToDTO(Reservation reservation) {
        return ReservationDTO.builder()
                .id(reservation.getId())
                .dateDebut(reservation.getDateDebut())
                .dateFin(reservation.getDateFin())
                .nombrePersonnes(reservation.getNombrePersonnes())
                .status(reservation.getStatus().name())
                .client(mapToClientDTO(reservation.getClient()))
                .chambre(mapToChambreDTO(reservation.getChambre()))
                .build();
    }

    private ClientDTO mapToClientDTO(Client client) {
        return new ClientDTO(client.getId(), client.getNom(), client.getPrenom(), client.getEmail(), client.getNumTelephone(), null);
    }

    private ChambreDTO mapToChambreDTO(Chambre chambre) {
        return new ChambreDTO(chambre.getId(), chambre.getTypeChambre().name(), chambre.getPrix(), chambre.getDisponible(), chambre.getNumeroChambre(), chambre.getDescription(), null);
    }


    private Reservation mapToEntity(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setDateDebut(reservationDTO.getDateDebut());
        reservation.setDateFin(reservationDTO.getDateFin());
        reservation.setNombrePersonnes(reservationDTO.getNombrePersonnes());
        reservation.setStatus(StatusReservation.valueOf(reservationDTO.getStatus()));
        reservation.setClient(mapToClientEntity(reservationDTO.getClient()));
        reservation.setChambre(mapToChambreEntity(reservationDTO.getChambre()));
        return reservation;
    }

    private Client mapToClientEntity(ClientDTO clientDTO) {
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setNom(clientDTO.getNom());
        client.setPrenom(clientDTO.getPrenom());
        client.setEmail(clientDTO.getEmail());
        client.setNumTelephone(clientDTO.getNumTelephone());
        return client;
    }

    private Chambre mapToChambreEntity(ChambreDTO chambreDTO) {
        Chambre chambre = new Chambre();
        chambre.setId(chambreDTO.getId());
        chambre.setTypeChambre(TypeChambre.valueOf(chambreDTO.getTypeChambre()));
        chambre.setPrix(chambreDTO.getPrix());
        chambre.setDisponible(chambreDTO.getDisponible());
        chambre.setNumeroChambre(chambreDTO.getNumeroChambre());
        chambre.setDescription(chambreDTO.getDescription());
        return chambre;
    }
}
