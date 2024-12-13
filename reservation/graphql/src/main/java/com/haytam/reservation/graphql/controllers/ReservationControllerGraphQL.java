//package com.saad.reservation.graphql.controllers;
//
//import com.saad.reservation.core.dtos.ReservationDTO;
//import com.saad.reservation.graphql.services.GraphqlReservationService;
//import io.micrometer.core.instrument.Counter;
//import io.micrometer.core.instrument.MeterRegistry;
//import lombok.AllArgsConstructor;
//import org.springframework.graphql.data.method.annotation.Argument;
//import org.springframework.graphql.data.method.annotation.MutationMapping;
//import org.springframework.graphql.data.method.annotation.QueryMapping;
//import org.springframework.stereotype.Controller;
//
//import java.util.List;
//
//@Controller
//@AllArgsConstructor
//public class ReservationControllerGraphQL {
//
//    private final GraphqlReservationService reservationService;
//    private final MeterRegistry meterRegistry;
//    private final Counter reservationUpdatesCounter;
//
//    @MutationMapping
//    public ReservationDTO saveReservation(@Argument ReservationDTO reservationDTO) {
//        return reservationService.saveReservation(reservationDTO);
//    }
//
//    @MutationMapping
//    public ReservationDTO updateReservation(@Argument Long id, @Argument ReservationDTO reservationDTO) {
//        ReservationDTO updatedReservation = reservationService.updateReservation(id, reservationDTO);
//        if (updatedReservation != null) {
//            reservationUpdatesCounter.increment(); // Increment counter when an update happens
//        }
//        return updatedReservation;
//    }
//
//    @MutationMapping
//    public String deleteReservation(@Argument Long id) {
//        reservationService.deleteReservation(id);
//        return "Reservation deleted successfully";
//    }
//
//    @QueryMapping
//    public List<ReservationDTO> allReservations() {
//        return reservationService.getAllReservations();
//    }
//
//    @QueryMapping
//    public ReservationDTO reservationById(@Argument Long id) {
//        return reservationService.getReservationById(id);
//    }
//
//    @QueryMapping
//    public List<ReservationDTO> reservationsByStatus(@Argument String status) {
//        return reservationService.getReservationsByStatus(status);
//    }
//
//    @QueryMapping
//    public List<ReservationDTO> reservationsForClient(@Argument Long clientId) {
//        return reservationService.getReservationsForClient(clientId);
//    }
//
//    @QueryMapping
//    public List<ReservationDTO> reservationsForChambre(@Argument Long chambreId) {
//        return reservationService.getReservationsForChambre(chambreId);
//    }
//}

package com.haytam.reservation.graphql.controllers;

import com.haytam.reservation.graphql.input.ReservationInput;
import com.haytam.reservation.core.dtos.ReservationDTO;
import com.haytam.reservation.core.dtos.ClientDTO;
import com.haytam.reservation.core.dtos.ChambreDTO;
import com.haytam.reservation.graphql.services.GraphqlReservationService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@AllArgsConstructor
public class ReservationControllerGraphQL {

    private final GraphqlReservationService reservationService;
    private final MeterRegistry meterRegistry;
    private final Counter reservationUpdatesCounter;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @MutationMapping
    public ReservationDTO saveReservation(@Argument("reservationDTO") ReservationInput input) {
        ReservationDTO reservationDTO = convertInputToDTO(input);
        return reservationService.saveReservation(reservationDTO);
    }

    @MutationMapping
    public ReservationDTO updateReservation(@Argument Long id, @Argument("reservationDTO") ReservationInput input) {
        ReservationDTO reservationDTO = convertInputToDTO(input);
        ReservationDTO updatedReservation = reservationService.updateReservation(id, reservationDTO);
        if (updatedReservation != null) {
            reservationUpdatesCounter.increment();
        }
        return updatedReservation;
    }

    private ReservationDTO convertInputToDTO(ReservationInput input) {
        try {
            return ReservationDTO.builder()
                    .client(ClientDTO.builder().id(Long.valueOf(input.getClientId())).build())
                    .chambre(ChambreDTO.builder().id(Long.valueOf(input.getChambreId())).build())
                    .dateDebut(dateFormat.parse(input.getDateDebut()))
                    .dateFin(dateFormat.parse(input.getDateFin()))
                    .status(input.getStatus().toString())
                    .nombrePersonnes(input.getNombrePersonnes())
                    .build();
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format. Please use yyyy-MM-dd", e);
        }
    }

    @MutationMapping
    public String deleteReservation(@Argument Long id) {
        reservationService.deleteReservation(id);
        return "Reservation deleted successfully";
    }

    @QueryMapping
    public List<ReservationDTO> allReservations() {
        return reservationService.getAllReservations();
    }

    @QueryMapping
    public ReservationDTO reservationById(@Argument Long id) {
        return reservationService.getReservationById(id);
    }

    @QueryMapping
    public List<ReservationDTO> reservationsByStatus(@Argument String status) {
        return reservationService.getReservationsByStatus(status);
    }

    @QueryMapping
    public List<ReservationDTO> reservationsForClient(@Argument Long clientId) {
        return reservationService.getReservationsForClient(clientId);
    }

    @QueryMapping
    public List<ReservationDTO> reservationsForChambre(@Argument Long chambreId) {
        return reservationService.getReservationsForChambre(chambreId);
    }
}
