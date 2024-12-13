package com.haytam.reservation.rest.controllers;

import com.haytam.reservation.rest.services.RestReservationService;
import com.haytam.reservation.core.dtos.ReservationDTO;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final RestReservationService reservationService;
    private final Counter reservationUpdatesCounter;

    @Autowired
    public ReservationController(RestReservationService reservationService, MeterRegistry meterRegistry) {
        this.reservationService = reservationService;
        this.reservationUpdatesCounter = Counter.builder("rest.reservation.updates")
                .tag("service", "reservation-rest")
                .register(meterRegistry);
    }

    @GetMapping
    public List<ReservationDTO> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable Long id) {
        ReservationDTO reservationDTO = reservationService.getReservationById(id);
        return reservationDTO != null ? ResponseEntity.ok(reservationDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO) {
        ReservationDTO savedReservation = reservationService.createReservation(reservationDTO);
        return new ResponseEntity<>(savedReservation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationDTO> updateReservation(@PathVariable Long id, @RequestBody ReservationDTO reservationDTO) {
        ReservationDTO updatedReservation = reservationService.updateReservation(id, reservationDTO);
        if (updatedReservation != null) {
            reservationUpdatesCounter.increment();
            return ResponseEntity.ok(updatedReservation);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}