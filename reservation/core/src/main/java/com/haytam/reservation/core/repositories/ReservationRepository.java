package com.haytam.reservation.core.repositories;

import com.haytam.reservation.core.entities.enums.StatusReservation;
import com.haytam.reservation.core.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByClientId(Long clientId);

    List<Reservation> findByChambreId(Long chambreId);

    List<Reservation> findByStatus(StatusReservation status);
}
