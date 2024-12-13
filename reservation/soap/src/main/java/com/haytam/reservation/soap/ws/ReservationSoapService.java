package com.haytam.reservation.soap.ws;

import com.haytam.reservation.core.dtos.ChambreDTO;
import com.haytam.reservation.core.dtos.ClientDTO;
import com.haytam.reservation.core.dtos.ReservationDTO;
import com.haytam.reservation.core.entities.Chambre;
import com.haytam.reservation.core.entities.Client;
import com.haytam.reservation.core.entities.Reservation;
import com.haytam.reservation.core.entities.enums.StatusReservation;
import com.haytam.reservation.core.repositories.ReservationRepository;
import io.micrometer.core.instrument.Counter;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@WebService(serviceName = "ReservationWS")
public class ReservationSoapService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private Counter reservationCreateCounter;

    @Autowired
    private Counter reservationDeleteCounter;

    @Autowired
    private Counter reservationGetCounter;

    @WebMethod
    public List<ReservationDTO> getReservations() {
        reservationGetCounter.increment(); // Increment counter for getReservations
        return reservationRepository.findAll().stream()
                .map(this::mapReservationToDTO)
                .collect(Collectors.toList());
    }

    @WebMethod
    public ReservationDTO getReservationById(@WebParam(name = "id") Long id) {
        reservationGetCounter.increment(); // Increment counter for getReservationById
        return reservationRepository.findById(id)
                .map(this::mapReservationToDTO)
                .orElse(null);
    }

    @WebMethod
    public ReservationDTO createReservation(@WebParam(name = "clientId") Client client,
                                            @WebParam(name = "chambreId") Chambre chambre,
                                            @WebParam(name = "dateDebut") Date dateDebut,
                                            @WebParam(name = "dateFin") Date dateFin,
                                            @WebParam(name = "status") StatusReservation status,
                                            @WebParam(name = "nombrePersonnes") Integer nombrePersonnes) {
        Reservation reservation = new Reservation(null, client, chambre, dateDebut, dateFin, status, nombrePersonnes);
        Reservation savedReservation = reservationRepository.save(reservation);
        reservationCreateCounter.increment(); // Increment counter for createReservation
        return mapReservationToDTO(savedReservation);
    }

    @WebMethod
    public boolean deleteReservation(@WebParam(name = "id") Long id) {
        boolean deleted = false;
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
            deleted = true;
            reservationDeleteCounter.increment(); // Increment counter for deleteReservation
        }
        return deleted;
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
}
